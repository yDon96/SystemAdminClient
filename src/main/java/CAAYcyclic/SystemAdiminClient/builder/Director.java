/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.builder;

import CAAYcyclic.SystemAdiminClient.builder.DataPanel.IDataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.enumeration.DataPanelTitle;
import CAAYcyclic.SystemAdiminClient.enumeration.TableViewHeaders;

/**
 *
 * @author Youssef
 * 
 * Director defines the order of building steps. It works with a builder object
 * through common Builder interface. Therefore it may not know what product is
 * being built.
 */
public class Director {

     /**
     *
     */
    public void constructUserDataPanel(IDataPanelBuilder builder) {
        builder.setTitle(DataPanelTitle.USER.value);
        builder.setTableHeader(TableViewHeaders.USER.value);
    }

     /**
     *
     */
    public void constructProcedureDataPanel(IDataPanelBuilder builder) {
        builder.setTitle(DataPanelTitle.PROCEDURE.value);
        builder.setTableHeader(TableViewHeaders.PROCEDURE.value);
    }
    
     /**
     *
     */
    public void constructRoleDataPanel(IDataPanelBuilder builder) {
        builder.setTitle(DataPanelTitle.ROLE.value);
        builder.setTableHeader(TableViewHeaders.ROLE.value);
    }
}
