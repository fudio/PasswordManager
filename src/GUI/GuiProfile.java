package GUI;

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
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
 
public class GuiProfile extends JFrame {
    protected static final Component ButtonOut = null;
	private JPanel pan;
    private JPanel pan_1;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JMenu mnNewMenu;
    private JButton PrbuttonHoso;
    private JButton PrbuttonCaidat;
    private JButton PrbuttonDX;
    private JButton PrbuttonThoat;
    private JLabel lblNewLabel_2;
    private JButton btnNewButton;
    /**
     * Creates new form JLabelLink
     */
    public GuiProfile() {
        this.setTitle("NMT");
        this.setSize(946, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
 
        pan = new JPanel();
        
        pan_1 = new JPanel();
        pan_1.setForeground(new Color(0, 0, 0));
    pan_1.setLayout(null);
        this.setContentPane(pan_1);
        
        JLabel lblNewLabel = new JLabel("Th\u00F4ng tin c\u1EE7a b\u1EA1n");
        lblNewLabel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.RED, Color.ORANGE, Color.CYAN, Color.YELLOW));
        lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("SVN-The Voice Heavy", Font.PLAIN, 25));
        lblNewLabel.setBounds(10, 11, 354, 51);
        pan_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
        lblNewLabel_1.setFont(new Font("SVN-Sofia", Font.PLAIN, 20));
        lblNewLabel_1.setBorder(null);
        lblNewLabel_1.setBounds(10, 73, 150, 36);
        pan_1.add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51), new Color(102, 255, 255), new Color(255, 255, 153)));
        textField.setBounds(10, 108, 354, 36);
        pan_1.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1_1 = new JLabel("Ng\u00E0y sinh");
        lblNewLabel_1_1.setFont(new Font("SVN-Sofia", Font.PLAIN, 20));
        lblNewLabel_1_1.setBorder(null);
        lblNewLabel_1_1.setBounds(10, 155, 150, 36);
        pan_1.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("Gi\u1EDBi t\u00EDnh");
        lblNewLabel_1_2.setFont(new Font("SVN-Sofia", Font.PLAIN, 20));
        lblNewLabel_1_2.setBorder(null);
        lblNewLabel_1_2.setBounds(10, 237, 150, 36);
        pan_1.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_3 = new JLabel("C\u00F4ng vi\u1EC7c");
        lblNewLabel_1_3.setFont(new Font("SVN-Sofia", Font.PLAIN, 20));
        lblNewLabel_1_3.setBorder(null);
        lblNewLabel_1_3.setBounds(10, 319, 150, 36);
        pan_1.add(lblNewLabel_1_3);
        
        JLabel lblNewLabel_1_4 = new JLabel("\u0110\u1ECBa ch\u1EC9");
        lblNewLabel_1_4.setFont(new Font("SVN-Sofia", Font.PLAIN, 20));
        lblNewLabel_1_4.setBorder(null);
        lblNewLabel_1_4.setBounds(10, 401, 150, 36);
        pan_1.add(lblNewLabel_1_4);
        
        JLabel lblNewLabel_1_5 = new JLabel("S\u0110T");
        lblNewLabel_1_5.setFont(new Font("SVN-Sofia", Font.PLAIN, 20));
        lblNewLabel_1_5.setBorder(null);
        lblNewLabel_1_5.setBounds(399, 73, 150, 36);
        pan_1.add(lblNewLabel_1_5);
        
        JLabel lblNewLabel_1_6 = new JLabel("Email");
        lblNewLabel_1_6.setFont(new Font("SVN-Sofia", Font.PLAIN, 20));
        lblNewLabel_1_6.setBorder(null);
        lblNewLabel_1_6.setBounds(399, 155, 150, 36);
        pan_1.add(lblNewLabel_1_6);
        
        JLabel lblNewLabel_1_7 = new JLabel("FB");
        lblNewLabel_1_7.setFont(new Font("SVN-Sofia", Font.PLAIN, 20));
        lblNewLabel_1_7.setBorder(null);
        lblNewLabel_1_7.setBounds(399, 237, 150, 36);
        pan_1.add(lblNewLabel_1_7);
        
        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51), new Color(102, 255, 255), new Color(255, 255, 153)));
        textField_1.setBounds(10, 190, 354, 36);
        pan_1.add(textField_1);
        
        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        textField_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51), new Color(102, 255, 255), new Color(255, 255, 153)));
        textField_2.setBounds(10, 273, 354, 36);
        pan_1.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        textField_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51), new Color(102, 255, 255), new Color(255, 255, 153)));
        textField_3.setBounds(10, 354, 354, 36);
        pan_1.add(textField_3);
        
        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        textField_4.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51), new Color(102, 255, 255), new Color(255, 255, 153)));
        textField_4.setBounds(10, 437, 354, 36);
        pan_1.add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setEditable(false);
        textField_5.setColumns(10);
        textField_5.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51), new Color(102, 255, 255), new Color(255, 255, 153)));
        textField_5.setBounds(399, 108, 354, 36);
        pan_1.add(textField_5);
        
        textField_6 = new JTextField();
        textField_6.setEditable(false);
        textField_6.setColumns(10);
        textField_6.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51), new Color(102, 255, 255), new Color(255, 255, 153)));
        textField_6.setBounds(399, 190, 354, 36);
        pan_1.add(textField_6);
        
        textField_7 = new JTextField();
        textField_7.setEditable(false);
        textField_7.setColumns(10);
        textField_7.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51), new Color(102, 255, 255), new Color(255, 255, 153)));
        textField_7.setBounds(399, 273, 354, 36);
        pan_1.add(textField_7);
        
        mnNewMenu = new JMenu("Ch\u00E0o *t\u00EAn*");
        mnNewMenu.setDelay(0);
        mnNewMenu.setBounds(805, 11, 115, 26);
        pan_1.add(mnNewMenu);
        
        PrbuttonHoso = new JButton("H\u1ED3 s\u01A1");
        mnNewMenu.add(PrbuttonHoso);
        
        PrbuttonCaidat = new JButton("C\u00E0i \u0111\u1EB7t");
        mnNewMenu.add(PrbuttonCaidat);
        
        PrbuttonDX = new JButton("\u0110\u0103ng xu\u1EA5t");
        PrbuttonDX.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 int output = JOptionPane.showConfirmDialog(PrbuttonDX, 
                         "Bạn có muốn đăng xuât", "Logout",
                         JOptionPane.YES_NO_OPTION);
				GuiMain frm1 = new GuiMain();
				frm1.setVisible(true);
				dispose();
        	}
        });
        mnNewMenu.add(PrbuttonDX);
        
        PrbuttonThoat = new JButton("Tho\u00E1t");
        PrbuttonThoat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 int output = JOptionPane.showConfirmDialog(PrbuttonThoat, 
                         "Bạn có muốn thoát", "Out",
                         JOptionPane.YES_NO_OPTION);
				dispose();
        	}
        });
        mnNewMenu.add(PrbuttonThoat);
        
        lblNewLabel_2 = new JLabel("Carrot team - 2021");
        lblNewLabel_2.setFont(new Font("SVN-Rocker", Font.PLAIN, 16));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setBounds(682, 474, 248, 26);
        pan_1.add(lblNewLabel_2);
        
        btnNewButton = new JButton("New button");
        btnNewButton.setBounds(432, 330, 89, 43);
        pan_1.add(btnNewButton);
        this.setVisible(true);
        
    }
 
    public static void main(String args[]) {
        /*
         * Create and display the form
         */
        EventQueue.invokeLater(new Runnable() {
 
            @Override
            public void run() {
                new GuiProfile().setVisible(true);
            }
        });
    }
 
    private void goWebsite(JLabel website) {
    }
    
    private void goWebsite_1(JLabel website) {
    }
    
    private void sendMail(JLabel contact) {
    }
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}