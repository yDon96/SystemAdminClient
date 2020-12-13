/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.component;

import CAAYcyclic.SystemAdiminClient.enumeration.ApplicationColor;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.text.Document;

/**
 *
 * @author Youssef
 */
public class CustomJTextField extends JTextField {

    public CustomJTextField() {
        initComponent();
        initAction();
    }

    public CustomJTextField(String text) {
        super(text);
        initComponent();
        initAction();
    }

    public CustomJTextField(int columns) {
        super(columns);
        initComponent();
        initAction();
    }

    public CustomJTextField(String text, int columns) {
        super(text, columns);
        initComponent();
        initAction();
    }

    public CustomJTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
        initComponent();
        initAction();
    }
    
    private void initAction(){
       this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                titleTxtFocusLost(evt);
            }
        });
       
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleTxtMouseClicked(evt);
            }
        });
        
    }
    private void initComponent(){
        this.setForeground(Color.decode("#999999"));
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.decode("#999999")),BorderFactory.createEmptyBorder(5,5,5,5)));
        refresh();
    }
    
    private void titleTxtFocusLost(java.awt.event.FocusEvent evt) {                                   
        initComponent();
    }                                  

    private void titleTxtMouseClicked(java.awt.event.MouseEvent evt) {                                      
        this.setForeground(ApplicationColor.primaryColor.value);
        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0,0,3,0,ApplicationColor.accentColor.value),BorderFactory.createEmptyBorder(5,5,5,5)));
        refresh();
    } 
    
    public void refresh() {
        this.revalidate();
        this.repaint();
    }
    
}
