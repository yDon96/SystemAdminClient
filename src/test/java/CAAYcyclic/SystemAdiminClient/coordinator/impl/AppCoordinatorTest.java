/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.coordinator.impl;

import CAAYcyclic.SystemAdiminClient.builder.AlertDialog.IAlertBuilder;
import CAAYcyclic.SystemAdiminClient.model.Parcelable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class AppCoordinatorTest {
    
    public AppCoordinatorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of start method, of class AppCoordinator.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        AppCoordinator instance = null;
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of switchPanelToDashboard method, of class AppCoordinator.
     */
    @Test
    public void testSwitchPanelToDashboard() {
        System.out.println("switchPanelToDashboard");
        AppCoordinator instance = null;
        instance.switchPanelToDashboard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of switchPanelToProcedurePanel method, of class AppCoordinator.
     */
    @Test
    public void testSwitchPanelToProcedurePanel() {
        System.out.println("switchPanelToProcedurePanel");
        AppCoordinator instance = null;
        instance.switchPanelToProcedurePanel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of switchPanelToUserPanel method, of class AppCoordinator.
     */
    @Test
    public void testSwitchPanelToUserPanel() {
        System.out.println("switchPanelToUserPanel");
        AppCoordinator instance = null;
        instance.switchPanelToUserPanel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of navigateToUserForm method, of class AppCoordinator.
     */
    @Test
    public void testNavigateToUserForm() {
        System.out.println("navigateToUserForm");
        AppCoordinator instance = null;
        instance.navigateToUserForm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of popBack method, of class AppCoordinator.
     */
    @Test
    public void testPopBack() {
        System.out.println("popBack");
        AppCoordinator instance = null;
        instance.popBack();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showAlert method, of class AppCoordinator.
     */
    @Test
    public void testShowAlert() {
        System.out.println("showAlert");
        IAlertBuilder alert = null;
        AppCoordinator instance = null;
        instance.showAlert(alert);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of navigateToProcedureForm method, of class AppCoordinator.
     */
    @Test
    public void testNavigateToProcedureForm() {
        System.out.println("navigateToProcedureForm");
        Parcelable procedure = null;
        AppCoordinator instance = null;
        instance.navigateToProcedureForm(procedure);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
