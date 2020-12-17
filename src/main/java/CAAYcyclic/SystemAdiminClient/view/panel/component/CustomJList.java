/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.component;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author Youssef
 */
public class CustomJList<E> extends JList<E> {

    protected ArrayList<Integer> originalSelectedRow;
    protected ArrayList<Integer> selectedRow;

    public CustomJList(ListModel<E> dataModel) {
        super(dataModel);
        initSelectedRow();
    }

    public CustomJList(E[] listData) {
        super(listData);
        initSelectedRow();
    }

    public CustomJList(Vector<? extends E> listData) {
        super(listData);
        initSelectedRow();
    }

    public CustomJList() {
        initSelectedRow();
    }

    public void clearAllSelection() {
        clearSelection();
        selectedRow.clear();
    }
    
    

    private void initSelectedRow() {
        this.addMouseListener(listSelectionListener);
        selectedRow = new ArrayList<>();
        for (int element : getSelectedIndices()) {
            selectedRow.add(element);
        }
    }

    public void setSelectedElement(Set<E> elementToSelect) {
        originalSelectedRow = new ArrayList<>();
        DefaultListModel model = (DefaultListModel) getModel();
        elementToSelect.forEach(element -> {
            selectedRow.add(model.indexOf(element));
        });
        originalSelectedRow.addAll(selectedRow);
        setSelectedIndices(convertIntegers(selectedRow));
    }

    MouseAdapter listSelectionListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
            JList list = (JList) evt.getSource();
            Integer index = list.locationToIndex(evt.getPoint());
            handleClick(index);
        }
    };
    
    private void handleClick(int indexRow){
        if(isEnabled()){
            if (selectedRow.contains(indexRow)) {
                clearSelection();
                setSelectedIndices(convertIntegers(selectedRow));
            } else {
                clearSelection();
                selectedRow.add(indexRow);
                setSelectedIndices(convertIntegers(selectedRow));
            }
        }
    }

    public int[] convertIntegers(List<Integer> integers) {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    public ArrayList<Integer> getSelectedRow() {
        return selectedRow;
    }
    
    public boolean isSelectionChanged(){
        if(originalSelectedRow == null && selectedRow.isEmpty()){
            return false;
        }
        
        if(originalSelectedRow == null && !selectedRow.isEmpty()){
            return true;
        }
        
        return !originalSelectedRow.equals(selectedRow);
    }

}
