/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.component.jtable;

import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Youssef
 */
public interface ITableDataSource<T> {
    
    Integer numberOfRow(JTable table);

    Object[] tablePanel(JTable table, Integer cellForRowAt);
    
    public void setElementToDisplay(List<T> elementToDisplay);
}
