/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.form.procedure;

import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;
import CAAYcyclic.SystemAdiminClient.model.Procedure;
import CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJList;
import CAAYcyclic.SystemAdiminClient.view.panel.content.ProcedureFormPanel;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Youssef
 */
public abstract class ProcedureFormPanelController extends ContentPanelController {

    private static final Logger LOG = Logger.getLogger(ProcedureFormPanelController.class.getName());

    protected ProcedureFormPanel procedureForm;

    protected JButton saveBtn;
    protected JTextArea descriptionTxt;
    protected JTextField titleTxt;
    protected Procedure procedure;
    protected CustomJList<String> competencyJList;

    public ProcedureFormPanelController() {
        super();
        setContentPanel(ProcedureFormPanel.class);
        initComponent();
    }

    private void initComponent() {
        LOG.log(java.util.logging.Level.CONFIG, "Init Procedure panel component into controller.");
        this.procedureForm = (ProcedureFormPanel) getPanel();
        saveBtn = procedureForm.getSaveBtn();
        titleTxt = procedureForm.getTitleTxt();
        descriptionTxt = procedureForm.getDescriptionTxt();
        competencyJList = procedureForm.getCompetencyList();
    }

    protected abstract void setButtonAction();

    protected void endSavingProcedure() {
        procedureForm.setSaveText();
    }


    protected boolean textRespectPattern(String input){
        return Pattern.compile("^[a-zA-Z]+$").matcher(input).matches();
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
