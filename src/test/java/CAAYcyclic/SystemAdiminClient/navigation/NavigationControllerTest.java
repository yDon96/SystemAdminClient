/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.navigation;

import CAAYcyclic.SystemAdiminClient.controller.IPanelController;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class NavigationControllerTest {
    
    public NavigationControllerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of performPanelNavigationTo method, of class NavigationController.
     */
    @Test
    public void testPerformPanelNavigationTo() {
        System.out.println("performPanelNavigationTo");
        IPanelController panelController = null;
        NavigationController instance = null;
        instance.performPanelNavigationTo(panelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrivePanelFromMap method, of class NavigationController.
     */
    @Test
    public void testRetrivePanelFromMap() {
        System.out.println("retrivePanelFromMap");
        String panelName = "";
        NavigationController instance = null;
        IPanelController expResult = null;
        IPanelController result = instance.retrivePanelFromMap(panelName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of performBackToStack method, of class NavigationController.
     */
    @Test
    public void testPerformBackToStack() {
        System.out.println("performBackToStack");
        NavigationController instance = null;
        instance.performBackToStack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPanelToMap method, of class NavigationController.
     */
    @Test
    public void testAddPanelToMap() {
        System.out.println("addPanelToMap");
        IPanelController contentPanelController = null;
        NavigationController instance = null;
        instance.addPanelToMap(contentPanelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of performViewNavigationTo method, of class NavigationController.
     */
    @Test
    public void testPerformViewNavigationTo() {
        System.out.println("performViewNavigationTo");
        IPanelController barController = null;
        IPanelController contentPanelController = null;
        NavigationController instance = null;
        instance.performViewNavigationTo(barController, contentPanelController);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentFrame method, of class NavigationController.
     */
    @Test
    public void testGetCurrentFrame() {
        System.out.println("getCurrentFrame");
        NavigationController instance = null;
        JFrame expResult = null;
        JFrame result = instance.getCurrentFrame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
