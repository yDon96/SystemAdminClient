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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Youssef
 */
public class EditProcedureFormPanelController extends ProcedureFormPanelController {

    private static final Logger LOG = Logger.getLogger(EditProcedureFormPanelController.class.getName());

    private MyArrayList<Competency> competencies; 

    public EditProcedureFormPanelController() {
        super();
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear(); 
        if(getParcels() != null){
            procedure = new Procedure();
            procedure.createFromParcel(getParcels().get(procedure.getParcelableDescription()));
            titleTxt.setText(procedure.getTitle());
            descriptionTxt.setText(procedure.getDescription());
            titleTxt.setEditable(false);
            getConpetenciesList();
        }
        setButtonAction();
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
            competencyJList.setSelectedElement(procedure.getCompetencies());
            //Todo: Re-enable when Update call is completed
            competencyJList.setEnabled(false);
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
            startEditProcedure();
        }
    };
    
    private void startEditProcedure() {
        procedure.setDescription(descriptionTxt.getText().trim());
        procedureForm.setSavingText();
        ApiManager.getIstance().editProcedure(procedure.getId(),procedure.getDescription(), apiDelegate);
    }
    
    private void assginNewCompetencies(){
        ArrayList<String> competenciesString = new ArrayList<String>();
        for(int index: competencyJList.getSelectedRow()){
            competenciesString.add(competencies.get(index).getName());
        }
        ApiManager.getIstance().assingCompenteciesToProcedure(procedure.getId(), competenciesString, apiAssignDelegate);
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
            if(competencyJList.isSelectionChanged()){
               assginNewCompetencies();
            }else{
                endSavingProcedure(); 
                getCoordinator().popBack();
            }
        }
    };
    
    private ApiDelegate<Object> apiAssignDelegate = new ApiDelegate<Object>() {
        @Override
        public void onGetAllSuccess(List<Object> object) {
            endSavingProcedure();
        }

        @Override
        public void onGetSuccess(Object object) {
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
