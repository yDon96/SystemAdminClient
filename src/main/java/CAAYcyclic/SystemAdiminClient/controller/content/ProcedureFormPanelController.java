/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiProcedureDelegate;
import CAAYcyclic.SystemAdiminClient.model.Procedure;
import CAAYcyclic.SystemAdiminClient.builder.AlertDialog.impl.AlertDialogBuilder;
import CAAYcyclic.SystemAdiminClient.view.panel.content.ProcedureFormPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Youssef
 */
public class ProcedureFormPanelController extends ContentPanelController {

    private static final Logger LOG = Logger.getLogger(ProcedureFormPanelController.class.getName());

    private ProcedureFormPanel procedureForm;

    private JButton saveBtn;
    private JButton cancelBtn;
    private JTextArea descriptionTxt;
    private JTextField titleTxt;
    private Procedure procedure;
    private boolean createProcedure = true;

    public ProcedureFormPanelController() {
        super();
        setContentPanel(ProcedureFormPanel.class);
        initComponent();
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear(); 
        
        if(getParcels() != null){
            procedure = new Procedure();
            procedure.createFromParcel(getParcels().get(procedure.getParcelableDescription()));
            titleTxt.setText(procedure.getTitle());
            descriptionTxt.setText(procedure.getDescription());
            createProcedure = false;
        }
        
    }

    
    @Override
    public void panelDidAppear() {
        super.panelDidAppear();
    }

    private void initComponent() {
        LOG.log(java.util.logging.Level.CONFIG, "Init Procedure panel component into controller.");
        this.procedureForm = (ProcedureFormPanel) getPanel();
        saveBtn = procedureForm.getSaveBtn();
        titleTxt = procedureForm.getTitleTxt();
        descriptionTxt = procedureForm.getDescriptionTxt();
        setButtonAction();
    }

    private void setButtonAction() {
        saveBtn.addMouseListener(saveBtnAction);
    }

    private MouseAdapter saveBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "Start saving action.");
            if(createProcedure){
                startSavingProcedure();
            } else {
                startEditProcedure();
            }
        }
    };

    private Procedure generateProcedure() {
        if (isTitleEmpty()) {
            return null;
        }
        Procedure procedure = new Procedure();
        procedure.setTitle(titleTxt.getText().trim());
        procedure.setDescription(descriptionTxt.getText().trim());
        return procedure;
    }
    
    private boolean isTitleEmpty(){
        if (titleTxt.getText().equals("")) {
            LOG.log(java.util.logging.Level.WARNING, "Title cannot be null.");
            procedureForm.setTitleInvalid();
            showError("Title cannot be null.");
            return true;
        }
        return false;
    }

    private void showError(String message) {
        AlertDialogBuilder alertBuilder = new AlertDialogBuilder();
        alertBuilder.setTitle("Error");
        alertBuilder.setMessage(message);
        alertBuilder.setDefaultPositiveAction();
        getCoordinator().showAlert(alertBuilder);
    }

    private void startSavingProcedure() {
        Procedure procedure = generateProcedure();
        if (procedure != null) {
            procedureForm.setSavingText();
            ApiManager.getIstance().createProcedure(procedure, apiDelegate);
        }
    }
    
    private void startEditProcedure() {
        if (!isTitleEmpty()) {
            procedure.setTitle(titleTxt.getText().trim());
            procedure.setDescription(descriptionTxt.getText().trim());
            procedureForm.setSavingText();
            ApiManager.getIstance().createProcedure(procedure, apiDelegate);
        }
    }

    private void endSavingProcedure() {
        procedureForm.setSaveText();
    }

    private ApiProcedureDelegate apiDelegate = new ApiProcedureDelegate() {
        @Override
        public void onGetAllSuccess(List<Procedure> procedures) {
            endSavingProcedure();
        }

        @Override
        public void onGetSuccess(Procedure procedure) {
            endSavingProcedure();
        }

        @Override
        public void onFailure(String message) {
            endSavingProcedure();
            showError(message);
        }

        @Override
        public void onCreateSuccess() {
            endSavingProcedure();
            getCoordinator().popBack();
        }
    };

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
