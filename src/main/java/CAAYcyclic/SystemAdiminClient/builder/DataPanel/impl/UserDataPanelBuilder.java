/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl;

import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import CAAYcyclic.SystemAdiminClient.builder.DataPanel.IDataPanelBuilder;

/**
 *
 * @author Youssef
 */
public class UserDataPanelBuilder implements IDataPanelBuilder{
    
    private String title;
    private String[] tableHeader;
    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setTableHeader(String[] header) {
        this.tableHeader = header;
    }
    
    public DataPanel getResults() {
        DataPanel userView = new DataPanel();
        userView.setTitleLabelValue(title);
        userView.setTableHeader(tableHeader);
        return userView;
    }
}
