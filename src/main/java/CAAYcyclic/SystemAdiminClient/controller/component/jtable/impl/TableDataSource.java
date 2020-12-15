/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.component.jtable.impl;

import CAAYcyclic.SystemAdiminClient.controller.component.jtable.ITableDataSource;
import CAAYcyclic.SystemAdiminClient.model.Parcelable;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Youssef
 */
public class TableDataSource<T extends Parcelable> implements ITableDataSource<T>{

    private List<T> elementToDisplay;
    
    @Override
    public Object[] tablePanel(JTable table, Integer cellForRowAt) {
        if(elementToDisplay != null && !elementToDisplay.isEmpty()){
            return elementToDisplay.get(cellForRowAt).convetToObjectArray();
        }
        
        return null;
    }

    @Override
    public Integer numberOfRow(JTable table) {
        if(elementToDisplay != null && !elementToDisplay.isEmpty()){
            return elementToDisplay.size();
        }
        return 0;
    }

    public void setElementToDisplay(List<T> elementToDisplay) {
        this.elementToDisplay = elementToDisplay;
    }
    
}
