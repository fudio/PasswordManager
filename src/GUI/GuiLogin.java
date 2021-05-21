package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import Storage.Account;
import Storage.AccountList;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuiLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8856436166317004678L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLogin frame = new GuiLogin();
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
	public GuiLogin() {
		final AccountList list = new AccountList();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u00E2\u0323p");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBorder(new LineBorder(null, 0));
		lblNewLabel.setBounds(20, 59, 96, 43);
		contentPane.add(lblNewLabel);

		usernameField = new JTextField();

		usernameField.setBounds(126, 71, 177, 21);
		contentPane.add(usernameField);
		usernameField.setColumns(10);

		final JButton DNbuttonDN = new JButton("\u0110\u0102NG NH\u00C2\u0323P");
		DNbuttonDN.setForeground(Color.BLACK);
		DNbuttonDN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(list, DNbuttonDN, usernameField, passwordField);
			}
		});

		DNbuttonDN.setBackground(Color.LIGHT_GRAY);
		DNbuttonDN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DNbuttonDN.setBounds(136, 181, 153, 43);
		contentPane.add(DNbuttonDN);

		JLabel lblNewLabel_1 = new JLabel("\u0110\u0102NG NH\u00C2\u0323P");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setSize(new Dimension(10, 10));
		lblNewLabel_1.setMaximumSize(new Dimension(43, 17));
		lblNewLabel_1.setBounds(150, 10, 153, 37);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("M\u00E2\u0323t kh\u00E2\u0309u");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(20, 123, 84, 13);
		contentPane.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login(list, DNbuttonDN, usernameField, passwordField);
				}
			}
		});
		passwordField.setBounds(126, 120, 177, 21);
		contentPane.add(passwordField);

		JButton btnNewButton_1 = new JButton("Ba\u0323n \u0111a\u0303 qu\u00EAn m\u00E2\u0323t kh\u00E2\u0309u");
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(235, 150, 166, 21);
		contentPane.add(btnNewButton_1);
	}

	private void login(AccountList list, JButton DNbuttonDN, JTextField usernameField, JPasswordField passwordField) {
		String username = usernameField.getText();
		char[] password = passwordField.getPassword();
		if (username.equals("") || (new String(password)).equals(""))
			JOptionPane.showMessageDialog(DNbuttonDN, "Vui lòng nhập đủ Tên đăng nhập và Mật khẩu", "NullError",
					JOptionPane.INFORMATION_MESSAGE);
		else {
			Account login = list.accountSearch(username);
			if (login != null)
				if (!login.check(new String(password)))
					JOptionPane.showMessageDialog(DNbuttonDN, "Sai Tên đăng nhập hoặc Mật khẩu", "VerifycationError",
							JOptionPane.INFORMATION_MESSAGE);
				else {
					JOptionPane.showMessageDialog(DNbuttonDN, "Đăng nhập thành công", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					GuiProfile frm1 = new GuiProfile();
					frm1.setVisible(true);
					dispose();
				}
			else
				JOptionPane.showMessageDialog(DNbuttonDN, "Sai Tên đăng nhập hoặc Mật khẩu", "VerifycationError",
						JOptionPane.INFORMATION_MESSAGE);
		}
	}
}