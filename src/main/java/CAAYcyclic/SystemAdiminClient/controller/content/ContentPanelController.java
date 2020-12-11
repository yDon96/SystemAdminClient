/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.controller.content;

import CAAYcyclic.SystemAdiminClient.controller.PanelController;
import javax.swing.JPanel;

/**
 *
 * @author Youssef
 */
public abstract class ContentPanelController extends PanelController implements IContentPanelController {

    public ContentPanelController() {
        super();
    }
    
    @Override
    public void setContentPanel(Class<? extends JPanel> panelName){
        LOG.log(java.util.logging.Level.INFO, "Set panel: {0}", panelName.getClass().getName());
        try{
            setPanel((JPanel) panelName.newInstance());
        } catch (IllegalAccessException | InstantiationException exception){
            LOG.log(java.util.logging.Level.WARNING, "Cannot instancete the panel.");
            return;
        }
    }
    
    @Override
    public void setContentPanel(JPanel panel){
        LOG.log(java.util.logging.Level.INFO, "Set panel: {0}", panel.getClass().getName());
        setPanel(panel);
    }
    
    
    

}
