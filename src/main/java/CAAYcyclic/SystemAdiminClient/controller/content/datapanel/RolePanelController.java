/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.datapanel;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl.DataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.builder.Director;
import CAAYcyclic.SystemAdiminClient.controller.component.jtable.impl.TableDataSource;
import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;
import CAAYcyclic.SystemAdiminClient.model.Role;
import CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJTable;
import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

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
    private CustomJTable table;
    private List<Role> roleList;
    
    public RolePanelController() {
        super();
        DataPanelBuilder dataPanelBuilder = new DataPanelBuilder();
        Director director = new Director();
        director.constructRoleDataPanel(dataPanelBuilder);
        setContentPanel(dataPanelBuilder.getResults());
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
        table = (CustomJTable) rolePanel.getTableView();
        setTableDataSource(table);
        numberOfRow = rolePanel.getNumberOfRow();
    }
    
    private void setTableDataSource(CustomJTable jtable){
        TableDataSource<Role> datasource = new TableDataSource<>();
        jtable.setiTableDataSource(datasource);
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
    
    private final ApiDelegate<Role> roleDelegate = new ApiDelegate<Role>() {
        @Override
        public void onGetAllSuccess(List<Role> roles) {
            if (roles.size() > 0) {
                setRoleList(roles);
                table.getiTableDataSource().setElementToDisplay(roles);
                table.refreshData();
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
