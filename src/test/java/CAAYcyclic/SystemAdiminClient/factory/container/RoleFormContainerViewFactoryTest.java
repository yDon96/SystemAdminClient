/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.factory.container;

import CAAYcyclic.SystemAdiminClient.controller.IPanelController;
import CAAYcyclic.SystemAdiminClient.controller.bar.BackBarController;
import CAAYcyclic.SystemAdiminClient.controller.content.form.procedure.AddProcedureFormPanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.form.role.RoleFormPanelController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class RoleFormContainerViewFactoryTest {
    
    IContainerViewAbstractFactory instance;
    
    @Before
    public void setUp() {
        instance = new RoleFormContainerViewFactory();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBarController method, of class RoleFormContainerViewFactory.
     */
    @Test
    public void testGetBarController() {
        System.out.println("getBarController");
        IPanelController result = instance.getBarController();
        assertEquals(BackBarController.class, result.getClass());
    }

    /**
     * Test of getContentPanelController method, of class RoleFormContainerViewFactory.
     */
    @Test
    public void testGetContentPanelController() {
        System.out.println("getContentPanelController");
        IPanelController result = instance.getContentPanelController();
        assertEquals(RoleFormPanelController.class, result.getClass());
    }
    
    /**
     * Test of getContentPanelController method, of class AddProcedureContainerViewFactory.
     */
    @Test
    public void shouldGetContentPanelControllerBeNotEqualIfNotRoleFormPanelController() {
        System.out.println("getContentPanelController");
        IPanelController result = instance.getContentPanelController();
        assertNotEquals(AddProcedureFormPanelController.class, result.getClass());
    }
}
