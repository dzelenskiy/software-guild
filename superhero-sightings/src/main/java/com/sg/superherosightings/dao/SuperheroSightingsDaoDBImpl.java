/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.HeroVillain;
import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Sighting;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DZ
 */
public class SuperheroSightingsDaoDBImpl implements SuperheroSightingsDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //HeroVillain Methods ============================================================================================================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addHeroVillain(HeroVillain heroVillain) {
        jdbcTemplate.update(
                "insert into HeroVillain (Name, Description, Power) values (?, ?, ?)",
                heroVillain.getName(),
                heroVillain.getDescription(),
                heroVillain.getPower()
        );
        heroVillain.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void updateHeroVillain(HeroVillain heroVillain) {
        jdbcTemplate.update(
                "update HeroVillain set Name = ?, Description = ?, Power = ? where ID = ?",
                heroVillain.getName(),
                heroVillain.getDescription(),
                heroVillain.getPower(),
                heroVillain.getId()
        );
    }

    @Override
    public void deleteHeroVillain(int id) {
        jdbcTemplate.update(
                "delete from HeroVillain_Sighting where HeroVillainID = ?",
                id
        );
        jdbcTemplate.update(
                "delete from HeroVillain_Organization where HeroVillainID = ?",
                id
        );
        jdbcTemplate.update(
                "delete from HeroVillain where ID = ?",
                id
        );
    }

    @Override
    public HeroVillain getHeroVillainById(int id) {
        try {
            HeroVillain heroVillain = jdbcTemplate.queryForObject(
                    "select * from HeroVillain where ID = ?",
                    new HeroVillainMapper(),
                    id
            );
            return heroVillain;
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<HeroVillain> getHeroVillainsBySightingId(int sightingId) {
        try {
            List<HeroVillain> heroVillains = jdbcTemplate.query(
                    "select * from HeroVillain hv join HeroVillain_Sighting hvs on hvs.HeroVillainID = hv.ID"
                    + " where hvs.SightingID = ?",
                    new HeroVillainMapper(),
                    sightingId
            );
            return heroVillains;
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<HeroVillain> getHeroVillainsByOrganizationId(int organizationId) {
        try {
            List<HeroVillain> heroVillains = jdbcTemplate.query(
                    "select * from HeroVillain hv join HeroVillain_Organization hvo on hvo.HeroVillainID = hv.ID"
                    + " where hvo.OrganizationID = ?",
                    new HeroVillainMapper(),
                    organizationId
            );
            return heroVillains;
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<HeroVillain> getAllHeroVillains() {
        return jdbcTemplate.query("select * from HeroVillain", new HeroVillainMapper());
    }

    //Location Methods ================================================================================================================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addLocation(Location location) {
        jdbcTemplate.update(
                "insert into Location (Name, Description, Address, City, State, Latitude, Longitude) values (?, ?, ?, ?, ?, ?, ?)",
                location.getName(),
                location.getDescription(),
                location.getAddress(),
                location.getCity(),
                location.getState(),
                location.getLatitude(),
                location.getLongitude()
        );
        location.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void updateLocation(Location location) {
        jdbcTemplate.update(
                "update Location set Name = ?, Description = ?, Address = ?, City = ?, State = ?, Latitude = ?, Longitude = ? where ID = ?",
                location.getName(),
                location.getDescription(),
                location.getAddress(),
                location.getCity(),
                location.getState(),
                location.getLatitude(),
                location.getLongitude(),
                location.getId()
        );
    }

    @Override
    public void deleteLocation(int id) {
        jdbcTemplate.update("delete HeroVillain_Sighting from HeroVillain_Sighting join Sighting on"
                + " Sighting.ID = HeroVillain_Sighting.SightingID where Sighting.LocationID = ?", id);
        jdbcTemplate.update("delete from Sighting where LocationID = ?", id);
        jdbcTemplate.update("delete from Location where ID = ?", id);
    }

    @Override
    public Location getLocationById(int id) {
        try {
            Location location = jdbcTemplate.queryForObject(
                    "select * from Location where ID = ?",
                    new LocationMapper(),
                    id
            );
            return location;
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public Location getLocationBySightingId(int sightingId) {
        try {
            Location location = jdbcTemplate.queryForObject(
                    "select * from Location l join Sighting s on s.LocationID = l.ID where s.ID = ?",
                    new LocationMapper(),
                    sightingId
            );
            return location;
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<Location> getAllLocations() {
        return jdbcTemplate.query("select * from Location", new LocationMapper());
    }

    //Organization Methods ============================================================================================================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addOrganization(Organization organization) {
        jdbcTemplate.update(
                "insert into Organization (Name, Description, Address, City, State, Phone, Email, Website)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)",
                organization.getName(),
                organization.getDescription(),
                organization.getAddress(),
                organization.getCity(),
                organization.getState(),
                organization.getPhone(),
                organization.getEmail(),
                organization.getWebsite()
        );
        organization.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        insertHVsAndOrgsIntoHVOrg(organization);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateOrganization(Organization organization) {
        jdbcTemplate.update(
                "update Organization set Name = ?, Description = ?, Address = ?, City = ?, State = ?, Phone = ?,"
                + " Email = ?, Website = ? where ID = ?",
                organization.getName(),
                organization.getDescription(),
                organization.getAddress(),
                organization.getCity(),
                organization.getState(),
                organization.getPhone(),
                organization.getEmail(),
                organization.getWebsite(),
                organization.getId()
        );
        jdbcTemplate.update(
                "delete from HeroVillain_Organization where OrganizationID = ?",
                organization.getId()
        );
        insertHVsAndOrgsIntoHVOrg(organization);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteOrganization(int id) {
        jdbcTemplate.update(
                "delete from HeroVillain_Organization where OrganizationID = ?",
                id
        );
        jdbcTemplate.update(
                "delete from Organization where ID = ?",
                id
        );
    }

    @Override
    public Organization getOrganizationById(int id) {
        try {
            Organization organization = jdbcTemplate.queryForObject(
                    "select * from Organization where ID = ?",
                    new OrganizationMapper(),
                    id
            );
            organization.setHeroVillains(getHVsForOrg(organization));
            return organization;
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<Organization> getOrganizationsByHeroVillainId(int heroVillainId) {
        try {
            List<Organization> organizations = jdbcTemplate.query(
                    "select * from Organization o join HeroVillain_Organization hvo on hvo.OrganizationID = o.ID"
                    + " where hvo.HeroVillainID = ?",
                    new OrganizationMapper(),
                    heroVillainId
            );
            return associateHVsWithOrgs(organizations);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        List<Organization> organizations = jdbcTemplate.query(
                "select * from Organization",
                new OrganizationMapper()
        );
        return associateHVsWithOrgs(organizations);
    }

    //Sighting Methods ================================================================================================================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addSighting(Sighting sighting) {
        jdbcTemplate.update(
                "insert into Sighting (Date, LocationID) values (?, ?)",
                java.sql.Date.valueOf(sighting.getDate()),
                sighting.getLocation().getId()
        );
        sighting.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        insertHVsAndSightsIntoHVSight(sighting);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(
                "update Sighting set Date = ?, LocationID = ? where ID = ?",
                java.sql.Date.valueOf(sighting.getDate()),
                sighting.getLocation().getId(),
                sighting.getId()
        );
        jdbcTemplate.update(
                "delete from HeroVillain_Sighting where SightingID = ?",
                sighting.getId()
        );
        insertHVsAndSightsIntoHVSight(sighting);
    }

    @Override
    public void deleteSighting(int id) {
        jdbcTemplate.update(
                "delete from HeroVillain_Sighting where SightingID = ?",
                id
        );
        jdbcTemplate.update(
                "delete from Sighting where ID = ?",
                id
        );
    }

    @Override
    public Sighting getSightingById(int id) {
        try {
            Sighting sighting = jdbcTemplate.queryForObject(
                    "select * from Sighting where ID = ?",
                    new SightingMapper(),
                    id
            );
            sighting.setLocation(getLocForSight(sighting));
            sighting.setHeroVillains(getHVsForSights(sighting));
            return sighting;
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<Sighting> getAllSightingsByDate(LocalDate date) {
        try {
            List<Sighting> sightings = jdbcTemplate.query(
                    "select * from Sighting where Date = ?",
                    new SightingMapper(),
                    java.sql.Date.valueOf(date)
            );
            return associateLocsAndHVsWithSight(sightings);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<Sighting> getAllSightingsByLocationId(int locationId) {
        try {
            List<Sighting> sightings = jdbcTemplate.query(
                    "select * from Sighting where LocationID = ?",
                    new SightingMapper(),
                    locationId
            );
            return associateLocsAndHVsWithSight(sightings);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<Sighting> getAllSightingsByHeroVillainId(int heroVillainId) {
        try {
            List<Sighting> sightings = jdbcTemplate.query(
                    "select * from Sighting s join HeroVillain_Sighting hvs on hvs.SightingID = s.ID where hvs.HeroVillainID = ?",
                    new SightingMapper(),
                    heroVillainId
            );
            return associateLocsAndHVsWithSight(sightings);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        }
    }

    @Override
    public List<Sighting> getAllSightings() {
        List<Sighting> sightings = jdbcTemplate.query("select * from Sighting", new SightingMapper());
        return associateLocsAndHVsWithSight(sightings);
    }

    @Override
    public List<Sighting> getLastTenSightings() {
        List<Sighting> sightings = jdbcTemplate.query(
                "select * from Sighting order by `Date` desc limit 10",
                new SightingMapper()
        );
        return associateLocsAndHVsWithSight(sightings);

    }

    //HelperMethods ===================================================================================================================
    private void insertHVsAndOrgsIntoHVOrg(Organization organization) {
        final int organizationId = organization.getId();
        final List<HeroVillain> heroVillains = organization.getHeroVillains();

        for (HeroVillain heroVillain : heroVillains) {
            jdbcTemplate.update(
                    "insert into HeroVillain_Organization (HeroVillainID, OrganizationID) values (?, ?)",
                    heroVillain.getId(),
                    organizationId
            );
        }
    }

    private List<HeroVillain> getHVsForOrg(Organization organization) {
        return jdbcTemplate.query(
                "select hv.ID, hv.Name, hv.Description, hv.Power from HeroVillain hv"
                + " join HeroVillain_Organization hvo on hv.ID = hvo.HeroVillainID where hvo.OrganizationID = ?",
                new HeroVillainMapper(),
                organization.getId()
        );
    }

    private List<Organization> associateHVsWithOrgs(List<Organization> organizations) {
        for (Organization organization : organizations) {
            organization.setHeroVillains(getHVsForOrg(organization));
        }
        return organizations;
    }

    private Location getLocForSight(Sighting sighting) {
        return jdbcTemplate.queryForObject(
                "select l.ID, l.Name, l.Description, l.Address, l.City, l.State, l.Latitude, l.Longitude from Location l"
                + " join Sighting s on l.ID = s.LocationID where s.ID = ?",
                new LocationMapper(),
                sighting.getId()
        );
    }

    private void insertHVsAndSightsIntoHVSight(Sighting sighting) {
        final int sightingId = sighting.getId();
        final List<HeroVillain> heroVillains = sighting.getHeroVillains();

        for (HeroVillain heroVillain : heroVillains) {
            jdbcTemplate.update(
                    "insert into HeroVillain_Sighting (HeroVillainID, SightingID) values (?, ?)",
                    heroVillain.getId(),
                    sightingId
            );
        }
    }

    private List<HeroVillain> getHVsForSights(Sighting sighting) {
        return jdbcTemplate.query(
                "select hv.ID, hv.Name, hv.Description, hv.Power from HeroVillain hv"
                + " join HeroVillain_Sighting hvs on hvs.HeroVillainID = hv.ID where hvs.SightingID = ?",
                new HeroVillainMapper(),
                sighting.getId()
        );
    }

    private List<Sighting> associateLocsAndHVsWithSight(List<Sighting> sightings) {
        for (Sighting sighting : sightings) {
            sighting.setLocation(getLocForSight(sighting));
            sighting.setHeroVillains(getHVsForSights(sighting));
        }
        return sightings;

    }

    //Mappers =========================================================================================================================
    private static final class HeroVillainMapper implements RowMapper<HeroVillain> {

        @Override
        public HeroVillain mapRow(ResultSet rs, int i) throws SQLException {
            HeroVillain heroVillain = new HeroVillain();
            heroVillain.setId(rs.getInt("ID"));
            heroVillain.setName(rs.getString("Name"));
            heroVillain.setDescription(rs.getString("Description"));
            heroVillain.setPower(rs.getString("Power"));
            return heroVillain;
        }
    }

    private static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location location = new Location();
            location.setId(rs.getInt("ID"));
            location.setName(rs.getString("Name"));
            location.setDescription(rs.getString("Description"));
            location.setAddress(rs.getString("Address"));
            location.setCity(rs.getString("City"));
            location.setState(rs.getString("State"));
            location.setLatitude(rs.getDouble("Latitude"));
            location.setLongitude(rs.getDouble("Longitude"));
            return location;
        }
    }

    private static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization organization = new Organization();
            organization.setId(rs.getInt("ID"));
            organization.setName(rs.getString("Name"));
            organization.setDescription(rs.getString("Description"));
            organization.setAddress(rs.getString("Address"));
            organization.setCity(rs.getString("City"));
            organization.setState(rs.getString("State"));
            organization.setPhone(rs.getString("Phone"));
            organization.setEmail(rs.getString("Email"));
            organization.setWebsite(rs.getString("Website"));
            return organization;
        }

    }

    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting sighting = new Sighting();
            sighting.setId(rs.getInt("ID"));
            sighting.setDate(rs.getTimestamp("Date").toLocalDateTime().toLocalDate());
            return sighting;
        }

    }

}
