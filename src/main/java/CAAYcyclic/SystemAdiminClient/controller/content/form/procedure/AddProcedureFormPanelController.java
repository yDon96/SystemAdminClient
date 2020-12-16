/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.form.procedure;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.model.Competency;
import CAAYcyclic.SystemAdiminClient.model.MyArrayList;
import CAAYcyclic.SystemAdiminClient.model.Procedure;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Youssef
 */
public class AddProcedureFormPanelController extends ProcedureFormPanelController {

    private static final Logger LOG = Logger.getLogger(AddProcedureFormPanelController.class.getName());
    
    private MyArrayList<Competency> competencies; 

    public AddProcedureFormPanelController() {
        super();
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear(); 
        setButtonAction();
        if(getParcels() != null){
            getConpetenciesList();    
        }
    }
    
    private void getConpetenciesList(){
        competencies = new MyArrayList<Competency>(Competency.class); 
        if(getParcels().containsKey(competencies.getParcelableDescription())){
            LOG.log(java.util.logging.Level.CONFIG, "Get compitencies from parcel object.");
            competencies.createFromParcel(getParcels().get(competencies.getParcelableDescription()),Competency.class);
            DefaultListModel demoList = new DefaultListModel();
            for (Competency competency: competencies){
                demoList.addElement(competency.getName());
            }
            competencyJList.setModel(demoList);
        }
    }

    
    
    @Override
    protected void setButtonAction() {
        saveBtn.addMouseListener(saveBtnAction);
    }
    
    private MouseAdapter saveBtnAction = new MouseAdapter() {
        
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "Start saving action.");
            startSavingProcedure();
        }
        
    };
    
    private boolean areAllRequiredFieldValid(){
        if (titleTxt.getText() == null || titleTxt.getText().trim().isEmpty()) {
            LOG.log(java.util.logging.Level.WARNING, "Title cannot be null.");
            procedureForm.setTitleInvalid();
            showSelectionError("Title cannot be null.");
            return false;
        }
        return true;
    }

    private void startSavingProcedure() {
        if(!areAllRequiredFieldValid()){
            LOG.log(java.util.logging.Level.WARNING, "There are some required field empty or not valid.");
            showSelectionError("One or more field need to be filled.");
            return;
        }
        
        String title = titleTxt.getText().trim();
        
        if(!textRespectPattern(title)) {
            LOG.log(java.util.logging.Level.WARNING, "String do not conform regex pattern.");
            showSelectionError("The input value must contain only characters of the alphabet.");
            return;
        }
        
        Procedure procedure = new Procedure(title,descriptionTxt.getText().trim());
        if(competencyJList.getSelectedIndices() != null){
            Set<String> selectedCompetency = new HashSet<String>();
            for(int index : competencyJList.getSelectedRow()){
                selectedCompetency.add(competencies.get(index).getName());
            }
            procedure.setCompetencies(selectedCompetency);
        }
        procedureForm.setSavingText();
        ApiManager.getIstance().createProcedure(procedure, apiDelegate);
    }
    
    private ApiDelegate<Procedure> apiDelegate = new ApiDelegate<Procedure>() {
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
            showSelectionError(message);
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
