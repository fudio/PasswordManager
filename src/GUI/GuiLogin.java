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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

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
		setTitle("LOGIN");
		setName("Login");
		final AccountList list = new AccountList();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 602);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(167, 67, 480, 403);
		panel_1.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_1.setBackground(UIManager.getColor("Button.light"));

		JPanel panel = new JPanel();
		panel.setBounds(20, 27, 440, 350);
		panel.setBorder(UIManager.getBorder("InternalFrame.border"));

		final JCheckBox showPassword = new JCheckBox("Hiện mật khẩu");
		showPassword.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 11));
		showPassword.setBounds(266, 212, 141, 23);
		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showPassword.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('•');
				}
			}
		});

		final JButton DNbuttonDN = new JButton("ĐĂNG NHẬP");
		DNbuttonDN.setBorder(UIManager.getBorder("CheckBox.border"));
		DNbuttonDN.setBounds(60, 268, 315, 37);
		DNbuttonDN.setForeground(Color.BLACK);
		DNbuttonDN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(list, DNbuttonDN, usernameField, passwordField);
			}
		});

		DNbuttonDN.setBackground(new Color(240, 255, 255));
		DNbuttonDN.setFont(new Font("UTM Penumbra", Font.PLAIN, 20));
		panel.setLayout(null);
		panel.add(showPassword);
		panel.add(DNbuttonDN);
		contentPane.setLayout(null);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(panel);

		JLabel lblNewLabel_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(123, 29, 194, 43);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("UTM Ericsson Capital", Font.PLAIN, 30));
		lblNewLabel_1.setMaximumSize(new Dimension(43, 17));

		JButton forgetPassButton = new JButton("Bạn đã quên mật khẩu ?");
		forgetPassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		forgetPassButton.setBounds(41, 236, 144, 21);
		panel.add(forgetPassButton);
		forgetPassButton.setBackground(new Color(240, 240, 240));
		forgetPassButton.setBorder(null);
		forgetPassButton.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_2.setBounds(60, 103, 315, 48);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setBounds(10, 11, 86, 23);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));
		lblNewLabel.setBorder(new LineBorder(null, 0));

		usernameField = new JTextField();
		usernameField.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));
		usernameField.setBackground(SystemColor.control);
		usernameField.setBorder(null);
		usernameField.setBounds(106, 13, 177, 21);
		panel_2.add(usernameField);
		usernameField.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_3.setBounds(60, 162, 315, 43);
		panel.add(panel_3);
		panel_3.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));
		passwordField.setBackground(SystemColor.control);
		passwordField.setBorder(null);
		passwordField.setBounds(107, 11, 177, 21);
		panel_3.add(passwordField);
		passwordField.setAlignmentY(Component.TOP_ALIGNMENT);

		JLabel lblNewLabel_2 = new JLabel("Mật khẩu");
		lblNewLabel_2.setBounds(10, 14, 68, 13);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));

		JButton DNđangkyDN = new JButton("Chưa có tài khoản? Đăng ký");
		DNđangkyDN.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 12));
		DNđangkyDN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiRegier frm1 = new GuiRegier();
				frm1.setVisible(true);
				dispose();
			}
		});
		DNđangkyDN.setBorderPainted(false);
		DNđangkyDN.setBackground(SystemColor.control);
		DNđangkyDN.setBorder(UIManager.getBorder("CheckBox.border"));
		DNđangkyDN.setBounds(219, 236, 211, 23);
		panel.add(DNđangkyDN);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login(list, DNbuttonDN, usernameField, passwordField);
				}
			}
		});
	}

	private void login(AccountList list, JButton DNbuttonDN, JTextField usernameField, JPasswordField passwordField) {
		String username = usernameField.getText();
		char[] password = passwordField.getPassword();
		if (username.equals("") || (new String(password)).equals(""))
			JOptionPane.showMessageDialog(DNbuttonDN, "Vui lòng nhập đủ Tên đăng nhập và Mật khẩu", "NullError",
					JOptionPane.WARNING_MESSAGE);
		else {
			Account login = list.accountSearch(username);
			if (login != null)
				if (!login.check(new String(password)))
					JOptionPane.showMessageDialog(DNbuttonDN, "Sai Tên đăng nhập hoặc Mật khẩu", "VerifycationError",
							JOptionPane.WARNING_MESSAGE);
				else {
					JOptionPane.showMessageDialog(DNbuttonDN, "Đăng nhập thành công", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					GuiProfile frm1 = new GuiProfile(login);
					frm1.setVisible(true);
					dispose();
				}
			else
				JOptionPane.showMessageDialog(DNbuttonDN, "Sai Tên đăng nhập hoặc Mật khẩu", "VerifycationError",
						JOptionPane.WARNING_MESSAGE);
		}
	}
}