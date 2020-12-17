/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl;

import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Youssef
 */
public class DataPanelBuilderTest {

    DataPanelBuilder instance;

    @Before
    public void setUp() {
        instance = new DataPanelBuilder();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setTitle method, of class DataPanelBuilder.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "title";
        instance.setTitle(title);
        assertEquals(title, instance.title);
    }

    /**
     * Test of setTableHeader method, of class DataPanelBuilder.
     */
    @Test
    public void testSetTableHeader() {
        System.out.println("setTableHeader");
        String[] header = {"title", "title", "title", "title"};
        instance.setTableHeader(header);
        assertArrayEquals(header, instance.tableHeader);
    }

    /**
     * Test of addUpdateBtn method, of class DataPanelBuilder.
     */
    @Test
    public void testAddUpdateBtn() {
        System.out.println("addUpdateBtn");
        instance.addUpdateBtn();
        assertEquals(true, instance.shouldUpdateBtnVisible);
    }

    /**
     * Test of addEditBtn method, of class DataPanelBuilder.
     */
    @Test
    public void testAddEditBtn() {
        System.out.println("addEditBtn");
        instance.addEditBtn();
        assertEquals(true, instance.shouldEditBtnVisible);

    }

    /**
     * Test of addAddBtn method, of class DataPanelBuilder.
     */
    @Test
    public void testAddAddBtn() {
        System.out.println("addAddBtn");
        instance.addAddBtn();
        assertEquals(true, instance.shouldAddBtnVisible);
    }

    /**
     * Test of addUpdateBtn method, of class DataPanelBuilder.
     */
    @Test
    public void ShouldBeFalseIfNotCallAddUpdateBtn() {
        System.out.println("addUpdateBtn");
        assertEquals(false, instance.shouldUpdateBtnVisible);
    }

    /**
     * Test of addEditBtn method, of class DataPanelBuilder.
     */
    @Test
    public void ShouldBeFalseIfNotCallAddEditBtn() {
        System.out.println("addEditBtn");
        assertEquals(false, instance.shouldEditBtnVisible);

    }

    /**
     * Test of addAddBtn method, of class DataPanelBuilder.
     */
    @Test
    public void ShouldBeFalseIfNotCallAddAddBtn() {
        System.out.println("addAddBtn");
        assertEquals(false, instance.shouldAddBtnVisible);
    }

    /**
     * Test of getResults method, of class DataPanelBuilder.
     */
    @Test
    public void shouldGetResultsAndFindDefaultDataPanel() {
        System.out.println("getResults");
        String title = "DataPanel";

        String[] header = {"Title 1", "Title 2", "Title 3", "Title 4"};
        DataPanel result = instance.getResults();
        assertEquals(title, result.getTitleLabel().getText());
        for (int i = 0; i < header.length; i++) {
            assertEquals(header[i], result.getTableView().getColumnModel().getColumn(i).getHeaderValue());
        }
        assertEquals(false, result.getAddBtn().isVisible());
        assertEquals(false, result.getEditBtn().isVisible());
        assertEquals(false, result.getUpdateBtn().isVisible());
    }

    /**
     * Test of getResults method, of class DataPanelBuilder.
     */
    @Test
    public void shouldGetResultsAndFindDataPanelWithAllButtonNotVisible() {
        System.out.println("getResults");
        String title = "title";
        String[] header = {"title", "title", "title", "title"};
        instance.setTitle(title);
        instance.setTableHeader(header);
        DataPanel result = instance.getResults();
        assertEquals(title, result.getTitleLabel().getText());
        for (int i = 0; i < header.length; i++) {
            assertEquals(header[i], result.getTableView().getColumnModel().getColumn(i).getHeaderValue());
        }
        assertEquals(false, result.getAddBtn().isVisible());
        assertEquals(false, result.getEditBtn().isVisible());
        assertEquals(false, result.getUpdateBtn().isVisible());
    }

    /**
     * Test of getResults method, of class DataPanelBuilder.
     */
    @Test
    public void shouldGetResultsAndFindDataPanelWithTwoButtonNotVisible() {
        System.out.println("getResults");
        String title = "title";
        String[] header = {"title", "title", "title", "title"};
        instance.setTitle(title);
        instance.setTableHeader(header);
        instance.addAddBtn();
        DataPanel result = instance.getResults();
        assertEquals(title, result.getTitleLabel().getText());
        for (int i = 0; i < header.length; i++) {
            assertEquals(header[i], result.getTableView().getColumnModel().getColumn(i).getHeaderValue());
        }
        assertEquals(true, result.getAddBtn().isVisible());
        assertEquals(false, result.getEditBtn().isVisible());
        assertEquals(false, result.getUpdateBtn().isVisible());
    }

    /**
     * Test of getResults method, of class DataPanelBuilder.
     */
    @Test
    public void shouldGetResultsAndFindDataPanelWithOneButtonNotVisible() {
        System.out.println("getResults");
        String title = "title";
        String[] header = {"title", "title", "title", "title"};
        instance.setTitle(title);
        instance.setTableHeader(header);
        instance.addAddBtn();
        instance.addEditBtn();
        DataPanel result = instance.getResults();
        assertEquals(title, result.getTitleLabel().getText());
        for (int i = 0; i < header.length; i++) {
            assertEquals(header[i], result.getTableView().getColumnModel().getColumn(i).getHeaderValue());
        }
        assertEquals(true, result.getAddBtn().isVisible());
        assertEquals(true, result.getEditBtn().isVisible());
        assertEquals(false, result.getUpdateBtn().isVisible());
    }

    /**
     * Test of getResults method, of class DataPanelBuilder.
     */
    @Test
    public void shouldGetResultsAndFindDataPanelWithAllButtonVisible() {
        System.out.println("getResults");
        String title = "title";
        String[] header = {"title", "title", "title", "title"};
        instance.setTitle(title);
        instance.setTableHeader(header);
        instance.addAddBtn();
        instance.addEditBtn();
        instance.addUpdateBtn();
        DataPanel result = instance.getResults();
        assertEquals(title, result.getTitleLabel().getText());
        for (int i = 0; i < header.length; i++) {
            assertEquals(header[i], result.getTableView().getColumnModel().getColumn(i).getHeaderValue());
        }
        assertEquals(true, result.getAddBtn().isVisible());
        assertEquals(true, result.getEditBtn().isVisible());
        assertEquals(true, result.getUpdateBtn().isVisible());
    }

}
