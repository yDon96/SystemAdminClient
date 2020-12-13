/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Youssef
 */
public class CustomJTable extends JTable{

    public CustomJTable() {
    }

    public CustomJTable(TableModel dm) {
        super(dm);
    }

    public CustomJTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
    }

    public CustomJTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
    }

    public CustomJTable(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    public CustomJTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
    }
    
    
    
    @Override
    public void changeSelection(int rowIndex, int columnIndex,
            boolean toggle, boolean extend) {
        super.changeSelection(rowIndex, columnIndex, true, false);
    }
    
    @Override
    public boolean isCellEditable(int row, int column){  
        return false;  
    }
}
