/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiNetbean;

import Controller.ChuyenManHinhController;
import Controller.DanhmucBean;
import Storage.Account;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class guiAccountManager extends javax.swing.JFrame {

    /**
     * Creates new form guiAccountManager
     *
     * @param login
     */
    public guiAccountManager(Account login) {
        admin = login;
        initComponents();
        controller = new ChuyenManHinhController(panelView, admin);
        controller.setView(AccountManager, lbAccount);

        List<DanhmucBean> listItem = new ArrayList<DanhmucBean>();
        listItem.add(new DanhmucBean("AccountManager", AccountManager, lbAccount));
        listItem.add(new DanhmucBean("StatisChart", StaticChart, lbStatic));
        listItem.add(new DanhmucBean("AdminProfile", AdminProfile, lbAdminProfile));

        controller.setEvent(listItem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneRoot = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameLb = new javax.swing.JLabel();
        AccountManager = new javax.swing.JPanel();
        lbAccount = new javax.swing.JLabel();
        StaticChart = new javax.swing.JPanel();
        lbStatic = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        AdminProfile = new javax.swing.JPanel();
        lbAdminProfile = new javax.swing.JLabel();
        changePwBtn = new javax.swing.JButton();
        panelView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Account Manager");
        setLocation(new java.awt.Point(350, 150));

        panelMenu.setBackground(new java.awt.Color(102, 102, 102));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("UTM Androgyne", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ACCOUNT  MANAGEMENT");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 315, -1));

        usernameLb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usernameLb.setText(admin.getUsername());
        jPanel3.add(usernameLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelMenu.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 110));

        AccountManager.setBackground(new java.awt.Color(0, 153, 0));

        lbAccount.setFont(new java.awt.Font("UTM Androgyne", 1, 18)); // NOI18N
        lbAccount.setForeground(new java.awt.Color(255, 255, 255));
        lbAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAccount.setText("Account Management");
        lbAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbAccount.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lbAccount.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout AccountManagerLayout = new javax.swing.GroupLayout(AccountManager);
        AccountManager.setLayout(AccountManagerLayout);
        AccountManagerLayout.setHorizontalGroup(
            AccountManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );
        AccountManagerLayout.setVerticalGroup(
            AccountManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAccount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        panelMenu.add(AccountManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 315, -1));

        StaticChart.setBackground(new java.awt.Color(0, 153, 0));

        lbStatic.setFont(new java.awt.Font("UTM Androgyne", 1, 18)); // NOI18N
        lbStatic.setForeground(new java.awt.Color(255, 255, 255));
        lbStatic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatic.setText("Statistical chart");
        lbStatic.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout StaticChartLayout = new javax.swing.GroupLayout(StaticChart);
        StaticChart.setLayout(StaticChartLayout);
        StaticChartLayout.setHorizontalGroup(
            StaticChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatic, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );
        StaticChartLayout.setVerticalGroup(
            StaticChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        panelMenu.add(StaticChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 315, -1));

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        panelMenu.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Carrot team @2021");
        panelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 680, -1, -1));

        AdminProfile.setBackground(new java.awt.Color(0, 153, 0));
        AdminProfile.setPreferredSize(new java.awt.Dimension(315, 112));

        lbAdminProfile.setFont(new java.awt.Font("UTM Androgyne", 1, 18)); // NOI18N
        lbAdminProfile.setForeground(new java.awt.Color(255, 255, 255));
        lbAdminProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAdminProfile.setText("Admin profile");
        lbAdminProfile.setPreferredSize(new java.awt.Dimension(134, 24));

        javax.swing.GroupLayout AdminProfileLayout = new javax.swing.GroupLayout(AdminProfile);
        AdminProfile.setLayout(AdminProfileLayout);
        AdminProfileLayout.setHorizontalGroup(
            AdminProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAdminProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        );
        AdminProfileLayout.setVerticalGroup(
            AdminProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbAdminProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
        );

        panelMenu.add(AdminProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 315, -1));

        changePwBtn.setText("Change password");
        changePwBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePwBtnActionPerformed(evt);
            }
        });
        panelMenu.add(changePwBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 650, -1, -1));

        panelView.setBackground(new java.awt.Color(204, 204, 204));
        panelView.setPreferredSize(new java.awt.Dimension(950, 700));

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paneRootLayout = new javax.swing.GroupLayout(paneRoot);
        paneRoot.setLayout(paneRootLayout);
        paneRootLayout.setHorizontalGroup(
            paneRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneRootLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneRootLayout.setVerticalGroup(
            paneRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        int output = JOptionPane.showConfirmDialog(logoutButton, "Do you want to log out", "Sign out", JOptionPane.YES_NO_OPTION);
        if (output == 0) {
            new guiMain().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void changePwBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePwBtnActionPerformed
        javax.swing.JPasswordField field0 = new javax.swing.JPasswordField();
        field0.setEchoChar('\u2022');
        javax.swing.JPasswordField field1 = new javax.swing.JPasswordField();
        field1.setEchoChar('\u2022');
        javax.swing.JPasswordField field2 = new javax.swing.JPasswordField();
        field2.setEchoChar('\u2022');
        Object[] message = {"Old password:", field0, "New password:", field1, "Re-enter new pass:", field2};
        int option = JOptionPane.showConfirmDialog(rootPane, message, "Change password",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            char[] value0 = field0.getPassword();
            if (admin.check(new String(value0))) {
                char[] value1 = field1.getPassword();
                char[] value2 = field2.getPassword();
                if ((new String(value1)).equals(new String(value2)) && value1.length != 0) {
                    admin.setNewPassword(new String(value1));
                    JOptionPane.showMessageDialog(rootPane, "Change password successfully", "",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "New password does not match", "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Password incorrect", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_changePwBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(guiAccountManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiAccountManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiAccountManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiAccountManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Account a = new Account("fudio101_admin007", "Ng01637202484", "Nguyen Do The Nguyen",
                        LocalDate.of(2001, Month.JANUARY, 1), "0337202484");
                new guiAccountManager(a).setVisible(true);
            }
        });
    }

    private final Account admin;
    private final ChuyenManHinhController controller;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccountManager;
    private javax.swing.JPanel AdminProfile;
    private javax.swing.JPanel StaticChart;
    private javax.swing.JButton changePwBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbAccount;
    private javax.swing.JLabel lbAdminProfile;
    private javax.swing.JLabel lbStatic;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel paneRoot;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelView;
    private javax.swing.JLabel usernameLb;
    // End of variables declaration//GEN-END:variables
}
