/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.dto.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author DZ
 */
public class VendingDaoDBImpl implements VendingDao {

    private Map<Integer, Item> items = new HashMap<>();

    private static final String SQL_SELECT_ALL_ITEM = "select * from item";
    private static final String SQL_SELECT_ITEM = "select * from item where id = ?";
    private static final String SQL_UPDATE_ITEM = "update item set quantity = ? where id = ?";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void loadInventory() throws VendingInventoryPersistenceException {
        List<Item> itemList = jdbcTemplate.query(SQL_SELECT_ALL_ITEM, new ItemMapper());
        for (Item currentItem : itemList) {
            Item newItem = new Item(currentItem.getId());
            newItem.setName(currentItem.getName());
            newItem.setPrice(currentItem.getPrice());
            newItem.setQuantity(currentItem.getQuantity());
            items.put(newItem.getId(), newItem);
        }
    }

    @Override
    public void saveInventory() throws VendingInventoryPersistenceException {
        List<Item> itemList = this.getAllItems();
        for (Item currentItem : itemList) {
            jdbcTemplate.update(SQL_UPDATE_ITEM,
                    currentItem.getQuantity(),
                    currentItem.getId());
        }

    }

    @Override
    public List<Item> getAllItems() throws VendingInventoryPersistenceException {
        //loadInventory();
        return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(int id) throws VendingInventoryPersistenceException {
        loadInventory();
        return items.get(id);
    }

    private static final class ItemMapper implements RowMapper<Item> {

        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setPrice(rs.getBigDecimal("price").toString());
            item.setQuantity(rs.getInt("quantity"));
            return item;
        }
    }

}
