package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiRegier1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6470489315656149557L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton DKbuttonDK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRegier1 frame = new GuiRegier1();
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
	public GuiRegier1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0110\u0102NG KY\u0301");
		lblNewLabel.setBounds(156, 10, 111, 40);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn \u0111\u0103ng nh\u00E2\u0323p");
		lblNewLabel_1.setBounds(42, 56, 101, 27);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("M\u00E2\u0323t kh\u00E2\u0309u");
		lblNewLabel_2.setBounds(42, 93, 101, 27);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nh\u00E2\u0323p la\u0323i m\u00E2\u0323t kh\u00E2\u0309u");
		lblNewLabel_3.setBounds(40, 138, 120, 13);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(
				"\u0110\u00EA\u0309 n\u00E2ng cao ti\u0301nh ba\u0309o m\u00E2\u0323t ha\u0303y tra\u0309 l\u01A1\u0300i c\u00E2u ho\u0309i");
		lblNewLabel_4.setBounds(69, 177, 280, 18);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setBounds(178, 60, 171, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(178, 97, 171, 22);
		contentPane.add(passwordField);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(178, 135, 171, 22);
		contentPane.add(passwordField_2);

		lblNewLabel_5 = new JLabel("Ho\u0323 t\u00EAn cha ho\u0103\u0323c me\u0323 ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(42, 205, 149, 24);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("S\u00F4\u0301 \u0111i\u00EA\u0323n thoa\u0323i");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(42, 278, 93, 18);
		contentPane.add(lblNewLabel_6);

		textField_1 = new JTextField();
		textField_1.setBounds(42, 239, 225, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(42, 306, 225, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		DKbuttonDK = new JButton("\u0110\u0102NG KY\u0301 ");
		DKbuttonDK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(DKbuttonDK, "Đăng ký thành công", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				GuiMain frm1 = new GuiMain();
				frm1.setVisible(true);
				dispose();
			}
		});
		DKbuttonDK.setBackground(new Color(240, 240, 240));
		DKbuttonDK.setForeground(Color.BLACK);
		DKbuttonDK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DKbuttonDK.setBounds(132, 358, 149, 48);
		contentPane.add(DKbuttonDK);
	}

}