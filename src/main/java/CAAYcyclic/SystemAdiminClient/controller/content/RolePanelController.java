/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl.UserDataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.builder.Director;
import CAAYcyclic.SystemAdiminClient.model.Role;
import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Youssef
 */
public class RolePanelController extends ContentPanelController{

    private static final Logger LOG = Logger.getLogger(RolePanelController.class.getCanonicalName());

    private DataPanel rolePanel;
    private JButton updateBtn;
    private JButton editBtn;
    private JButton addBtn;
    private JLabel numberOfRow;
    private JTable table;
    private List<Role> roleList;
    
    public RolePanelController() {
        super();
        UserDataPanelBuilder userDataPanelBuilder = new UserDataPanelBuilder();
        Director director = new Director();
        director.constructRoleDataPanel(userDataPanelBuilder);
        setContentPanel(userDataPanelBuilder.getResults());
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear(); 
        initComponent();
        setButtonAction();
        getRoleList();
    }
    
    private void initComponent() {
        rolePanel = (DataPanel) getPanel();
        updateBtn = rolePanel.getUpdateBtn();
        editBtn = rolePanel.getEditBtn();
        addBtn = rolePanel.getAddBtn();
        table = rolePanel.getTableView();
        numberOfRow = rolePanel.getNumberOfRow();
    }
    
    private void setButtonAction() {
        updateBtn.addMouseListener(updateBtnAction);
        addBtn.addMouseListener(addBtnAction);
    }

    private MouseAdapter updateBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            getRoleList();
        }
    };
    
    private MouseAdapter addBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            getCoordinator().navigateToRoleForm();
        }
    };
    
    private void getRoleList(){
        Thread newThread = new Thread(() -> {
            ApiManager.getIstance().getRoles(roleDelegate);
        });
        newThread.start();
    }
    
    private ApiDelegate<Role> roleDelegate = new ApiDelegate<Role>() {
        @Override
        public void onGetAllSuccess(List<Role> roles) {
            if (roles.size() > 0) {
                setRoleList(roles);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                Integer rowNumber = table.getRowCount();
                for (int index = rowNumber - 1; index >= 0; index--) {
                    model.removeRow(index);
                }
                for (Role role : roles) {
                    Object[] row = {role.getId(), role.getName()};
                    model.addRow(row);
                }
                numberOfRow.setText(String.valueOf(table.getRowCount()));
            }
        }

        @Override
        public void onGetSuccess(Role role) {
        }

        @Override
        public void onFailure(String message) {
            showSelectionError(message);
        }

        @Override
        public void onCreateSuccess() {
        }
    };
    
    public void setRoleList(List<Role> userList) {
        this.roleList = userList;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
    
}
