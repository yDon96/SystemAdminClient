/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.bar;

import CAAYcyclic.SystemAdiminClient.enumeration.ApplicationColor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Youssef
 */
public final class MainSideBarPanel extends JPanel {

    /**
     * Creates new form MainSideBarPanel
     */
    
    private JButton selectedButton;
    
    public MainSideBarPanel() {
        initComponents();
        highlightButton(dashBtn);
    }

    public JButton getDashBtn() {
        return dashBtn;
    }

    public JButton getProcedureBtn() {
        return procedureBtn;
    }

    public JButton getUserBtn() {
        return userBtn;
    }

    public JButton getRoleBtn() {
        return roleBtn;
    }

    public JButton getCompetencyBtn() {
        return competencyBtn;
    }
    
    
    public void highlightButton(JButton button) {
        
        if (selectedButton != null){
            selectedButton.setBorderPainted(false);
            selectedButton.setBackground(null);
            selectedButton.setFont(button.getFont().deriveFont(Font.PLAIN));
        }
        
        button.setBorderPainted(true);
        button.setBackground(ApplicationColor.accentColor.value);
        button.setFont(button.getFont().deriveFont(Font.BOLD));
        selectedButton = button;
        this.revalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashBtn = new javax.swing.JButton();
        procedureBtn = new javax.swing.JButton();
        userBtn = new javax.swing.JButton();
        roleBtn = new javax.swing.JButton();
        competencyBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(ApplicationColor.primaryColor.value);
        setMinimumSize(new java.awt.Dimension(151, 353));

        dashBtn.setBackground(ApplicationColor.primaryColor.value);
        dashBtn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        dashBtn.setForeground(new java.awt.Color(255, 255, 255));
        dashBtn.setText("DashBoard");
        dashBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0), javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(242, 241, 241))));
        dashBtn.setBorderPainted(false);
        dashBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dashBtn.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        dashBtn.setMargin(new java.awt.Insets(0, 10, 0, 10));
        dashBtn.setOpaque(true);

        procedureBtn.setBackground(ApplicationColor.primaryColor.value);
        procedureBtn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        procedureBtn.setForeground(new java.awt.Color(255, 255, 255));
        procedureBtn.setText("Procedure");
        procedureBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0), javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(242, 241, 241))));
        procedureBtn.setBorderPainted(false);
        procedureBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        procedureBtn.setOpaque(true);

        userBtn.setBackground(ApplicationColor.primaryColor.value);
        userBtn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        userBtn.setForeground(new java.awt.Color(255, 255, 255));
        userBtn.setText("User");
        userBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0), javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(242, 241, 241))));
        userBtn.setBorderPainted(false);
        userBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userBtn.setOpaque(true);

        roleBtn.setBackground(ApplicationColor.primaryColor.value);
        roleBtn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        roleBtn.setForeground(new java.awt.Color(255, 255, 255));
        roleBtn.setText("Role");
        roleBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0), javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(242, 241, 241))));
        roleBtn.setBorderPainted(false);
        roleBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roleBtn.setOpaque(true);

        competencyBtn.setBackground(ApplicationColor.primaryColor.value);
        competencyBtn.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        competencyBtn.setForeground(new java.awt.Color(255, 255, 255));
        competencyBtn.setText("Competency");
        competencyBtn.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0), javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 3, new java.awt.Color(242, 241, 241))));
        competencyBtn.setBorderPainted(false);
        competencyBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        competencyBtn.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>System<br>Adimin<br>Client");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(procedureBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(userBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(competencyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(dashBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(procedureBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(competencyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton competencyBtn;
    private javax.swing.JButton dashBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton procedureBtn;
    private javax.swing.JButton roleBtn;
    private javax.swing.JButton userBtn;
    // End of variables declaration//GEN-END:variables
}
