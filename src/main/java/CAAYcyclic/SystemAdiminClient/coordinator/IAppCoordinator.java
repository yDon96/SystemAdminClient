/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.coordinator;

import CAAYcyclic.SystemAdiminClient.builder.AlertDialog.IAlertBuilder;
import CAAYcyclic.SystemAdiminClient.model.Parcelable;

/**
 *
 * @author Youssef
 */
public interface IAppCoordinator {
    
    void switchPanelToDashboard();
    
    void switchPanelToProcedurePanel();
    
    void switchPanelToUserPanel();
    
    void switchPanelToRolePanel();
    
    public void switchPanelToCompetencyPanel();
    
    void navigateToProcedureForm(Parcelable procedure,Parcelable competencies);
    
    void navigateToUserForm(Parcelable user, Parcelable rolesList, Parcelable competencies);
    
    void navigateToRoleForm();
    
    void navigateToCompetencyForm();
    
    void popBack();
    
    void showAlert(IAlertBuilder alert);
}
