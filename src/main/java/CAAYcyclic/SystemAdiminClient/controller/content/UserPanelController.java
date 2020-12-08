/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content;

import CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl.UserDataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.builder.Director;
import CAAYcyclic.SystemAdiminClient.navigation.Segue;
import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

import javax.swing.*;

/**
 *
 * @author Youssef
 */
public class UserPanelController extends ContentPanelController {

    public DataPanel userView;
    
    private static final Logger LOG = Logger.getLogger(UserPanelController.class.getName());
    
    public JButton updateBtn;
    public JButton editBtn;
    public JButton addBtn;

    public UserPanelController() {
        super();
        UserDataPanelBuilder userDataPanelBuilder = new UserDataPanelBuilder();
        Director director = new Director();
        director.constructUserDataPanel(userDataPanelBuilder);
        setContentPanel(userDataPanelBuilder.getResults());
    }

    @Override
    public void panelDidAppear() {
        super.panelDidAppear();
        initComponent();
        setButtonAction();
    }
    
    
    
    private void initComponent() {
        userView = (DataPanel) getPanel();
        updateBtn = userView.getUpdateBtn();
        editBtn = userView.getEditBtn();
        addBtn = userView.getAddBtn();
    }
    
    private void setButtonAction() {
        updateBtn.addMouseListener(updateBtnAction);
        editBtn.addMouseListener(editBtnAction);
        addBtn.addMouseListener(addBtnAction);
    }
    
    private MouseAdapter updateBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            System.out.println("firstBtnAction");
        }
    };
    
    private MouseAdapter editBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            System.out.println("firstBtnAction");
        }
    };
    
    private MouseAdapter addBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
        }
    };

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public void prepare(Segue segue) {
    }
    
}
