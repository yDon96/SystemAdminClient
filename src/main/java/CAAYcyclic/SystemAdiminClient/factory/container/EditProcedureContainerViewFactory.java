/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.factory.container;

import CAAYcyclic.SystemAdiminClient.controller.IPanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.form.procedure.ProcedureFormPanelController;
import CAAYcyclic.SystemAdiminClient.controller.bar.BackBarController;

/**
 *
 * @author Youssef
 */
public class ProductContainerViewFactory implements IContainerViewAbstractFactory{

    @Override
    public IPanelController getBarController() {
        return new BackBarController();
    }

    @Override
    public IPanelController getContentPanelController() {
        return new ProcedureFormPanelController();
    }
    
}
