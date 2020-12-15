/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.builder.DataPanel;

/**
 *
 * @author Youssef
 */
public interface IDataPanelBuilder {
    
    /**
     * Set Title to display in Data Panel.
     */
    public void setTitle(String title);
    
     /**
     * Set Table header to display in Data Panel.
     */
    public void setTableHeader(String[] header);
    
    /**
     * Set Update button to be visible in Data Panel.
     */
    public void addUpdateBtn();
    
    /**
     * Set Edit button to be visible in Data Panel.
     */
    public void addEditBtn();
    
    /**
     * Set Add button to be visible in Data Panel.
     */
    public void addAddBtn();
    
}
