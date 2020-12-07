/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.factory.container;

import CAAYcyclic.SystemAdiminClient.controller.bar.BarController;
import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;


/**
 *
 * @author Youssef
 */
public interface IContainerViewAbstractFactory {
    
     /**
     * Generate the Bar panel controller assosieted to View Controller.
     * @return BarController
     */
    BarController getBarController();
    
     /**
     * Generate the Panel controller assosieted to View Controller.
     * @return ContentPanelController
     */
    ContentPanelController getContentPanelController();
    
}
