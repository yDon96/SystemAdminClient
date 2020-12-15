/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.form.procedure;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.model.Procedure;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

/**
 *
 * @author Youssef
 */
public class EditProcedureFormPanelController extends ProcedureFormPanelController {

    private static final Logger LOG = Logger.getLogger(EditProcedureFormPanelController.class.getName());

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
        }
        setButtonAction();
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

    @Override
    public Logger getLogger() {
        return LOG;
    }

}
