/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiNetbean;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class guiMain extends javax.swing.JFrame {

    /**
     * Creates new form guiLogin
     */
    public guiMain() {
        initComponents();
    }

    private void goWebsite1(JLabel website) {
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/fudio/PasswordManager"));
                } catch (URISyntaxException | IOException ex) {
                    // It looks like there's a problem
                }
            }
        });
    }

    private void goWebsite2(JLabel website) {
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/1.fudio"));
                } catch (URISyntaxException | IOException ex) {
                    // It looks like there's a problem
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRoot = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Link2 = new javax.swing.JLabel();
        Link1 = new javax.swing.JLabel();
        Link3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        login2 = new javax.swing.JToggleButton();
        View = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wellcome");
        setLocation(new java.awt.Point(650, 250));
        setSize(new java.awt.Dimension(650, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRoot.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelRoot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setText("WELLCOM TO");
        panelRoot.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 310, 60));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 0));
        jLabel3.setText("CARROT");
        panelRoot.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 190, -1));

        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Carrot team - 2021 @");
        panelRoot.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, -1, -1));

        Link2.setBackground(new java.awt.Color(255, 255, 255));
        Link2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Link2.setForeground(new java.awt.Color(255, 153, 51));
        Link2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Link2.setText("Our project");
        Link2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        Link2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Link2AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        panelRoot.add(Link2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 200, 60));

        Link1.setBackground(new java.awt.Color(255, 255, 255));
        Link1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Link1.setForeground(new java.awt.Color(255, 153, 51));
        Link1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Link1.setText("Contact us");
        Link1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        Link1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Link1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        panelRoot.add(Link1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 200, 60));

        Link3.setBackground(new java.awt.Color(255, 255, 255));
        Link3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Link3.setForeground(new java.awt.Color(255, 153, 51));
        Link3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Link3.setText("Another");
        Link3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        Link3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Link3AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        panelRoot.add(Link3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 200, 60));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("*________________________________*");
        panelRoot.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 220, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("*________________________________*");
        panelRoot.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 230, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*________________________________*");
        panelRoot.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 230, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GuiNetbean/Pic/Untitled-1.png"))); // NOI18N
        panelRoot.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, 220));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("We protect your account with the Bcrypt hash algorithm");
        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelRoot.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 290, 20));

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Bcrypt is a password encryption function designed by Niels Provos and David Mazi�res");
        jTextField2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelRoot.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 430, 20));

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("Bcrypt is a cross-platform file encryption utility");
        jTextField3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelRoot.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 230, 20));

        jTextField4.setText("BCrypt is rated as more secure and secure than MD5 and SHA");
        jTextField4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelRoot.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, 20));

        login2.setText("Join us now");
        login2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)));
        login2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login2ActionPerformed(evt);
            }
        });
        panelRoot.add(login2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 70, -1));

        View.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GuiNetbean/Pic/4882066.jpg"))); // NOI18N
        panelRoot.add(View, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 500));

        getContentPane().add(panelRoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 500));

        jMenu2.setText("Account");

        jMenuItem3.setText("Login");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem1.setText("Sign up");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem4.setText("Exit");
        jMenu2.add(jMenuItem4);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        guiLogin d1 = new guiLogin();
        d1.setVisible(true);
        dispose();

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        guiRegister d2 = new guiRegister();
        d2.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void Link2AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Link2AncestorAdded
        goWebsite1(Link2);
    }//GEN-LAST:event_Link2AncestorAdded

    private void Link1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Link1AncestorAdded
        goWebsite2(Link1);
    }//GEN-LAST:event_Link1AncestorAdded

    private void Link3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Link3AncestorAdded

    }//GEN-LAST:event_Link3AncestorAdded

    private void login2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login2ActionPerformed
        guiLogin df2 = new guiLogin();
        df2.setVisible(true);
        dispose();
    }//GEN-LAST:event_login2ActionPerformed

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
            java.util.logging.Logger.getLogger(guiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guiMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guiMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Link1;
    private javax.swing.JLabel Link2;
    private javax.swing.JLabel Link3;
    private javax.swing.JLabel View;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToggleButton login2;
    private javax.swing.JPanel panelRoot;
    // End of variables declaration//GEN-END:variables
}
