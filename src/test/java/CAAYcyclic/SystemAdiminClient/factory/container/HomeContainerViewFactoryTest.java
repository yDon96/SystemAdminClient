/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.factory.container;

import CAAYcyclic.SystemAdiminClient.controller.IPanelController;
import CAAYcyclic.SystemAdiminClient.controller.bar.MainSideBarController;
import CAAYcyclic.SystemAdiminClient.controller.content.datapanel.ProcedurePanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.form.procedure.AddProcedureFormPanelController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class HomeContainerViewFactoryTest {
    
    IContainerViewAbstractFactory instance;
    
    @Before
    public void setUp() {
        instance = new HomeContainerViewFactory();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getContentPanelController method, of class HomeContainerViewFactory.
     */
    @Test
    public void testGetContentPanelController() {
        System.out.println("getContentPanelController");
        IPanelController result = instance.getBarController();
        assertEquals(MainSideBarController.class, result.getClass());
    }

    /**
     * Test of getBarController method, of class HomeContainerViewFactory.
     */
    @Test
    public void testGetBarController() {
        System.out.println("getBarController");
        IPanelController result = instance.getContentPanelController();
        assertEquals(ProcedurePanelController.class, result.getClass());
    }
    
    /**
     * Test of getContentPanelController method, of class AddProcedureContainerViewFactory.
     */
    @Test
    public void shouldGetContentPanelControllerBeNotEqualIfNotProcedurePanelController() {
        System.out.println("getContentPanelController");
        IPanelController result = instance.getContentPanelController();
        assertNotEquals(AddProcedureFormPanelController.class, result.getClass());
    }
}
