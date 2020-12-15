/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.factory.container;

import CAAYcyclic.SystemAdiminClient.controller.IPanelController;


/**
 *
 * @author Youssef
 */
public interface IContainerViewAbstractFactory {
    
     /**
     * Generate the Bar panel controller assosieted to View Controller.
     * @return BarController
     */
    IPanelController getBarController();
    
     /**
     * Generate the Panel controller assosieted to View Controller.
     * @return ContentPanelController
     */
    IPanelController getContentPanelController();
    
}
