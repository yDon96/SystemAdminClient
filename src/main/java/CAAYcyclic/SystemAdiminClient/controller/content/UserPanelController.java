/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl.DataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.builder.Director;
import CAAYcyclic.SystemAdiminClient.model.MyArrayList;
import CAAYcyclic.SystemAdiminClient.model.Role;
import CAAYcyclic.SystemAdiminClient.model.User;
import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    private JLabel numberOfRow;
    private JTable table;
    private List<User> userList;
    private MyArrayList<Role> roles;


    public UserPanelController() {
        super();
        DataPanelBuilder DataPanelBuilder = new DataPanelBuilder();
        Director director = new Director();
        director.constructUserDataPanel(DataPanelBuilder);
        setContentPanel(DataPanelBuilder.getResults());
        initComponent();
        setButtonAction();
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear();
        Thread newThread = new Thread(() -> {
            ApiManager.getIstance().getUsers(apiDelegate);
        });
        newThread.start();
        Thread newThread2 = new Thread(() -> {
            ApiManager.getIstance().getRoles(apiRoleDelegate);
        });
        newThread2.start();
    }
    
    

    @Override
    public void panelDidAppear() {
        super.panelDidAppear();      
    }
    
    
    private void initComponent() {
        userView = (DataPanel) getPanel();
        updateBtn = userView.getUpdateBtn();
        editBtn = userView.getEditBtn();
        addBtn = userView.getAddBtn();
        table = userView.getTableView();
        numberOfRow = userView.getNumberOfRow();
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
            ApiManager.getIstance().getUsers(apiDelegate);
        }
    };
    
    private MouseAdapter editBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            if (table.getRowCount() < 0 || table.getSelectedRow() < 0) {
                LOG.log(java.util.logging.Level.WARNING, "Number of row is \"0\" or no row is selected.");
                showError("Edit Error", "No element is selected.");
                return;
            } else {
                editBtn.setSelected(false);
                getCoordinator().navigateToUserForm(userList.get(table.getSelectedRow()),roles);
            }
        }
    };
    
    private MouseAdapter addBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            getCoordinator().navigateToUserForm(null,roles);
        }
    };
    
    private ApiDelegate<Role> apiRoleDelegate = new ApiDelegate<Role>() {
        @Override
        public void onGetAllSuccess(List<Role> roles) {
            setRoles(roles);
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

    private ApiDelegate<User> apiDelegate = new ApiDelegate<User>() {
        @Override
        public void onGetAllSuccess(List<User> users) {
            if (users.size() > 0) {
                setUserList(users);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                Integer rowNumber = table.getRowCount();
                for (int index = rowNumber - 1; index >= 0; index--) {
                    model.removeRow(index);
                }
                for (User user : users) {
                    Object[] row = {user.getUser_id(), user.getName(), user.getSurname(), user.getDob().format(DateTimeFormatter.ISO_DATE)};
                    model.addRow(row);
                }
                numberOfRow.setText(String.valueOf(table.getRowCount()));
            }
        }

        @Override
        public void onGetSuccess(User procedure) {
        }

        @Override
        public void onFailure(String message) {
            showSelectionError(message);
        }

        @Override
        public void onCreateSuccess() {
        }
    };

    
    public void setRoles(List<Role> roles) {
        this.roles = new MyArrayList<Role>(roles);
    }
    
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    @Override
    public Logger getLogger() {
        return LOG;
    }

    
}
