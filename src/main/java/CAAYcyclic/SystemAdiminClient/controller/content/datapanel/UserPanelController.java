/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.datapanel;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl.DataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.builder.Director;
import CAAYcyclic.SystemAdiminClient.controller.component.jtable.ITableDelegate;
import CAAYcyclic.SystemAdiminClient.controller.component.jtable.impl.TableDataSource;
import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;
import CAAYcyclic.SystemAdiminClient.model.Competency;
import CAAYcyclic.SystemAdiminClient.model.MyArrayList;
import CAAYcyclic.SystemAdiminClient.model.Role;
import CAAYcyclic.SystemAdiminClient.model.User;
import CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJTable;
import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
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
    private JLabel numberOfRow;
    private CustomJTable table;
    private List<User> userList;
    private User selectedUser;
    private MyArrayList<Competency> competencies;
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
        Thread newThread3 = new Thread(() -> {
            ApiManager.getIstance().getCompetencyList(apiCompetencyDelegate);
        });
        newThread3.start();
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
        table = (CustomJTable) userView.getTableView();
        table.setTableDelegate(tableDelegate);
        setTableDataSource(table);
        numberOfRow = userView.getNumberOfRow();
    }
    
    private void setTableDataSource(CustomJTable jtable){
        TableDataSource<User> datasource = new TableDataSource<>();
        jtable.setiTableDataSource(datasource);
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
            if (selectedUser == null) {
                LOG.log(java.util.logging.Level.WARNING, "Number of row is \"0\" or no row is selected.");
                showError("Edit Error", "No element is selected.");
                return;
            } else {
                editBtn.setSelected(false);
                getCoordinator().navigateToUserForm(selectedUser,roles,competencies);
            }
        }
    };
    
    private MouseAdapter addBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            getCoordinator().navigateToUserForm(null,roles,competencies);
        }
    };
    
    private ITableDelegate tableDelegate = new ITableDelegate() {
        @Override
        public void didSelectRowAt(JTable jTable, Integer selectedIndexRow) {
            selectedUser = userList.get(selectedIndexRow);
        }

        @Override
        public void didDeselectRowAt(JTable jTable, Integer deselectedIndexRow) {
            selectedUser = null;
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
                table.getiTableDataSource().setElementToDisplay(users);
                table.refreshData();
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

    private ApiDelegate<Competency> apiCompetencyDelegate = new ApiDelegate<Competency>() {
        @Override
        public void onGetAllSuccess(List<Competency> competencies) {
            setCompetencies(competencies);
        }

        @Override
        public void onGetSuccess(Competency competency) {
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
        this.roles = new MyArrayList<Role>(Role.class,roles);
    }
    
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    public void setCompetencies(List<Competency> competencies) {
        this.competencies = new MyArrayList<>(Competency.class,competencies);
    }
    
    @Override
    public Logger getLogger() {
        return LOG;
    }

    
}
