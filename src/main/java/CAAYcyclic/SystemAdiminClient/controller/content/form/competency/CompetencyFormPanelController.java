/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.form.competency;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;
import CAAYcyclic.SystemAdiminClient.model.Competency;
import CAAYcyclic.SystemAdiminClient.view.panel.content.CompetencyFormPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Youssef
 */
public class CompetencyFormPanelController extends ContentPanelController {

    private static final Logger LOG = Logger.getLogger(CompetencyFormPanelController.class.getSimpleName());

    private CompetencyFormPanel formPanel;
    private JButton saveBtn;
    private JTextField nameTxt;
    
    public CompetencyFormPanelController() {
        super();
        setContentPanel(CompetencyFormPanel.class);
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear(); 
        initComponent();
        setButtonAction();
    }

    private void initComponent() {
        formPanel = (CompetencyFormPanel) getPanel();
        saveBtn = formPanel.getSaveBtn();
        nameTxt = formPanel.getNameTxt();
    }
    
    private void setButtonAction() {
        saveBtn.addMouseListener(saveBtnAction);
    }
    
    private void saveProcedure(){
        if(!areAllRequiredFieldValid()){
            LOG.log(java.util.logging.Level.WARNING, "There are some required field empty or not valid.");
            showSelectionError("One or more field is not valid.");
            return;
        }
        
        String competency = nameTxt.getText();
        
        if(!textRespectPattern(competency)) {
            LOG.log(java.util.logging.Level.WARNING, "String do not conform regex pattern.");
            showSelectionError("The input value must contain only characters of the alphabet.");
            return;
        }
        
        ApiManager.getIstance().createCompetency(competency, competencyDelegate);
    }
    
    private boolean areAllRequiredFieldValid(){
        if (nameTxt.getText() == null || nameTxt.getText().trim().isEmpty()) {
            LOG.log(java.util.logging.Level.WARNING, "Name textfield is empty.");
            return false;
        }
        
        return true;
    }
    
    private boolean textRespectPattern(String input){
        return Pattern.matches("^[a-zA-Z]+$",input);
    }

    private MouseAdapter saveBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.CONFIG, "Start save procedure.");
            saveProcedure();
        }
    };
    
    private ApiDelegate<Competency> competencyDelegate = new ApiDelegate<Competency>() {
        @Override
        public void onGetAllSuccess(List<Competency> competencys) {
            
        }

        @Override
        public void onGetSuccess(Competency competency) {
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
