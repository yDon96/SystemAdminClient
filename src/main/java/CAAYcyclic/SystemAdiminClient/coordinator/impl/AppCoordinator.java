/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.coordinator.impl;

import CAAYcyclic.SystemAdiminClient.builder.AlertDialog.IAlertBuilder;
import CAAYcyclic.SystemAdiminClient.controller.IPanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.DashBoardPanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.ProcedurePanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.UserPanelController;
import CAAYcyclic.SystemAdiminClient.coordinator.IAppCoordinator;
import CAAYcyclic.SystemAdiminClient.factory.container.HomeContainerViewFactory;
import CAAYcyclic.SystemAdiminClient.factory.container.IContainerViewAbstractFactory;
import CAAYcyclic.SystemAdiminClient.factory.container.ProductContainerViewFactory;
import CAAYcyclic.SystemAdiminClient.factory.container.UserFormContainerViewFactory;
import CAAYcyclic.SystemAdiminClient.navigation.NavigationController;
import CAAYcyclic.SystemAdiminClient.model.Parcelable;

/**
 *
 * @author Youssef
 */
public class AppCoordinator extends Coordinator implements IAppCoordinator{

    public AppCoordinator(NavigationController navController) {
        this.navigationController = navController;
    }

    @Override
    public void start() {
        HomeContainerViewFactory homeContainerViewFactory = new HomeContainerViewFactory();
        IPanelController dashBoardPanelController = homeContainerViewFactory.getContentPanelController();
        IPanelController mainSideBarController = homeContainerViewFactory.getBarController();
        dashBoardPanelController.setCoordinator(this);
        mainSideBarController.setCoordinator(this);
        navigationController.performViewNavigationTo(mainSideBarController,dashBoardPanelController);
    }

    @Override
    public void switchPanelToDashboard() {
        IPanelController dashBoardPanelController = navigationController.retrivePanelFromMap(DashBoardPanelController.class.getName());
        if(dashBoardPanelController == null) {
            dashBoardPanelController = new DashBoardPanelController();
        }
        dashBoardPanelController.setCoordinator(this);
        navigationController.performPanelNavigationTo(dashBoardPanelController);
    }

    @Override
    public void switchPanelToProcedurePanel() {
        IPanelController procedurePanelController = navigationController.retrivePanelFromMap(ProcedurePanelController.class.getName());
        if(procedurePanelController == null) {
            procedurePanelController = new ProcedurePanelController();
        }
        procedurePanelController.setCoordinator(this);
        navigationController.performPanelNavigationTo(procedurePanelController);
    }

    @Override
    public void switchPanelToUserPanel() {
        IPanelController userPanelController = navigationController.retrivePanelFromMap(UserPanelController.class.getName());
        if(userPanelController == null) {
            userPanelController = new UserPanelController();
        }
        userPanelController.setCoordinator(this);
        navigationController.performPanelNavigationTo(userPanelController);
    }

    @Override
    public void navigateToUserForm() {
        IContainerViewAbstractFactory homeContainerViewFactory = new UserFormContainerViewFactory();
        IPanelController panelController = homeContainerViewFactory.getContentPanelController();
        IPanelController barController = homeContainerViewFactory.getBarController();
        panelController.setCoordinator(this);
        barController.setCoordinator(this);
        navigationController.performViewNavigationTo(barController,panelController);
    }

    @Override
    public void popBack() {
        navigationController.performBackToStack();
    }

    @Override
    public void showAlert(IAlertBuilder alert) {
        alert.setParentFrame(navigationController.getCurrentFrame());
        alert.show();
    }

    @Override
    public void navigateToProcedureForm(Parcelable procedure) {
        IContainerViewAbstractFactory homeContainerViewFactory = new ProductContainerViewFactory();
        IPanelController panelController = homeContainerViewFactory.getContentPanelController();
        IPanelController barController = homeContainerViewFactory.getBarController();
        if(procedure != null){
            panelController.setParcel(procedure.getParcelableDescription(), procedure.convertToParcel());
        }
        panelController.setCoordinator(this);
        barController.setCoordinator(this);
        navigationController.performViewNavigationTo(barController,panelController);
    }
    
    
}