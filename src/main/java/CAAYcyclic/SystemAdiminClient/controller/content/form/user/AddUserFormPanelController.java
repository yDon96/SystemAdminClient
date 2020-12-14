/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.form.user;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.model.MyArrayList;
import CAAYcyclic.SystemAdiminClient.model.Role;
import CAAYcyclic.SystemAdiminClient.model.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Youssef
 */
public class AddUserFormPanelController extends UserFormPanelController {
    
    private static final Logger LOG = Logger.getLogger(AddUserFormPanelController.class.getName());

    public AddUserFormPanelController() {
        super();
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear();
        userForm.getFormDescription().setText("Create new user");
    }

    @Override
    public void panelDidAppear() {
        super.panelDidAppear();
        getRolesList();
        setDefaultRoleSelectionValue();
    }
    
    private void setDefaultRoleSelectionValue(){
        rolesCbx.setSelectedIndex(0);
    };
    
    
    private void getRolesList() {
        roles = new MyArrayList<>();
        if(getParcels().containsKey(roles.getParcelableDescription())){
            roles.createFromParcel(getParcels().get(roles.getParcelableDescription()),Role.class);
            for (Role role: roles){
                rolesCbx.addItem(role.getName());
            }
        } else {
            LOG.log(java.util.logging.Level.SEVERE, "Parcel do not contains any roles.");
            showSelectionError("An error occured during role's value retrive.");
            getCoordinator().popBack();
        }
    }

    @Override
    protected void initAction(){
        saveBtn.addMouseListener(saveBtnAction);
    }
    
    private MouseAdapter saveBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            startSaveProcedure();
        }
    };
    
    private void startSaveProcedure(){
        if(!allRequiredFieldAreValid()){
            showSelectionError("One or more field need to be filled.");
            return;
        }
        User user = new User(nameTxt.getText().trim(),surnameTxt.getText().trim(),convertStringFromDate(dataChooser.getDate()),rolesCbx.getSelectedRowValue());
        ApiManager.getIstance().createUser(user, apiUserDelegate);
    }
    
    private boolean allRequiredFieldAreValid(){
        if (nameTxt.getText() == null || nameTxt.getText().trim().isEmpty()) {
            LOG.log(java.util.logging.Level.WARNING, "Name textfield is empty.");
            return false;
        }
        
        if (surnameTxt.getText() == null || surnameTxt.getText().trim().isEmpty()) {
            LOG.log(java.util.logging.Level.WARNING, "Surname textfield is empty.");
            return false;
        }
        
        if (dataChooser.getDate() == null) {
            LOG.log(java.util.logging.Level.WARNING, "DataChooser is empty.");
            return false;
        }
        
        return true;
    }
    
    private ApiDelegate<User> apiUserDelegate = new ApiDelegate<User>() {
        @Override
        public void onGetAllSuccess(List<User> users) {
            
        }

        @Override
        public void onGetSuccess(User user) {
        }

        @Override
        public void onFailure(String message) {
            showSelectionError(message);
        }

        @Override
        public void onCreateSuccess() {
            getCoordinator().popBack();
        }
    };
    
    @Override
    public Logger getLogger() {
        return LOG;
    }
   
}
