/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller;

import CAAYcyclic.SystemAdiminClient.navigation.Segue;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Youssef
 */
public abstract class PanelController implements IPanelController{
    
    private JPanel panel;
    
    
    private boolean lockNavigation = false;
    
    protected Logger LOG;

    public PanelController() {
        LOG = getLogger();
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    }

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

        }
    }
    
    @Override
    public JPanel getPanel() {
        return panel;
    }
}
