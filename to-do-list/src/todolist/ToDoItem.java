/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

/**
 *
 * @author DZ
 */
public class ToDoItem {
    boolean isDone;
    String text;
    
    public ToDoItem (String text) {
        this.text = text;
        this.isDone = false;
    }
    
    @Override
    public String toString() {
        return text + (isDone ? " (done)" : "");
    }
}
