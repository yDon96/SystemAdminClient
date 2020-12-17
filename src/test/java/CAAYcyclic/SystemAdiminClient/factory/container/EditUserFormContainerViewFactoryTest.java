/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.factory.container;

import CAAYcyclic.SystemAdiminClient.controller.IPanelController;
import CAAYcyclic.SystemAdiminClient.controller.bar.BackBarController;
import CAAYcyclic.SystemAdiminClient.controller.content.form.procedure.AddProcedureFormPanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.form.user.EditUserFormPanelController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class EditUserFormContainerViewFactoryTest {
    
    IContainerViewAbstractFactory instance;
    
    @Before
    public void setUp() {
        instance = new EditUserFormContainerViewFactory();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBarController method, of class EditUserFormContainerViewFactory.
     */
    @Test
    public void testGetBarController() {
        System.out.println("getBarController");
        IPanelController result = instance.getBarController();
        assertEquals(BackBarController.class, result.getClass());
    }

    /**
     * Test of getContentPanelController method, of class EditUserFormContainerViewFactory.
     */
    @Test
    public void testGetContentPanelController() {
        System.out.println("getContentPanelController");
        IPanelController result = instance.getContentPanelController();
        assertEquals(EditUserFormPanelController.class, result.getClass());
    }
    
    /**
     * Test of getContentPanelController method, of class AddProcedureContainerViewFactory.
     */
    @Test
    public void shouldGetContentPanelControllerBeNotEqualIfNotEditUserFormPanelController() {
        System.out.println("getContentPanelController");
        IPanelController result = instance.getContentPanelController();
        assertNotEquals(AddProcedureFormPanelController.class, result.getClass());
    }
}