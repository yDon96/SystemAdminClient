/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CAAYcyclic.SystemAdiminClient.view.panel.content;
import CAAYcyclic.SystemAdiminClient.enumeration.ApplicationColor;
import CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJTextField;
import CAAYcyclic.SystemAdiminClient.view.panel.component.RoundedButton;
import com.toedter.calendar.JDateChooser;
import CAAYcyclic.SystemAdiminClient.view.panel.component.CustomComboBox;
import javax.swing.JLabel;


/**
 *
 * @author Youssef
 */
public class UserFormPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProcedureForm
     */
    public UserFormPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        roundedPanel1 = new CAAYcyclic.SystemAdiminClient.view.panel.component.RoundedPanel();
        jSeparator1 = new javax.swing.JSeparator();
        saveBtn = new CAAYcyclic.SystemAdiminClient.view.panel.component.RoundedButton();
        firstFild = new javax.swing.JLabel();
        firstFild1 = new javax.swing.JLabel();
        formDescription = new javax.swing.JLabel();
        firstFild2 = new javax.swing.JLabel();
        firstFild4 = new javax.swing.JLabel();
        dataChooser = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        roleCbx = new CustomComboBox<>();
        nameTxt = new CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJTextField();
        surnameTxt = new CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJTextField();

        setBackground(new java.awt.Color(242, 241, 241));
        setMinimumSize(new java.awt.Dimension(879, 666));

        titleLabel.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        titleLabel.setForeground(ApplicationColor.primaryColor.value);
        titleLabel.setText("User");
        titleLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        titleLabel.setMaximumSize(new java.awt.Dimension(200, 46));

        roundedPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundedPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        saveBtn.setBackground(ApplicationColor.accentColor.value);
        saveBtn.setText("Save");

        firstFild.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        firstFild.setForeground(ApplicationColor.primaryColor.value);
        firstFild.setText("Name");

        firstFild1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        firstFild1.setForeground(ApplicationColor.primaryColor.value);
        firstFild1.setText("Surname");

        formDescription.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        formDescription.setForeground(new java.awt.Color(153, 153, 153));
        formDescription.setText("jLabel1");

        firstFild2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        firstFild2.setForeground(ApplicationColor.primaryColor.value);
        firstFild2.setText("Date of Birth");

        firstFild4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        firstFild4.setForeground(ApplicationColor.primaryColor.value);
        firstFild4.setText("Role");

        dataChooser.setBackground(new java.awt.Color(255, 255, 255));
        dataChooser.setDateFormatString("dd/MM/yyyy");
        dataChooser.setMinimumSize(new java.awt.Dimension(39, 28));
        dataChooser.setPreferredSize(new java.awt.Dimension(95, 28));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setMinimumSize(new java.awt.Dimension(879, 666));
        jSeparator2.setPreferredSize(new java.awt.Dimension(879, 666));

        roleCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none" }));
        roleCbx.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        roleCbx.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        surnameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(37, 37, 37))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(formDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(roundedPanel1Layout.createSequentialGroup()
                            .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(firstFild1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                .addComponent(surnameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(firstFild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(151, 151, 151)
                            .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(firstFild2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dataChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(firstFild4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roleCbx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(formDescription)
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanel1Layout.createSequentialGroup()
                        .addComponent(firstFild2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dataChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(firstFild)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstFild4)
                    .addComponent(firstFild1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roleCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(roundedPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void surnameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dataChooser;
    private javax.swing.JLabel firstFild;
    private javax.swing.JLabel firstFild1;
    private javax.swing.JLabel firstFild2;
    private javax.swing.JLabel firstFild4;
    private javax.swing.JLabel formDescription;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJTextField nameTxt;
    private CustomComboBox<String> roleCbx;
    private CAAYcyclic.SystemAdiminClient.view.panel.component.RoundedPanel roundedPanel1;
    private CAAYcyclic.SystemAdiminClient.view.panel.component.RoundedButton saveBtn;
    private CAAYcyclic.SystemAdiminClient.view.panel.component.CustomJTextField surnameTxt;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    public JDateChooser getDataChooser() {
        return dataChooser;
    }

    public JLabel getFormDescription() {
        return formDescription;
    }

    public CustomJTextField getNameTxt() {
        return nameTxt;
    }

    public CustomComboBox<String> getRoleCbx() {
        return roleCbx;
    }

    public CustomJTextField getSurnameTxt() {
        return surnameTxt;
    }

    public RoundedButton getSaveBtn() {
        return saveBtn;
    }

}
