/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.component;

import CAAYcyclic.SystemAdiminClient.controller.component.Jcombobox.IComboBoxDelegate;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Youssef
 */
public class CustomComboBox<T> extends JComboBox<T> {

    private Integer initialIndex = 0;

    private IComboBoxDelegate comboBoxDelegate;

    public CustomComboBox(ComboBoxModel<T> aModel) {
        super(aModel);
        this.addItemListener(itemListener);
    }

    public CustomComboBox(T[] items) {
        super(items);
        this.addItemListener(itemListener);
    }

    public CustomComboBox(Vector<T> items) {
        super(items);
        this.addItemListener(itemListener);
    }

    public CustomComboBox() {
        this.addItemListener(itemListener);
    }

    ItemListener itemListener = new ItemListener() {
        public void itemStateChanged(ItemEvent e) {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                selectedNewElement();
            }
        }
    };

    private void selectedNewElement() {
        comboBoxDelegate.didSelectRowAt(this, getSelectedIndex());
    }

    public void setInitialSelectedItem(T element) {
        this.setSelectedItem(element);
        initialIndex = this.getSelectedIndex();
    }

    public boolean isOriginalSelection() {
        if (this.getSelectedIndex() != initialIndex) {
            return false;
        }
        return true;
    }

    public T getSelectedRowValue() {
        if (this.getSelectedIndex() == 0) {
            return null;
        }

        return (T) this.getSelectedItem();
    }

    public void setComboBoxDelegate(IComboBoxDelegate comboBoxDelegate) {
        this.comboBoxDelegate = comboBoxDelegate;
    }

    public IComboBoxDelegate getComboBoxDelegate() {
        return comboBoxDelegate;
    }

}
