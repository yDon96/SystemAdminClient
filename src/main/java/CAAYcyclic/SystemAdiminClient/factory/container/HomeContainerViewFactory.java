/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.factory.container;

import CAAYcyclic.SystemAdiminClient.controller.IPanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.DashBoardPanelController;
import CAAYcyclic.SystemAdiminClient.controller.bar.MainSideBarController;

/**
 *
 * @author Youssef
 */
public class HomeContainerViewFactory implements IContainerViewAbstractFactory {

    @Override
    public IPanelController getContentPanelController() {
        return new DashBoardPanelController();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPanelController getBarController() {
        return new MainSideBarController();//To change body of generated methods, choose Tools | Templates.
    }
    
}
