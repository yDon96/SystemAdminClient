/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiRoleDelegate;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiUserDelegate;
import CAAYcyclic.SystemAdiminClient.model.MyArrayList;
import CAAYcyclic.SystemAdiminClient.model.Role;
import CAAYcyclic.SystemAdiminClient.model.User;
import CAAYcyclic.SystemAdiminClient.view.panel.content.UserFormPanel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Youssef
 */
public class UserFormPanelController extends ContentPanelController {

    private UserFormPanel userForm;
    private JDateChooser dataChooser;
    private JTextField nameTxt;
    private JTextField surnameTxt;
    private JButton saveBtn;
    private User user;
    private JComboBox<String> rolesCbx;
    private MyArrayList<Role> roles;
    
    private static final Logger LOG = Logger.getLogger(UserFormPanelController.class.getName());

    public UserFormPanelController() {
        super();
        setContentPanel(UserFormPanel.class);
        initComponent();
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear(); 
    }

    @Override
    public void panelDidAppear() {
        super.panelDidAppear();
        initAction();
        user = new User();
        roles = new MyArrayList<>();
        if(getParcels() != null){
            if(getParcels().containsKey(roles.getParcelableDescription())){
                roles.createFromParcel(getParcels().get(roles.getParcelableDescription()),Role.class);
                for (Role role: roles){
                    rolesCbx.addItem(role.getName());
                }
            }
            
            if(getParcels().containsKey(user.getParcelableDescription())){
                user.createFromParcel(getParcels().get(user.getParcelableDescription()));
                nameTxt.setText(user.getName());
                surnameTxt.setText(user.getSurname());
                dataChooser.setDate(java.sql.Date.valueOf(user.getDob()));
                rolesCbx.setSelectedItem(user.getRole());
                            
                nameTxt.setEditable(false);
                surnameTxt.setEditable(false);
                dataChooser.setEnabled(false);  
            }

        }
    }

    private void initComponent() {
        this.userForm = (UserFormPanel) getPanel();
        nameTxt = userForm.getNameTxt();
        surnameTxt = userForm.getSurnameTxt();
        dataChooser = userForm.getDataChooser();
        saveBtn = userForm.getSaveBtn();
        rolesCbx = userForm.getRoleCbx();
    }
    
    private void initAction(){
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
        User user = new User(nameTxt.getText().trim(),surnameTxt.getText().trim(),convertStringToDate(dataChooser.getDate()));
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
    
    public String convertStringToDate(Date indate)
    {
       String dateString = null;
       SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
       /*you can also use DateFormat reference instead of SimpleDateFormat 
        * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
        */
       try{
            dateString = sdfr.format( indate );
       }catch (Exception ex ){
            LOG.log(java.util.logging.Level.WARNING, "Could not format date {0} to string.",indate.toString());
       }
       return dateString;
    }
}
