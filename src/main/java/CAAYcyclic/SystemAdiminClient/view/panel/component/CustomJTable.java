/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.component;

import CAAYcyclic.SystemAdiminClient.controller.component.jtable.ITableDataSource;
import CAAYcyclic.SystemAdiminClient.controller.component.jtable.ITableDelegate;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Youssef
 */
public class CustomJTable extends JTable{
    
    private ITableDataSource iTableDataSource;
    
    private ITableDelegate tableDelegate;
    
    private Integer lastRowSelected = -1;

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

    public void setiTableDataSource(ITableDataSource iTableDataSource) {
        this.iTableDataSource = iTableDataSource;
        refreshData();
    }

    public ITableDataSource getiTableDataSource() {
        return iTableDataSource;
    }

    public void setTableDelegate(ITableDelegate tableDelegate) {
        this.tableDelegate = tableDelegate;
    }
    
    public void refreshData(){
        DefaultTableModel model = (DefaultTableModel) this.dataModel;
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Integer newRowNumber = iTableDataSource.numberOfRow(this);
        for(int indexRow=0; indexRow< newRowNumber; indexRow++) {
            model.addRow(iTableDataSource.tablePanel(this, indexRow));
        }
    }
    
    @Override
    public void changeSelection(int rowIndex, int columnIndex,
            boolean toggle, boolean extend) {
        super.changeSelection(rowIndex, columnIndex, true, false);
        handleSelection();
    }
    
    private void handleSelection(){
        if(tableDelegate != null){
            int rowIndex = this.getSelectedRow();
            if(rowIndex < 0){
                tableDelegate.didDeselectRowAt(this, lastRowSelected);
                lastRowSelected = -1;
            } else {
                lastRowSelected = rowIndex;
                tableDelegate.didSelectRowAt(this, lastRowSelected);
            }
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int column){  
        return false;  
    }
}
