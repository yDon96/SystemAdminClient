/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.component;

import CAAYcyclic.SystemAdiminClient.controller.component.Jcombobox.IComboBoxDelegate;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class CustomComboBoxTest {
    
    CustomComboBox<String> instance;
    
    @Before
    public void setUp() {
        instance = new CustomComboBox(new javax.swing.DefaultComboBoxModel<>(new String[] { "none" }));
        instance.setComboBoxDelegate(comboxDel);
    }

    /**
     * Test of setInitialSelectedItem method, of class CustomComboBox.
     */
    @Test
    public void testSetInitialSelectedItem() {
        System.out.println("setInitialSelectedItem");
        List<String> expctedString = Arrays.asList("MyDescription1", "MyDescription2", "MyDescription3", "MyDescription4");
        String expectedString = "MyDescription2";
        for(String value: expctedString){
            instance.addItem(value);
        }
        instance.setInitialSelectedItem(expectedString);
        assertEquals(expectedString, expectedString);
    }

    /**
     * Test of isOriginalSelection method, of class CustomComboBox.
     */
    @Test
    public void testIsOriginalSelection() {
        System.out.println("isOriginalSelection");
        List<String> expctedString = Arrays.asList("MyDescription1", "MyDescription2", "MyDescription3", "MyDescription4");
        String expectedString = "MyDescription2";
        for(String value: expctedString){
            instance.addItem(value);
        }
        instance.setInitialSelectedItem(expectedString);
        boolean expResult = true;
        instance.setSelectedIndex(2);
        boolean result = instance.isOriginalSelection();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isOriginalSelection method, of class CustomComboBox.
     */
    @Test
    public void shouldBeFalseIsOriginalSelectionIfChangeSelection() {
        System.out.println("isOriginalSelection");
        List<String> expctedString = Arrays.asList("MyDescription1", "MyDescription2", "MyDescription3", "MyDescription4");
        String expectedString = "MyDescription2";
        for(String value: expctedString){
            instance.addItem(value);
        }
        instance.setInitialSelectedItem(expectedString);
        boolean expResult = false;
        instance.setSelectedIndex(3);
        boolean result = instance.isOriginalSelection();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSelectedRowValue method, of class CustomComboBox.
     */
    @Test
    public void testGetSelectedRowValue() {
        System.out.println("getSelectedRowValue");
        List<String> expctedString = Arrays.asList("MyDescription1", "MyDescription2", "MyDescription3", "MyDescription4");
        String expectedString = "MyDescription2";
        for(String value: expctedString){
            instance.addItem(value);
        }
        instance.setInitialSelectedItem(expectedString);
        String result = instance.getSelectedRowValue();
        assertEquals(expectedString, result);
    }

    /**
     * Test of setComboBoxDelegate method, of class CustomComboBox.
     */
    @Test
    public void testSetComboBoxDelegate() {
        System.out.println("setComboBoxDelegate");
        assertEquals(comboxDel, instance.comboBoxDelegate);
    }

    /**
     * Test of getComboBoxDelegate method, of class CustomComboBox.
     */
    @Test
    public void testGetComboBoxDelegate() {
        System.out.println("getComboBoxDelegate");
        IComboBoxDelegate result = instance.getComboBoxDelegate();
        assertEquals(comboxDel, result);
    }
    
    
    private IComboBoxDelegate comboxDel = new IComboBoxDelegate(){
        @Override
        public void didSelectRowAt(JComboBox combobox, Integer selectedIndexRow) {
            
        }

        @Override
        public void didDeselectRowAt(JComboBox combobox, Integer deselectedIndexRow) {
        }
    };
}
