/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.model.Procedure;
import CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl.DataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.builder.Director;
import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Youssef
 */
public class ProcedurePanelController extends ContentPanelController {

    public DataPanel procedureView;

    private static final Logger LOG = Logger.getLogger(ProcedurePanelController.class.getName());

    private JButton updateBtn;
    private JButton editBtn;
    private JButton addBtn;
    private JLabel numberOfRow;
    private JTable table;
    List<Procedure> procedures;

    public ProcedurePanelController() {
        super();
        DataPanelBuilder dataPanelBuilder = new DataPanelBuilder();
        Director director = new Director();
        director.constructProcedureDataPanel(dataPanelBuilder);
        setContentPanel(dataPanelBuilder.getResults());
        initComponent();
        setButtonAction();
    }

    @Override
    public void panelDidAppear() {
        super.panelDidAppear();

    }

    private void initComponent() {
        LOG.log(java.util.logging.Level.CONFIG, "Init Procedure panel component into controller.");
        procedureView = (DataPanel) getPanel();
        updateBtn = procedureView.getUpdateBtn();
        editBtn = procedureView.getEditBtn();
        addBtn = procedureView.getAddBtn();
        table = procedureView.getTableView();
        numberOfRow = procedureView.getNumberOfRow();
    }

    private void setButtonAction() {
        updateBtn.addMouseListener(updateBtnAction);
        editBtn.addMouseListener(editBtnAction);
        addBtn.addMouseListener(addBtnAction);
    }

    private MouseAdapter updateBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "Start update action.");
            startUpdate();
        }
    };

    private MouseAdapter editBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "Start edit action.");
            if (table.getRowCount() < 0 || table.getSelectedRow() < 0) {
                LOG.log(java.util.logging.Level.WARNING, "Number of row is \"0\" or no row is selected.");
                showError("Edit Error", "No element is selected.");
                return;
            } else {
                editBtn.setSelected(false);
                getCoordinator().navigateToProcedureForm(procedures.get(table.getSelectedRow()));
            }
        }
    };

    private final MouseAdapter addBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            LOG.log(java.util.logging.Level.INFO, "Start add action.");
            if (!isLockNavigation()) {
                addBtn.setSelected(false);
                getCoordinator().navigateToProcedureForm(null);
            } else {
                LOG.log(java.util.logging.Level.WARNING, "Cannot swich panel, navigation is locked.");
                showSelectionError("Wait until data ends updating.");
            }
        }
    };

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }

    private ApiDelegate<Procedure> apiDelegate = new ApiDelegate<Procedure>() {
        @Override
        public void onGetAllSuccess(List<Procedure> procedures) {
            endUpdate();
            if (procedures.size() > 0) {
                setProcedures(procedures);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                Integer rowNumber = table.getRowCount();
                for (int index = rowNumber - 1; index >= 0; index--) {
                    model.removeRow(index);
                }
                for (Procedure procedure : procedures) {
                    Object[] row = {procedure.getId(), procedure.getTitle(), procedure.getDescription()};
                    model.addRow(row);
                }
                numberOfRow.setText(String.valueOf(table.getRowCount()));
            }
        }

        @Override
        public void onGetSuccess(Procedure procedure) {
            endUpdate();
        }

        @Override
        public void onFailure(String message) {
            endUpdate();
            showSelectionError(message);
        }

        @Override
        public void onCreateSuccess() {
            endUpdate();
        }
    };

    private void startUpdate() {
        updateBtn.setText("Updating...");
        ApiManager.getIstance().getProcedures(apiDelegate);
    }

    private void endUpdate() {
        updateBtn.setText("Update");
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }


}
