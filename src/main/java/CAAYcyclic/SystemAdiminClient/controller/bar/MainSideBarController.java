/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.bar;

import CAAYcyclic.SystemAdiminClient.view.panel.bar.MainSideBarPanel;

import javax.swing.*;
import java.awt.event.*;
import java.util.logging.Logger;

/**
 *
 * @author Youssef
 */
public class MainSideBarController extends BarController {

    private MainSideBarPanel mainSideBarView;

    private static final Logger LOG = Logger.getLogger(MainSideBarController.class.getName());

    private JButton dashBtn;
    private JButton procedureBtn;
    private JButton userBtn;
    private JButton roleBtn;
    private JButton competencyBtn;
    

    public MainSideBarController() {
        super();
        setBarPanel(MainSideBarPanel.class);
        initComponet();
    }

    @Override
    public void panelDidAppear() {
        super.panelDidAppear();
        
    }
    
    private void initComponet(){
        this.mainSideBarView = (MainSideBarPanel) getPanel();
        dashBtn = mainSideBarView.getDashBtn();
        procedureBtn = mainSideBarView.getProcedureBtn();
        userBtn = mainSideBarView.getUserBtn();
        roleBtn = mainSideBarView.getRoleBtn();
        competencyBtn = mainSideBarView.getCompetencyBtn();
        dashBtn.addMouseListener(dashBtnAction);
        procedureBtn.addMouseListener(procedureBtnAction);
        userBtn.addMouseListener(userBtnAction);
        roleBtn.addMouseListener(roleBtnAction);
        competencyBtn.addMouseListener(competencyBtnAction);
    }

    private MouseAdapter dashBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "DashButton selected.");
            swichAction(dashBtn);
            getCoordinator().switchPanelToDashboard();
        }
    };

    private MouseAdapter procedureBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "ProcedureButton selected.");
            swichAction(procedureBtn);
            getCoordinator().switchPanelToProcedurePanel();
        }
    };

    private MouseAdapter userBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "UserButton selected.");
            swichAction(userBtn);
            getCoordinator().switchPanelToUserPanel();
        }
    };
    
    private MouseAdapter roleBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "RoleButton selected.");
            swichAction(roleBtn);
            getCoordinator().switchPanelToRolePanel();
        }
    };
    
    private MouseAdapter competencyBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "CompetencyButton selected.");
            swichAction(competencyBtn);
            getCoordinator().switchPanelToCompetencyPanel();
        }
    };

    private void swichAction(JButton buttonToHighlight) {
        if (!isLockNavigation()) {
            mainSideBarView.highlightButton(buttonToHighlight);
        } else {
            LOG.log(java.util.logging.Level.WARNING, "Cannot swich panel, navigation is locked.");
        }
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
