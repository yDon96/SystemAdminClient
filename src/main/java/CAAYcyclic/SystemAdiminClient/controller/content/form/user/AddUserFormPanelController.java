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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

/**
 *
 * @author Youssef
 */
public class AddUserFormPanelController extends UserFormPanelController {

    private static final Logger LOG = Logger.getLogger(AddUserFormPanelController.class.getName());

    private MyArrayList<Competency> competencies;

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
        getConpetenciesList();
        setDefaultRoleSelectionValue();
        setDefaultRoleSelectionDelegate();
        setDefaultCompetencyListState();
    }

    private void setDefaultRoleSelectionValue() {
        rolesCbx.setSelectedIndex(0);
    }

    ;
    
    private void setDefaultRoleSelectionDelegate() {
        rolesCbx.setComboBoxDelegate(comboBoxDelegate);
    }

    ;
    
    private void setDefaultCompetencyListState() {
        competencyJList.setEnabled(false);
    }

    ;
    
    private void getRolesList() {
        roles = new MyArrayList<>(Role.class);
        if (getParcels().containsKey(roles.getParcelableDescription())) {
            LOG.log(java.util.logging.Level.CONFIG, "Get roles from parcel object.");
            roles.createFromParcel(getParcels().get(roles.getParcelableDescription()), Role.class);
            for (Role role : roles) {
                rolesCbx.addItem(role.getName());
            }
        } else {
            LOG.log(java.util.logging.Level.SEVERE, "Parcel do not contains any roles.");
            showSelectionError("An error occured during role's value retrive.");
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
        }
    }

    @Override
    protected void initAction() {
        saveBtn.addMouseListener(saveBtnAction);
    }

    private MouseAdapter saveBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.CONFIG, "Start save procedure.");
            startSaveProcedure();
        }
    };

    private void startSaveProcedure() {
        if (!allRequiredFieldAreValid()) {
            LOG.log(java.util.logging.Level.WARNING, "There are some required field empty or not valid.");
            showSelectionError("One or more field need to be filled.");
            return;
        }
        String name = nameTxt.getText().trim();
        String surname = surnameTxt.getText().trim();
        if (!textRespectPattern(name) || !textRespectPattern(surname)) {
            LOG.log(java.util.logging.Level.WARNING, "String do not conform regex pattern.");
            showSelectionError("The input value must contain only characters of the alphabet.");
            return;
        }
        User user = new User(name, surname, convertStringFromDate(dataChooser.getDate()), rolesCbx.getSelectedRowValue());
        if (competencyJList.getSelectedIndices() != null) {
            Set<String> selectedCompetency = new HashSet<String>();
            for (int index : competencyJList.getSelectedRow()) {
                selectedCompetency.add(competencies.get(index).getName());
            }
            user.setCompetencies(selectedCompetency);
        }
        ApiManager.getIstance().createUser(user, apiUserDelegate);
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

        return true;
    }

    private boolean textRespectPattern(String input) {
        return Pattern.compile("^[a-zA-Z]+$").matcher(input).matches();
    }

    private IComboBoxDelegate comboBoxDelegate = new IComboBoxDelegate() {
        @Override
        public void didSelectRowAt(JComboBox combobox, Integer selectedIndexRow) {
            if(selectedIndexRow - 1 < 0){
                competencyJList.setEnabled(false);
                return;
            }
            if (roles.get(selectedIndexRow - 1).getName().toUpperCase().equals("MAINTAINER")) {
                competencyJList.setEnabled(true);
            } else {
                competencyJList.clearAllSelection();
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
            getCoordinator().popBack();
        }
    };

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
