/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl;

import CAAYcyclic.SystemAdiminClient.builder.DataPanel.IDataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;

/**
 *
 * @author Youssef
 */
public class DataPanelBuilder implements IDataPanelBuilder{

    private String title;
    private String[] tableHeader;
    private boolean shouldAddBtnVisible = false;
    private boolean shouldEditBtnVisible = false;
    private boolean shouldUpdateBtnVisible = false;

    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setTableHeader(String[] header) {
        this.tableHeader = header;
    }
    
    public DataPanel getResults() {
        DataPanel datapanel = new DataPanel();
        datapanel.setTitleLabelValue(title);
        datapanel.setTableHeader(tableHeader);
        datapanel.getAddBtn().setVisible(shouldAddBtnVisible);
        datapanel.getUpdateBtn().setVisible(shouldUpdateBtnVisible);
        datapanel.getEditBtn().setVisible(shouldEditBtnVisible);
        return datapanel;
    }

    @Override
    public void addUpdateBtn() {
        shouldUpdateBtnVisible = true;
    }

    @Override
    public void addEditBtn() {
        shouldEditBtnVisible = true;
    }

    @Override
    public void addAddBtn() {
        shouldAddBtnVisible = true;
    }
    
}
