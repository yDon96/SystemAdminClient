/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content.datapanel;

import CAAYcyclic.SystemAdiminClient.api.ApiManager;
import CAAYcyclic.SystemAdiminClient.api.delegate.ApiDelegate;
import CAAYcyclic.SystemAdiminClient.builder.DataPanel.impl.DataPanelBuilder;
import CAAYcyclic.SystemAdiminClient.builder.Director;
import CAAYcyclic.SystemAdiminClient.controller.component.jtable.impl.TableDataSource;
import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;
import CAAYcyclic.SystemAdiminClient.model.Competency;
import CAAYcyclic.SystemAdiminClient.model.Role;
import CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJTable;
import CAAYcyclic.SystemAdiminClient.view.panel.content.DataPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Youssef
 */
public class CompetencyPanelController extends ContentPanelController{

    private static final Logger LOG = Logger.getLogger(CompetencyPanelController.class.getCanonicalName());

    private DataPanel competencyPanel;
    private JButton updateBtn;
    private JButton addBtn;
    private JLabel numberOfRow;
    private CustomJTable table;
    private List<Competency> competencyList;
    
    public CompetencyPanelController() {
        super();
        DataPanelBuilder dataPanelBuilder = new DataPanelBuilder();
        Director director = new Director();
        director.constructCompetencyDataPanel(dataPanelBuilder);
        setContentPanel(dataPanelBuilder.getResults());
        initComponent();
        setButtonAction();
    }

    @Override
    public void panelWillAppear() {
        super.panelWillAppear(); 

        getCompetencyList();
    }
    
    private void initComponent() {
        competencyPanel = (DataPanel) getPanel();
        updateBtn = competencyPanel.getUpdateBtn();
        addBtn = competencyPanel.getAddBtn();
        table = (CustomJTable) competencyPanel.getTableView();
        setTableDataSource(table);
        numberOfRow = competencyPanel.getNumberOfRow();
    }
    
    private void setTableDataSource(CustomJTable jtable){
        TableDataSource<Competency> datasource = new TableDataSource<>();
        jtable.setiTableDataSource(datasource);
    }
    
    private void setButtonAction() {
        updateBtn.addMouseListener(updateBtnAction);
        addBtn.addMouseListener(addBtnAction);
    }

    private MouseAdapter updateBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            getCompetencyList();
        }
    };
    
    private MouseAdapter addBtnAction = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
            super.mousePressed(mouseEvent);
            getCoordinator().navigateToCompetencyForm();
        }
    };
    
    private void getCompetencyList(){
        Thread newThread = new Thread(() -> {
            ApiManager.getIstance().getCompetencyList(competencyDelegate);
        });
        newThread.start();
    }
    
    private final ApiDelegate<Competency> competencyDelegate = new ApiDelegate<Competency>() {
        @Override
        public void onGetAllSuccess(List<Competency> competency) {
            if (competency.size() > 0) {
                setCompetencyList(competency);
                table.getiTableDataSource().setElementToDisplay(competency);
                table.refreshData();
                numberOfRow.setText(String.valueOf(table.getRowCount()));
            }
        }

        @Override
        public void onGetSuccess(Competency role) {
        }

        @Override
        public void onFailure(String message) {
            showSelectionError(message);
        }

        @Override
        public void onCreateSuccess() {
        }
    };
    
    public void setCompetencyList(List<Competency> competencyList) {
        this.competencyList = competencyList;
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }
    
}
