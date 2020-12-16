/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.datapanel;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.model.Procedure;
import CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl.DataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.builder.Director;
import CAAYcyclic.SystemAdiminClient.controller.component.jtable.ITableDelegate;
import CAAYcyclic.SystemAdiminClient.controller.component.jtable.impl.TableDataSource;
import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;
import CAAYcyclic.SystemAdiminClient.model.Competency;
import CAAYcyclic.SystemAdiminClient.model.MyArrayList;
import CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJTable;
import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.*;

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
    private CustomJTable table;
    private Procedure selectedProcedure;
    private List<Procedure> procedures;
    private MyArrayList<Competency> competencies;

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
    public void panelWillAppear() {
        super.panelWillAppear();
        Thread newThread = new Thread(() -> {
            ApiManager.getIstance().getProcedures(apiDelegate);
        });
        newThread.start();
        Thread newThread2 = new Thread(() -> {
            ApiManager.getIstance().getCompetencyList(apiCompetencyDelegate);
        });
        newThread2.start();
    }

    private void initComponent() {
        LOG.log(java.util.logging.Level.CONFIG, "Init Procedure panel component into controller.");
        procedureView = (DataPanel) getPanel();
        updateBtn = procedureView.getUpdateBtn();
        editBtn = procedureView.getEditBtn();
        addBtn = procedureView.getAddBtn();
        table = (CustomJTable) procedureView.getTableView();
        table.setTableDelegate(tableDelegate);
        setTableDataSource(table);
        numberOfRow = procedureView.getNumberOfRow();
    }
    
    private void setTableDataSource(CustomJTable jtable){
        TableDataSource<Procedure> datasource = new TableDataSource<>();
        jtable.setiTableDataSource(datasource);
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
            if (selectedProcedure == null) {
                LOG.log(java.util.logging.Level.WARNING, "Number of row is \"0\" or no row is selected.");
                showError("Edit Error", "No element is selected.");
                return;
            } else {
                editBtn.setSelected(false);
                getCoordinator().navigateToProcedureForm(procedures.get(table.getSelectedRow()),competencies);
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
                getCoordinator().navigateToProcedureForm(null,competencies);
            } else {
                LOG.log(java.util.logging.Level.WARNING, "Cannot swich panel, navigation is locked.");
                showSelectionError("Wait until data ends updating.");
            }
        }
    };

    public void setProcedures(List<Procedure> procedures) {
        this.procedures = procedures;
    }
    
    private ITableDelegate tableDelegate = new ITableDelegate() {
        @Override
        public void didSelectRowAt(JTable jTable, Integer selectedIndexRow) {
            selectedProcedure = procedures.get(selectedIndexRow);
        }

        @Override
        public void didDeselectRowAt(JTable jTable, Integer deselectedIndexRow) {
            selectedProcedure = null;
        }
        
    };
    
    private ApiDelegate<Competency> apiCompetencyDelegate = new ApiDelegate<Competency>() {
        @Override
        public void onGetAllSuccess(List<Competency> competencies) {
            setCompetencies(competencies);
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
        }
    };

    private ApiDelegate<Procedure> apiDelegate = new ApiDelegate<Procedure>() {
        @Override
        public void onGetAllSuccess(List<Procedure> procedures) {
            endUpdate();
            if (procedures.size() > 0) {
                setProcedures(procedures);
                table.getiTableDataSource().setElementToDisplay(procedures);
                table.refreshData();
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
        updateBtn.setText("Refreshing...");
        ApiManager.getIstance().getProcedures(apiDelegate);
    }

    private void endUpdate() {
        updateBtn.setText("Refresh");
    }

    public void setCompetencies(List<Competency> competencies) {
        this.competencies = new MyArrayList<>(Competency.class,competencies);
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }


}
