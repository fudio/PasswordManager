package End;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Part2.P1;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;

public class E2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					E2 frame = new E2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public E2() {
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1081, 578);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(50, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(925, 497, -229, -140);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CARROT  - 2021");
		lblNewLabel_1.setBounds(925, 497, 128, 37);
		contentPane.add(lblNewLabel_1);
		
		JMenu Menu1 = new JMenu("Ch\u00E0o");
		Menu1.setHorizontalTextPosition(SwingConstants.CENTER);
		Menu1.setHorizontalAlignment(SwingConstants.CENTER);
		Menu1.setDelay(0);
		Menu1.setBounds(953, 11, 100, 46);
		contentPane.add(Menu1);
		
		JButton ButtonProfile = new JButton("H\u1ED3 s\u01A1");
		ButtonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ButtonProfile, "This is a modal MessageBox", "About", 
                        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Menu1.add(ButtonProfile);
		
		JButton ButtonSetting = new JButton("C\u00E0i \u0111\u1EB7t");
		Menu1.add(ButtonSetting);
		
		JButton ButtonOut = new JButton("Tho\u00E1t");
		ButtonOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
			            ButtonOut, 
			            "Are you sure you want to quit?", 
			            "Alert", 
			            JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION)
			    System.exit(0);
			}
			
		});
		
		JButton ButtonLogout = new JButton("\u0110\u0103ng xu\u1EA5t");
		ButtonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(
			            ButtonOut, 
			            "Are you sure you want to quit?", 
			            "Alert", 
			            JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION) {
			    E1 frm1 = new E1();
				frm1.setVisible(true);
				dispose();
				}
			}

/*				E1 frm1 = new E1();
				frm1.setVisible(true);
				dispose();
*/				
		});
		Menu1.add(ButtonLogout);
		Menu1.add(ButtonOut);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblNewLabel_2.setSize(new Dimension(50, 50));
		lblNewLabel_2.setBounds(29, 92, 55, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_3.setSize(new Dimension(50, 50));
		lblNewLabel_3.setBounds(29, 133, 55, 30);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_3_1.setSize(new Dimension(50, 50));
		lblNewLabel_3_1.setBounds(29, 174, 55, 30);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Email");
		lblNewLabel_3_2.setSize(new Dimension(50, 50));
		lblNewLabel_3_2.setBounds(29, 212, 44, 30);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("N\u01A1i \u1EDF");
		lblNewLabel_3_3.setSize(new Dimension(50, 50));
		lblNewLabel_3_3.setBounds(29, 297, 44, 30);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("S\u0110T");
		lblNewLabel_3_4.setSize(new Dimension(50, 50));
		lblNewLabel_3_4.setBounds(29, 242, 33, 30);
		contentPane.add(lblNewLabel_3_4);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
