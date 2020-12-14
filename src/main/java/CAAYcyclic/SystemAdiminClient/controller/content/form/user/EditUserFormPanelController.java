/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.form.user;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiUserDelegate;
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
public class EditUserFormPanelController extends UserFormPanelController {
    
    private static final Logger LOG = Logger.getLogger(AddUserFormPanelController.class.getName());

    public EditUserFormPanelController() {
        super();
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear();
        userForm.getFormDescription().setText("Edit user with new value");
    }

    @Override
    public void panelDidAppear() {
        super.panelDidAppear();
        getParcelInfo();
    }
    
    @Override
    protected void initAction(){
        saveBtn.addMouseListener(saveBtnAction);
    }
    
    private void getParcelInfo(){
        user = new User();
        if(getParcels() != null){
            getRolesList();
            getUserToModify();
            disableAllNotEditableField();
        } else {
            LOG.log(java.util.logging.Level.SEVERE, "Parcel shouldn't be empty.");
        }
    }
    
    private void getRolesList() {
        roles = new MyArrayList<>();
        if(getParcels().containsKey(roles.getParcelableDescription())){
            roles.createFromParcel(getParcels().get(roles.getParcelableDescription()),Role.class);
            for (Role role: roles){
                rolesCbx.addItem(role.getName());
            }
        } else {
            LOG.log(java.util.logging.Level.SEVERE, "Parcel do not contains any roles.");
            showSelectionError("An error occured during role's value retrive operation.");
            getCoordinator().popBack(); 
        }
    }
    
    private void getUserToModify(){
        if(getParcels().containsKey(user.getParcelableDescription())){
            user.createFromParcel(getParcels().get(user.getParcelableDescription()));
            nameTxt.setText(user.getName());
            surnameTxt.setText(user.getSurname());
            dataChooser.setDate(java.sql.Date.valueOf(user.getDob()));
            rolesCbx.setInitialSelectedItem(user.getRole()); 
        } else {
            LOG.log(java.util.logging.Level.SEVERE, "Parcel do not contains any user.");
            showSelectionError("An error occured during user's value retrive operation.");
            getCoordinator().popBack();
        }
    }
    
    private void disableAllNotEditableField(){
        nameTxt.setEditable(false);
        surnameTxt.setEditable(false);
        dataChooser.setEnabled(false); 
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
        
        if(rolesCbx.isOriginalSelection()){
            getCoordinator().popBack();
            return;
        }
        
        ApiManager.getIstance().assingRole(user.getUser_id(),rolesCbx.getSelectedRowValue(),apiUserDelegate);
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
        
        if (rolesCbx.getSelectedIndex() < 0) {
            LOG.log(java.util.logging.Level.WARNING, "No value selected.");
            return false;
        }
        
        return true;
    }
    
    private ApiUserDelegate apiUserDelegate = new ApiUserDelegate() {
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
