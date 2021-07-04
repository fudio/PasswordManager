/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuiNetbean;

import Storage.Account;
import Storage.AccountList;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author theng
 */
public class AdminProfileJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminProfileJPanel
     *
     * @param admin
     */
    public AdminProfileJPanel(Account admin) {
        login = admin;
        initComponents();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, login.getBirthday_().getYear());
        cal.set(Calendar.MONTH, login.getBirthday_().getMonthValue() - 1);
        cal.set(Calendar.DAY_OF_MONTH, login.getBirthday_().getDayOfMonth());
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date date = cal.getTime();
        dateChooser.setDate(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pic = new javax.swing.JLabel();
        fullname = new javax.swing.JTextField();
        birthday = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        address = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        fblink = new javax.swing.JTextField();
        editProfileButton = new javax.swing.JButton();
        agreeButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        email = new javax.swing.JTextField();
        work = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox();
        sexTextField = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(950, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pic.setForeground(new java.awt.Color(255, 153, 0));
        pic.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Avatar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 1, 14), new java.awt.Color(255, 153, 0))); // NOI18N
        add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 230, 230));

        fullname.setText(login.getFullName());
        fullname.setEditable(false);
        fullname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 280, -1));

        birthday.setText(login.getBirthday());
        birthday.setEditable(false);
        add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 130, -1));

        dateChooser.setVisible(false);
        dateChooser.setDateFormatString("dd/MM/yyyy");
        add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 180, -1));

        address.setText(login.getAddress());
        address.setEditable(false);
        add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 270, 50));

        phone.setText(login.getPhoneNum());
        phone.setEditable(false);
        add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 270, -1));

        fblink.setText(login.getFb());
        fblink.setEditable(false);
        add(fblink, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, 190, -1));

        editProfileButton.setForeground(new java.awt.Color(255, 153, 0));
        editProfileButton.setText("Edit profile");
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });
        add(editProfileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 620, -1, -1));

        agreeButton.setForeground(new java.awt.Color(255, 153, 0));
        agreeButton.setText("Agreee");
        agreeButton.setVisible(false);
        agreeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agreeButtonActionPerformed(evt);
            }
        });
        add(agreeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 620, -1, -1));

        cancelButton.setForeground(new java.awt.Color(255, 153, 0));
        cancelButton.setText("Cancel");
        cancelButton.setVisible(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 620, -1, -1));

        fblink.setText(login.getEmail());
        email.setEditable(false);
        add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 190, -1));

        work.setText(login.getWork());
        work.setEditable(false);
        add(work, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 580, 270, 60));

        jLabel4.setFont(new java.awt.Font("UTM Ambrose", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Facebook");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 140, -1));

        jLabel5.setFont(new java.awt.Font("UTM Ambrose", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("Name");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 50, -1));

        jLabel6.setFont(new java.awt.Font("UTM Ambrose", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("Date of birth");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 120, -1));

        jLabel7.setFont(new java.awt.Font("UTM Ambrose", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("Gender");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 100, 20));

        jLabel8.setFont(new java.awt.Font("UTM Ambrose", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 0));
        jLabel8.setText("Address   _____________________");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 270, -1));

        jLabel9.setFont(new java.awt.Font("UTM Ambrose", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setText("Phone number   ________________");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 270, -1));

        jLabel11.setFont(new java.awt.Font("UTM Ambrose", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 0));
        jLabel11.setText("Work  ________________________");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, 270, -1));

        jLabel12.setFont(new java.awt.Font("UTM Ambrose", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 153, 0));
        jLabel12.setText("----------About----------");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 160, -1));

        jLabel13.setFont(new java.awt.Font("UTM Ambrose", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 153, 0));
        jLabel13.setText("Email");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 100, -1));

        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));
        gender.setToolTipText("");
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));
        gender.setVisible(false);

        sexTextField.setEditable(false);
        sexTextField.setText("jTextField1");
        add(sexTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));
        sexTextField.setText(login.getSex() ? "Male" : "Female");

        background.setBackground(new java.awt.Color(153, 153, 255));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GuiNetbean/Pic/background.jpg"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 960, 710));
    }// </editor-fold>//GEN-END:initComponents

    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButtonActionPerformed
        agreeButton.setVisible(true);
        cancelButton.setVisible(true);
        editProfileButton.setVisible(false);
        fullname.setEditable(true);
        phone.setEditable(true);
        address.setEditable(true);
        work.setEditable(true);
        fblink.setEditable(true);
        email.setEditable(true);
        gender.setEditable(true);
        birthday.setVisible(false);
        dateChooser.setVisible(true);
        gender.setVisible(true);
        sexTextField.setVisible(false);
    }//GEN-LAST:event_editProfileButtonActionPerformed

    private void agreeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agreeButtonActionPerformed
        agreeButton.setVisible(false);
        cancelButton.setVisible(false);
        editProfileButton.setVisible(true);
        fullname.setEditable(false);
        phone.setEditable(false);
        address.setEditable(false);
        work.setEditable(false);
        fblink.setEditable(false);
        email.setEditable(false);
        birthday.setVisible(true);
        dateChooser.setVisible(false);
        gender.setVisible(false);
        sexTextField.setVisible(true);
        String fullName = fullname.getText();
        String phone_ = phone.getText();
        String address_ = address.getText();
        String work_ = work.getText();
        String fblink_ = fblink.getText();
        String email_ = email.getText();
        Date birthday_ = dateChooser.getCalendar().getTime();
        if (!isValidPhone(phone_)) {
            JOptionPane.showMessageDialog(agreeButton,
                    "Not a Vietnamese phone number", "InvalidPhoneNumberError",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            if (fullName == null ? login.getFullName() != null : !fullName.equals(login.getFullName())) {
                login.setFullName(fullName);
            }
            if (birthday_ != new Date()) {
                login.setBirthday(convertToLocalDateViaMilisecond(birthday_));
            }
            if (phone_ == null ? login.getPhoneNum() != null : !phone_.equals(login.getPhoneNum())) {
                login.setPhoneNum(phone_);
            }
            if (address_ == null ? login.getAddress() != null : !address_.equals(login.getAddress())) {
                login.setAddress(address_);
            }
            if (work_ == null ? login.getWork() != null : !work_.equals(login.getWork())) {
                login.setWork(work_);
            }
            if (fblink_ == null ? login.getFb() != null : !fblink_.equals(login.getFb())) {
                login.setFblink(fblink_);
            }
            if (email_ == null ? login.getEmail() != null : !email_.equals(login.getEmail())) {
                login.setEmail(email_);
            }
            login.setSex(gender.getSelectedItem() == "Male");
            sexTextField.setText(login.getSex() ? "Male" : "Female");
            AccountList a = new AccountList();
            a.editAccount(login);
        }
    }//GEN-LAST:event_agreeButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        agreeButton.setVisible(false);
        cancelButton.setVisible(false);
        editProfileButton.setVisible(true);
        fullname.setText(login.getFullName());
        phone.setText(login.getPhoneNum());
        address.setText(login.getAddress());
        work.setText(login.getWork());
        fblink.setText(login.getFb());
        email.setText(login.getEmail());
        birthday.setVisible(true);
        dateChooser.setVisible(false);
        gender.setVisible(false);
        sexTextField.setVisible(true);
        fullname.setEditable(false);
        phone.setEditable(false);
        address.setEditable(false);
        work.setEditable(false);
        fblink.setEditable(false);
        email.setEditable(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
    }//GEN-LAST:event_genderActionPerformed

    private boolean isValidPhone(String phoneNum) {
        String regex = "(84[3|5|7|8|9]|0[3|5|7|8|9])+([0-9]{8})";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneNum);
        return m.matches();
    }

    public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    private Account login;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton agreeButton;
    private javax.swing.JLabel background;
    private javax.swing.JTextField birthday;
    private javax.swing.JButton cancelButton;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton editProfileButton;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fblink;
    private javax.swing.JTextField fullname;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel pic;
    private javax.swing.JTextField sexTextField;
    private javax.swing.JTextField work;
    // End of variables declaration//GEN-END:variables
}
