/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.navigation;

import CAAYcyclic.SystemAdiminClient.controller.PanelController;
import CAAYcyclic.SystemAdiminClient.controller.frame.MainFrameController;
import CAAYcyclic.SystemAdiminClient.controller.bar.BarController;
import CAAYcyclic.SystemAdiminClient.controller.container.ContainerController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import CAAYcyclic.SystemAdiminClient.controller.content.ContentPanelController;
import CAAYcyclic.SystemAdiminClient.factory.container.IContainerViewAbstractFactory;

/**
 *
 * @author Youssef
 * 
 * A navigation controller is a controller that helps container view controller to 
 * manage one or more child view controllers in a navigation interface.
 */
public class NavigationController {
    
    private static NavigationController instance = null;
    
    private static final Logger LOG = Logger.getLogger(NavigationController.class.getName()); 
         
    private MainFrameController frameController;

    private ContainerController containerController;

    private final ArrayList<ContentPanelController> panelControllers;

    private final ArrayList<BarController> barControllers;
    
    private final HashMap<String,ContentPanelController> panelControllerMap;


    private NavigationController() {
        LOG.log(java.util.logging.Level.CONFIG, "Init.");
        panelControllers = new ArrayList<>();
        barControllers = new ArrayList<>();
        panelControllerMap = new HashMap<>();
    }

    public static NavigationController getInstance() {
        if(instance==null)
            instance = new NavigationController();
        return instance;
    }
    
    /**
     * Presents the specified content panel controller in the navigation interface.
     * @param panelControllerName
     */
    public void performPanelNavigationTo(Class<? extends PanelController> panelControllerName) {
            LOG.log(java.util.logging.Level.INFO, "Perform navigation to panel: {0}.", panelControllerName.getName());
    }
    
    /**
     * Pops the top view controller from the navigation stack and updates the display.
     * @param panelControllerName
     */
    public void performBackToStack() {
        LOG.log(java.util.logging.Level.INFO, "Restore last view in stack.");
    }
    
    /**
     * Add content view controller to HashMap.
     * @param contentPanelController
     */
    public void addPanelToMap(ContentPanelController contentPanelController){
        LOG.log(java.util.logging.Level.CONFIG, "Add panel {0} to map.", contentPanelController.getClass().getName()); 
    }
    
    /** 
     * Add view controller(BarController, ContentPanelController) to stack.
     * @param barController
     * @param contentPanelController
     */
    private void addViewToStack(BarController barController,ContentPanelController contentPanelController){
        LOG.log(java.util.logging.Level.CONFIG, "Add view [{0}] to stack.",barController.getClass().getName() + "," + contentPanelController.getClass().getName()); 
    }
    
    /**
     * Presents the specified view controller defined by the factory in the navigation interface.
     * @param factory ContainerViewAbstractFactory
     */
    public void performViewNavigationTo(IContainerViewAbstractFactory factory){
        LOG.log(java.util.logging.Level.INFO, "Perform navigation to view given by: {0}.", factory.getClass().getName()); 
    }
    
    /**
     *  Lock panel navigation
     */
    public void lockNavigation(){
    }
    
    /** 
     * Unlock panel navigation
     */
    public void unlockNavigation(){
    }
    
    /**
     * Register the current container associated 
     * with the currently visible panel
     * @param mainViewController
     */
    public void registerContainerController(ContainerController mainViewController){
        LOG.log(java.util.logging.Level.CONFIG, 
                "Set current container controller: {0}.", 
                mainViewController.getClass().getName()); 
    }
    
    /**
     * Register the current frame associated 
     * with the currently visible container.
     * @param myFrameController
     */
    public void registerFrameController(MainFrameController myFrameController){
        LOG.log(java.util.logging.Level.CONFIG, 
                "Set current frame controller: {0}.", 
                myFrameController.getClass().getName()); 
    }
    
    /**
     * The container controller associated 
     * with the currently visible panel in the navigation interface.
     * @return ContainerController type.
     */
    public ContainerController getCurrentContainer(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * The frame controller associated 
     * with the currently visible container in the navigation interface.
     * @return MainFrameController type.
     */
    public MainFrameController getFrameController(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
