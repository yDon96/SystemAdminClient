/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class CustomJListTest {

    CustomJList instance;

    @Before
    public void setUp() {
        instance = new CustomJList();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of clearAllSelection method, of class CustomJList.
     */
    @Test
    public void testClearAllSelection() {
        System.out.println("clearAllSelection");
        instance.selectedRow.add(2);
        instance.selectedRow.add(3);
        instance.setSelectedIndex(3);
        instance.clearAllSelection();
        assertTrue(instance.selectedRow.isEmpty());
        assertEquals(-1, instance.getSelectedIndex());
    }

    /**
     * Test of setSelectedElement method, of class CustomJList.
     */
    @Test
    public void testSetSelectedElement() {
        System.out.println("setSelectedElement");
        List<String> expctedString = Arrays.asList("MyDescription1", "MyDescription2", "MyDescription3", "MyDescription4");
        Set<String> elementToSelect = new HashSet<>(Arrays.asList("MyDescription2", "MyDescription3"));
        List<Integer>  expIndex = Arrays.asList(1, 2);
        DefaultListModel demoList = new DefaultListModel();
        for (String string : expctedString) {
            demoList.addElement(string);
        }
        instance.setModel(demoList);
        instance.setSelectedElement(elementToSelect);
        assertEquals(expIndex, instance.getSelectedRow());
    }

    /**
     * Test of convertIntegers method, of class CustomJList.
     */
    @Test
    public void testConvertIntegers() {
        System.out.println("convertIntegers");
        List<Integer> integers = Arrays.asList(2, 3);
        int[] expResult = new int[]{2, 3};
        int[] result = instance.convertIntegers(integers);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getSelectedRow method, of class CustomJList.
     */
    @Test
    public void testGetSelectedRow() {
        System.out.println("getSelectedRow");
        List<Integer> expResult = Arrays.asList(2, 3);
        instance.selectedRow.addAll(expResult);
        ArrayList<Integer> result = instance.getSelectedRow();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSelectionChanged method, of class CustomJList.
     */
    @Test
    public void shouldBeFalseIsSelectionChangedIfNothingIsSet() {
        System.out.println("isSelectionChanged");
        assertEquals(false, instance.isSelectionChanged());
    }

    /**
     * Test of isSelectionChanged method, of class CustomJList.
     */
    @Test
    public void shouldBeFalseIsSelectionChangedIfOriginalSelectedRowIsEqualToSelectedRow() {
        System.out.println("isSelectionChanged");
        List<Integer> expResult = Arrays.asList(2, 3);
        instance.originalSelectedRow = new ArrayList();
        instance.originalSelectedRow.addAll(expResult);
        instance.selectedRow.addAll(expResult);
        assertEquals(false, instance.isSelectionChanged());
    }

    /**
     * Test of isSelectionChanged method, of class CustomJList.
     */
    @Test
    public void shouldBeTrueIsSelectionChangedIfOriginalSelectedRowIsNullAndSelectedRowIsNotNull() {
        System.out.println("isSelectionChanged");
        List<Integer> expResult = Arrays.asList(2, 3);
        instance.selectedRow.addAll(expResult);
        assertEquals(true, instance.isSelectionChanged());
    }

    /**
     * Test of isSelectionChanged method, of class CustomJList.
     */
    @Test
    public void shouldBeTrueIsSelectionChangedIfOriginalSelectedRowIsNotEqualToSelectedRow() {
        System.out.println("isSelectionChanged");
        instance.originalSelectedRow = new ArrayList();
        instance.originalSelectedRow.addAll(Arrays.asList(2, 3));
        instance.selectedRow.addAll(Arrays.asList(2, 3, 4));
        assertEquals(true, instance.isSelectionChanged());
    }

}
