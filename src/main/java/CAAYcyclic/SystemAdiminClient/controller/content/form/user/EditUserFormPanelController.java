/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.form.user;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.controller.component.Jcombobox.IComboBoxDelegate;
import CAAYcyclic.SystemAdiminClient.model.Competency;
import CAAYcyclic.SystemAdiminClient.model.MyArrayList;
import CAAYcyclic.SystemAdiminClient.model.Role;
import CAAYcyclic.SystemAdiminClient.model.User;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

/**
 *
 * @author Youssef
 */
public class EditUserFormPanelController extends UserFormPanelController {

    private static final Logger LOG = Logger.getLogger(AddUserFormPanelController.class.getName());

    private MyArrayList<Competency> competencies;

    public EditUserFormPanelController() {
        super();
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear();
        userForm.getFormDescription().setText("Edit user with new value");
        setDefaultRoleSelectionDelegate();
        getParcelInfo();
        setDefaultCompetencyListState();
    }

    @Override
    protected void initAction() {
        saveBtn.addMouseListener(saveBtnAction);
    }

    private void setDefaultRoleSelectionDelegate() {
        rolesCbx.setComboBoxDelegate(comboBoxDelegate);
    }

    ;
    
    private void setDefaultCompetencyListState() {
        if (!user.getRole().toUpperCase().equals("MAINTAINER")) {
            competencyJList.setEnabled(false);
        }
    }

    ;

    private void getParcelInfo() {
        user = new User();
        if (getParcels() != null) {
            getRolesList();
            getUserToModify();
            getConpetenciesList();
            disableAllNotEditableField();
        } else {
            LOG.log(java.util.logging.Level.SEVERE, "Parcel shouldn't be empty.");
        }
    }

    private void getRolesList() {
        roles = new MyArrayList<>(Role.class);
        if (getParcels().containsKey(roles.getParcelableDescription())) {
            roles.createFromParcel(getParcels().get(roles.getParcelableDescription()), Role.class);
            for (Role role : roles) {
                rolesCbx.addItem(role.getName());
            }
        } else {
            LOG.log(java.util.logging.Level.SEVERE, "Parcel do not contains any roles.");
            showSelectionError("An error occured during role's value retrive operation.");
            getCoordinator().popBack();
        }
    }

    private void getUserToModify() {
        if (getParcels().containsKey(user.getParcelableDescription())) {
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

    private void getConpetenciesList() {
        competencies = new MyArrayList<Competency>(Competency.class);
        if (getParcels().containsKey(competencies.getParcelableDescription())) {
            LOG.log(java.util.logging.Level.CONFIG, "Get compitencies from parcel object.");
            competencies.createFromParcel(getParcels().get(competencies.getParcelableDescription()), Competency.class);
            DefaultListModel demoList = new DefaultListModel();
            for (Competency competency : competencies) {
                demoList.addElement(competency.getName());
            }
            competencyJList.setModel(demoList);
            competencyJList.setSelectedElement(user.getCompetencies());
        }
    }

    private void disableAllNotEditableField() {
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

    private void startSaveProcedure() {
        if (!allRequiredFieldAreValid()) {
            showSelectionError("One or more field need to be filled.");
            return;
        }

        if (rolesCbx.getSelectedRowValue() == null) {
            showSelectionError("Please select a valid role.");
            return;
        }

        if (rolesCbx.isOriginalSelection()) {
            if (competencyJList.isSelectionChanged()) {
                assginNewCompetencies();

            } else {
                getCoordinator().popBack();
            }
            return;
        }

        ApiManager.getIstance().assingRole(user.getUser_id(), rolesCbx.getSelectedRowValue(), apiUserDelegate);
    }

    private void assginNewCompetencies() {
        ArrayList<String> competenciesString = new ArrayList<String>();
        for (int index : competencyJList.getSelectedRow()) {
            competenciesString.add(competencies.get(index).getName());
        }
        ApiManager.getIstance().assingCompenteciesToUser(user.getUser_id(), competenciesString, apiAssignDelegate);
    }

    private boolean allRequiredFieldAreValid() {
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

    private IComboBoxDelegate comboBoxDelegate = new IComboBoxDelegate() {
        @Override
        public void didSelectRowAt(JComboBox combobox, Integer selectedIndexRow) {
            if (roles.get(selectedIndexRow - 1).getName().toUpperCase().equals("MAINTAINER")) {
                competencyJList.setEnabled(true);
            } else {
                competencyJList.setEnabled(false);
            }
        }

        @Override
        public void didDeselectRowAt(JComboBox combobox, Integer deselectedIndexRow) {

        }
    };

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
            if (competencyJList.isSelectionChanged()) {
                assginNewCompetencies();
            } else {
                getCoordinator().popBack();
            }
        }
    };

    private ApiDelegate<Object> apiAssignDelegate = new ApiDelegate<Object>() {
        @Override
        public void onGetAllSuccess(List<Object> object) {
        }

        @Override
        public void onGetSuccess(Object object) {
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
