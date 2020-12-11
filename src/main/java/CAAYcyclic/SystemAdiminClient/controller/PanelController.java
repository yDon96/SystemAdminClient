/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller;

import CAAYcyclic.SystemAdiminClient.coordinator.IAppCoordinator;
import CAAYcyclic.SystemAdiminClient.model.Parcel;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Youssef
 */
public abstract class PanelController implements IPanelController{
    
    private JPanel panel;
    
    private IAppCoordinator coordinator;
    
    private HashMap<String,Parcel> parcels;

    private boolean lockNavigation = false;
    
    protected Logger LOG;

    public PanelController() {
        LOG = getLogger();
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    @Override
    public void setCoordinator(IAppCoordinator coordinator) {
        this.coordinator = coordinator;
    }

    public IAppCoordinator getCoordinator() {
        return coordinator;
    }
    

    @Override
    public void unlockNavigation(){
        LOG.log(java.util.logging.Level.WARNING, "Unlock Navigation.");
        lockNavigation = false;
    }

    @Override
    public void lockNavigation(){
        LOG.log(java.util.logging.Level.WARNING, "Lock Navigation.");
        lockNavigation = true;
    }

    public boolean isLockNavigation() {
        return lockNavigation;
    }
    
    @Override
    public void panelWillAppear(){
        LOG.log(java.util.logging.Level.INFO, "{0} will appear.", panel.getClass().getName());
    }
    
    @Override
    public void panelDidAppear(){
        LOG.log(java.util.logging.Level.INFO, "{0} did appear.", panel.getClass().getName());
    }
    
    @Override
    public void panelWillDisappear(){
        LOG.log(java.util.logging.Level.INFO, "{0} will disappear.", panel.getClass().getName());
    }
    
    @Override
    public void panelDidDisappear(){
        LOG.log(java.util.logging.Level.INFO, "{0} did disappear.", panel.getClass().getName());
    }
    
    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void setParcel(String id, Parcel parcel){
        if(parcels == null){
            parcels = new HashMap<>();
        }
        parcels.put(id, parcel);
    };

    public HashMap<String, Parcel> getParcels() {
        return parcels;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.panel);
        hash = 83 * hash + Objects.hashCode(this.coordinator);
        hash = 83 * hash + (this.lockNavigation ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.LOG);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PanelController other = (PanelController) obj;
        if (this.lockNavigation != other.lockNavigation) {
            return false;
        }
        if (!Objects.equals(this.panel, other.panel)) {
            return false;
        }
        if (!Objects.equals(this.coordinator, other.coordinator)) {
            return false;
        }
        if (!Objects.equals(this.LOG, other.LOG)) {
            return false;
        }
        return true;
    }
    
    
}
