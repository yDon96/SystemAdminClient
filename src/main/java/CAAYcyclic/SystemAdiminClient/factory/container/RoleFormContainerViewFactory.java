package CAAYcyclic.SystemAdiminClient.factory.container;

import CAAYcyclic.SystemAdiminClient.controller.IPanelController;
import CAAYcyclic.SystemAdiminClient.controller.bar.BackBarController;
import CAAYcyclic.SystemAdiminClient.controller.content.form.role.RoleFormPanelController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Youssef
 */
public class RoleFormContainerViewFactory implements IContainerViewAbstractFactory{

    @Override
    public IPanelController getBarController() {
        return new BackBarController();
    }

    @Override
    public IPanelController getContentPanelController() {
        return new RoleFormPanelController();
    }
    
}