/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.navigation;

import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;

/**
 *
 * @author Youssef
 */
public class Segue {
    
    private ContentPanelController seguePanelController;

    public Segue(ContentPanelController seguePanelController) {
        this.seguePanelController = seguePanelController;
    }

    public void setSeguePanelController(ContentPanelController seguePanelController) {
        this.seguePanelController = seguePanelController;
    }

    public ContentPanelController getSeguePanelController() {
        return seguePanelController;
    }
}
