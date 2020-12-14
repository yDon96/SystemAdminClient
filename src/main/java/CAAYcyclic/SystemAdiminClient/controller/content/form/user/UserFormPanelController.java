/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.form.user;

import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;
import CAAYcyclic.SystemAdiminClient.model.MyArrayList;
import CAAYcyclic.SystemAdiminClient.model.Role;
import CAAYcyclic.SystemAdiminClient.model.User;
import CAAYcyclic.SystemAdiminClient.view.panel.component.CustomComboBox;
import CAAYcyclic.SystemAdiminClient.view.panel.content.UserFormPanel;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Youssef
 */
public abstract class UserFormPanelController extends ContentPanelController {

    protected UserFormPanel userForm;
    protected JDateChooser dataChooser;
    protected JTextField nameTxt;
    protected JTextField surnameTxt;
    protected JButton saveBtn;
    protected User user;
    protected CustomComboBox<String> rolesCbx;
    protected MyArrayList<Role> roles;
    
    private static final Logger LOG = Logger.getLogger(AddUserFormPanelController.class.getName());

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
    }
    
    private void initComponent() {
        this.userForm = (UserFormPanel) getPanel();
        nameTxt = userForm.getNameTxt();
        surnameTxt = userForm.getSurnameTxt();
        dataChooser = userForm.getDataChooser();
        saveBtn = userForm.getSaveBtn();
        rolesCbx = userForm.getRoleCbx();
    }
    
    public String convertStringFromDate(Date indate)
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
    
    protected abstract void initAction();
    
    
}
