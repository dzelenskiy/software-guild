/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author DZ
 */
public class FXMLDocumentController implements Initializable {
    
    ObservableList<ToDoItem> items = FXCollections.observableArrayList();
    
    @FXML
    ListView list;
    
    @FXML
    TextField text;
    
    public void handleEnterOnText(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER && !text.getText().trim().isEmpty()) {
            addItem();
        }
    }
    
    public void addItem() {
        ToDoItem item = new ToDoItem(text.getText());
        items.add(item);
        text.setText("");
    }
    
    public void removeItem() {
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItems();
        items.remove(item);
    }
        
    public void toggleItem() {
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItems();
        if(item != null) {
            item.isDone = !item.isDone;
            list.refresh();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list.setItems(items);
    }    
    
}
