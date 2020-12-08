/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.bar;

import CAAYcyclic.SystemAdiminClient.controller.content.DashBoardPanelController;
import CAAYcyclic.SystemAdiminClient.view.panel.bar.MainSideBarPanel;

import javax.swing.*;
import java.awt.event.*;
import CAAYcyclic.SystemAdiminClient.controller.bar.IBarController;
import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.ProcedurePanelController;
import CAAYcyclic.SystemAdiminClient.controller.content.UserPanelController;
import CAAYcyclic.SystemAdiminClient.navigation.Segue;
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

    public MainSideBarController() {
        super();
        setBarPanel(MainSideBarPanel.class);
    }

    @Override
    public void panelDidAppear() {
        super.panelDidAppear();
        this.mainSideBarView = (MainSideBarPanel) getPanel();
        dashBtn = mainSideBarView.getDashBtn();
        procedureBtn = mainSideBarView.getProcedureBtn();
        userBtn = mainSideBarView.getUserBtn();
        dashBtn.addMouseListener(dashBtnAction);
        procedureBtn.addMouseListener(procedureBtnAction);
        userBtn.addMouseListener(userBtnAction);
    }

    private MouseAdapter dashBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "DashButton selected.");
            swichAction(dashBtn, DashBoardPanelController.class);
        }
    };

    private MouseAdapter procedureBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "ProcedureButton selected.");
            swichAction(procedureBtn, ProcedurePanelController.class);
        }
    };

    private MouseAdapter userBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "UserButton selected.");
            swichAction(userBtn, UserPanelController.class);
        }
    };

    private void swichAction(JButton buttonToHighlight, Class<? extends ContentPanelController> panelClass) {
        if (!isLockNavigation()) {
            mainSideBarView.highlightButton(buttonToHighlight);
            startPanel(panelClass);
        } else {
            LOG.log(java.util.logging.Level.WARNING, "Cannot swich panel, navigation is locked.");
        }
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public void prepare(Segue segue) {

    }
}
