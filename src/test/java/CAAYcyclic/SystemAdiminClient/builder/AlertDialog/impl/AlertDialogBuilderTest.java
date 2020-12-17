/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.builder.AlertDialog.impl;

import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class AlertDialogBuilderTest {
    
    AlertDialogBuilder instance;
    
    @Before
    public void setUp() {
        instance = new AlertDialogBuilder();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setParentFrame method, of class AlertDialogBuilder.
     */
    @Test
    public void testSetParentFrame() {
        System.out.println("setParentFrame");
        JFrame parentFrame = new JFrame();
        instance.setParentFrame(parentFrame);
        assertEquals(parentFrame, instance.parentFrame);
    }

    /**
     * Test of setTitle method, of class AlertDialogBuilder.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        AlertDialogBuilder instance = new AlertDialogBuilder();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessage method, of class AlertDialogBuilder.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        AlertDialogBuilder instance = new AlertDialogBuilder();
        instance.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPositiveButton method, of class AlertDialogBuilder.
     */
    @Test
    public void testSetPositiveButton() {
        System.out.println("setPositiveButton");
        String value = "";
        MouseAdapter action = null;
        AlertDialogBuilder instance = new AlertDialogBuilder();
        instance.setPositiveButton(value, action);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNegativeButton method, of class AlertDialogBuilder.
     */
    @Test
    public void testSetNegativeButton() {
        System.out.println("setNegativeButton");
        String value = "";
        MouseAdapter action = null;
        AlertDialogBuilder instance = new AlertDialogBuilder();
        instance.setNegativeButton(value, action);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of show method, of class AlertDialogBuilder.
     */
    @Test
    public void testShow() {
        System.out.println("show");
        AlertDialogBuilder instance = new AlertDialogBuilder();
        instance.show();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dispose method, of class AlertDialogBuilder.
     */
    @Test
    public void testDispose() {
        System.out.println("dispose");
        AlertDialogBuilder instance = new AlertDialogBuilder();
        instance.dispose();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDefaultPositiveAction method, of class AlertDialogBuilder.
     */
    @Test
    public void testSetDefaultPositiveAction() {
        System.out.println("setDefaultPositiveAction");
        AlertDialogBuilder instance = new AlertDialogBuilder();
        instance.setDefaultPositiveAction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDefaultNegativeAction method, of class AlertDialogBuilder.
     */
    @Test
    public void testSetDefaultNegativeAction() {
        System.out.println("setDefaultNegativeAction");
        AlertDialogBuilder instance = new AlertDialogBuilder();
        instance.setDefaultNegativeAction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
