package End;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

 
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
 
public class E1 extends JFrame {
    private JPanel pan;
    private JPanel pan_1;
        private JLabel website;
        private JLabel contact_1;
        private JLabel website_1;
        private JLabel lblNewLabel;
        private JMenu MenuFirst;
        private JButton btnNewButton;
        private JButton btnNewButton_1;
    /**
     * Creates new form JLabelLink
     */
    public E1() {
        this.setTitle("NMT");
        this.setSize(801, 541);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
 
        pan = new JPanel();
        contact_1 = new JLabel();
        contact_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
        contact_1.setHorizontalTextPosition(SwingConstants.CENTER);
        contact_1.setHorizontalAlignment(SwingConstants.CENTER);
        contact_1.setBounds(35, 334, 207, 73);
        contact_1.setFont(new Font("UTM Conestoga", Font.PLAIN, 23));
        
        pan_1 = new JPanel();
        pan_1.setForeground(new Color(0, 0, 0));
        website_1 = new JLabel();
        website_1.setHorizontalAlignment(SwingConstants.CENTER);
        website_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
        website_1.setHorizontalTextPosition(SwingConstants.CENTER);
        website_1.setForeground(new Color(0, 0, 0));
        website_1.setFont(new Font("UTM Conestoga", Font.PLAIN, 23));
        website_1.setBounds(35, 126, 207, 73);
        
        website = new JLabel();
        website.setBorder(UIManager.getBorder("DesktopIcon.border"));
        website.setHorizontalTextPosition(SwingConstants.CENTER);
        website.setHorizontalAlignment(SwingConstants.CENTER);
        website.setBounds(35, 233, 207, 73);
        website.setFont(new Font("UTM Conestoga", Font.PLAIN, 26));
 
        contact_1.setText("<html> <a href=\"\">ATHOR</a></html>");
        contact_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        website_1.setText("<html> <a href=\"\">COURESE</a></html>");
        website_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        website.setText("<html> <a href=\"\">SV.UT</a></html>");
        website.setCursor(new Cursor(Cursor.HAND_CURSOR));
    pan_1.setLayout(null);
 
    pan_1.add(contact_1);
    pan_1.add(website_1);
    pan_1.add(website);
        this.setContentPane(pan_1);
        this.setVisible(true);
        sendMail(contact_1);
        goWebsite(website);
        goWebsite_1(website_1);
        
        lblNewLabel = new JLabel("CARROT");
        lblNewLabel.setFont(new Font("UTM Americana EB", Font.PLAIN, 55));
        lblNewLabel.setBounds(35, 11, 290, 90);
        pan_1.add(lblNewLabel);
        
        MenuFirst = new JMenu("T\u00E0i kho\u1EA3n");
        MenuFirst.setDelay(0);
        MenuFirst.setBounds(660, 11, 115, 26);
        pan_1.add(MenuFirst);
        
        btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
        MenuFirst.add(btnNewButton);
        
        btnNewButton_1 = new JButton("\u0110\u0103ng k\u00FD");
        MenuFirst.add(btnNewButton_1);
        
    }
 
    public static void main(String args[]) {
        /*
         * Create and display the form
         */
        EventQueue.invokeLater(new Runnable() {
 
            @Override
            public void run() {
                new E1().setVisible(true);
            }
        });
    }
 
    private void goWebsite(JLabel website) {
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://sv.ut.edu.vn"));
                } catch (URISyntaxException | IOException ex) {
                    //It looks like there's a problem
                }
            }
        });
    }
    
    private void goWebsite_1(JLabel website) {
        website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://courses.ut.edu.vn/"));
                } catch (URISyntaxException | IOException ex) {
                    //It looks like there's a problem
                }
            }
        });
    }
    
    private void sendMail(JLabel contact) {
        contact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.facebook.com/Thach.Huynh.ZoneNop/"));
                } catch (URISyntaxException | IOException ex) {
                    //It looks like there's a problem
                }
            }
        });
    }
}