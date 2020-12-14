/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.component;

import javax.swing.JComboBox;

/**
 *
 * @author Youssef
 */
public class CustomComboBox<T> extends JComboBox<T>{
    
    private Integer initialIndex = 0;

    public void setInitialSelectedItem(T element) {
        this.setSelectedItem(element);
        initialIndex = this.getSelectedIndex();
    }
    
    
    public boolean isOriginalSelection(){
        if(this.getSelectedIndex() != initialIndex){
            return false;
        }
        return true;
    }
    
    public T getSelectedRowValue(){
        if(this.getSelectedIndex() == 0){
            return null;
        }
        
        return (T) this.getSelectedItem();
    }
}
