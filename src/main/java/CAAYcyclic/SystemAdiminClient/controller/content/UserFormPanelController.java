/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content;

import CAAYcyclic.SystemAdiminClient.navigation.Segue;
import CAAYcyclic.SystemAdiminClient.view.panel.content.UserFormPanel;
import java.util.logging.Logger;

/**
 *
 * @author Youssef
 */
public class UserFormPanelController extends ContentPanelController{
    
    private UserFormPanel userForm;
    
    private static final Logger LOG = Logger.getLogger(UserFormPanelController.class.getName());
    
    public UserFormPanelController() {
        super();
        setContentPanel(UserFormPanel.class);
    }

    @Override
    public void panelDidAppear() {
        super.panelDidAppear();
        initComponent();
    }
    
     private void initComponent() {
        this.userForm = (UserFormPanel) getPanel();
    }

    @Override
    public Logger getLogger() {
        return LOG;
    }

    @Override
    public void prepare(Segue segue) {
    }
    
    
}
