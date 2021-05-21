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
import com.toedter.calendar.JDateChooser;

import Storage.AccountList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiRegier extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField fullnameField;
	private JTextField phoneField;
	private JButton ButtonDangKy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiRegier frame = new GuiRegier();
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
	public GuiRegier() {
		AccountList list = new AccountList();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0110\u0102NG KY\u0301");
		lblNewLabel.setBounds(170, 10, 111, 40);
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

		usernameField = new JTextField();
		usernameField.setBounds(178, 60, 171, 22);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(178, 97, 171, 22);
		contentPane.add(passwordField);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(178, 135, 171, 22);
		contentPane.add(passwordField_2);

		lblNewLabel_5 = new JLabel("Ho\u0323 t\u00EAn ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(40, 172, 101, 24);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("S\u00F4\u0301 \u0111i\u00EA\u0323n thoa\u0323i");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(40, 218, 93, 18);
		contentPane.add(lblNewLabel_6);

		fullnameField = new JTextField();
		fullnameField.setBounds(178, 175, 171, 22);
		contentPane.add(fullnameField);
		fullnameField.setColumns(10);

		phoneField = new JTextField();
		phoneField.setBounds(178, 214, 171, 22);
		contentPane.add(phoneField);
		phoneField.setColumns(10);

		ButtonDangKy = new JButton("\u0110\u0102NG KY\u0301 ");
		ButtonDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ButtonDangKy, "Đăng ký thành công", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				GuiMain frm1 = new GuiMain();
				frm1.setVisible(true);
				dispose();
			}
		});
		ButtonDangKy.setBackground(Color.LIGHT_GRAY);
		ButtonDangKy.setForeground(Color.BLACK);
		ButtonDangKy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ButtonDangKy.setBounds(132, 319, 149, 48);
		contentPane.add(ButtonDangKy);

		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(40, 262, 103, 13);
		contentPane.add(lblNewLabel_4);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.setBounds(178, 253, 171, 22);
		contentPane.add(dateChooser);

	}
}
