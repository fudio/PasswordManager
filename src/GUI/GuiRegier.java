package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import Storage.Account;
import Storage.AccountList;

import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.SwingConstants;

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
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;

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
		setTitle("REGIER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 602);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2001);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();

		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(167, 39, 480, 484);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(20, 27, 440, 434);
		panel.add(panel_1);
		panel_1.setLayout(null);

		ButtonDangKy = new JButton("\u0110\u0102NG KY\u0301 ");
		ButtonDangKy.setBorder(UIManager.getBorder("CheckBox.border"));
		ButtonDangKy.setBounds(143, 341, 149, 48);
		ButtonDangKy.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_1.add(ButtonDangKy);
		ButtonDangKy.setBackground(new Color(240, 255, 255));
		ButtonDangKy.setForeground(Color.BLACK);
		ButtonDangKy.setFont(new Font("UTM Penumbra", Font.PLAIN, 20));

		JLabel lblNewLabel = new JLabel("\u0110\u0102NG KY\u0301");
		lblNewLabel.setBounds(143, 11, 149, 59);
		panel_1.add(lblNewLabel);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("UTM Ericsson Capital", Font.BOLD, 30));

		btnNewButton = new JButton("Đã có tài khoản? Đăng nhập.");
		btnNewButton.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 12));
		btnNewButton.setBounds(229, 400, 201, 23);
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiLogin frm1 = new GuiLogin();
				frm1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn \u0111\u0103ng nh\u00E2\u0323p");
		lblNewLabel_1.setBounds(68, 81, 101, 27);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));

		usernameField = new JTextField();
		usernameField.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 12));
		usernameField.setBounds(204, 85, 171, 22);
		panel_1.add(usernameField);
		usernameField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 12));
		passwordField.setBounds(204, 122, 171, 22);
		panel_1.add(passwordField);

		JLabel lblNewLabel_2 = new JLabel("M\u00E2\u0323t kh\u00E2\u0309u");
		lblNewLabel_2.setBounds(68, 118, 101, 27);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));

		JLabel lblNewLabel_3 = new JLabel("Nh\u00E2\u0323p la\u0323i m\u00E2\u0323t kh\u00E2\u0309u");
		lblNewLabel_3.setBounds(66, 163, 120, 19);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));

		passwordField_2 = new JPasswordField();
		passwordField_2.setEchoChar('*');
		passwordField_2.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 12));
		passwordField_2.setBounds(204, 160, 171, 22);
		panel_1.add(passwordField_2);

		lblNewLabel_5 = new JLabel("Ho\u0323 t\u00EAn ");
		lblNewLabel_5.setBounds(68, 215, 101, 24);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));

		lblNewLabel_6 = new JLabel("S\u00F4\u0301 \u0111i\u00EA\u0323n thoa\u0323i");
		lblNewLabel_6.setBounds(68, 250, 93, 29);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));

		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh ");
		lblNewLabel_4.setBounds(68, 290, 103, 28);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 13));

		fullnameField = new JTextField();
		fullnameField.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 12));
		fullnameField.setBounds(206, 218, 171, 22);
		panel_1.add(fullnameField);
		fullnameField.setColumns(10);

		phoneField = new JTextField();
		phoneField.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 12));
		phoneField.setBounds(206, 257, 171, 22);
		panel_1.add(phoneField);
		phoneField.setColumns(10);

		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(206, 296, 171, 22);
		panel_1.add(dateChooser);
		dateChooser.setDate(date);
		dateChooser.setDateFormatString("dd/MM/YYYY");

		final JCheckBox showPassword = new JCheckBox("Hiện mật khẩu");
		showPassword.setFont(new Font("SVN-Trebuchets", Font.PLAIN, 12));
		showPassword.setBounds(264, 188, 111, 23);
		panel_1.add(showPassword);
		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showPassword.isSelected()) {
					passwordField.setEchoChar((char) 0);
					passwordField_2.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('•');
					passwordField_2.setEchoChar('•');
				}
			}
		});

		ButtonDangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				char[] password = passwordField.getPassword();
				char[] password_2 = passwordField_2.getPassword();
				String name = fullnameField.getText();
				String phoneNum = phoneField.getText();
				Date birtday = dateChooser.getCalendar().getTime();
				if (username.equals("") || (new String(password)).equals("") || (new String(password_2)).equals("")
						|| name.equals("") || phoneNum.equals(""))
					JOptionPane.showMessageDialog(ButtonDangKy, "Vui lòng nhập đầy đủ thông tin", "NullError",
							JOptionPane.WARNING_MESSAGE);
				else if (!isValidUsername(username))
					JOptionPane.showMessageDialog(ButtonDangKy,
							"Tên đăng nhập phải từ 5 đến 20 ký tự, có thể chứa chữ thường, chữ hoa số và một số ký tự đặc biệt (._=)",
							"InvalidUsernameError", JOptionPane.WARNING_MESSAGE);
				else if (!isValidPassword(password))
					JOptionPane.showMessageDialog(ButtonDangKy,
							"Mật khẩu phải có từ 8 đến 30 ký tự, ít nhất một ký tự hoa, một ký tự thường, một số và một ký tự đặc biệt (@$!%*?&)",
							"InvalidPasswordError", JOptionPane.WARNING_MESSAGE);
				else if (!(new String(password)).equals(new String(password_2)))
					JOptionPane.showMessageDialog(ButtonDangKy, "Mât khẩu không khớp", "PasswordNotMatchError",
							JOptionPane.WARNING_MESSAGE);
				else if (!isValidPhone(phoneNum))
					JOptionPane.showMessageDialog(ButtonDangKy,
							"Số điện thoại bạn nhập không phải của nhà mạng Việt Nam", "InvalidPhoneNumberError",
							JOptionPane.WARNING_MESSAGE);
				else {
					AccountList list = new AccountList();
					if (!list.addAccount(new Account(username, new String(password), name,
							convertToLocalDateViaMilisecond(birtday), phoneNum)))
						JOptionPane.showMessageDialog(ButtonDangKy, "Tên đăng nhập đã được sử dụng",
								"InvalidUsernameError", JOptionPane.WARNING_MESSAGE);
					else {
						JOptionPane.showMessageDialog(ButtonDangKy, "Đăng ký thành công", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						GuiMain frm1 = new GuiMain();
						frm1.setVisible(true);
						dispose();
					}
				}
			}

			private boolean isValidPhone(String phoneNum) {
				String regex = "(84[3|5|7|8|9]|0[3|5|7|8|9])+([0-9]{8})";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(phoneNum);
				return m.matches();
			}
		});
	}

	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static boolean isValidUsername(String name) {
		String regex = "^[a-zA-Z0-9._-]{5,20}$";
//		^ asserts position at start of a line
//		Match a single character present in the list below [a-zA-Z0-9._-]
//			{5,20} matches the previous token between 5 and 20 times, as many times as possible, giving back as needed (greedy)
//			a-z matches a single character in the range between a (index 97) and z (index 122) (case sensitive)
//			A-Z matches a single character in the range between A (index 65) and Z (index 90) (case sensitive)
//			0-9 matches a single character in the range between 0 (index 48) and 9 (index 57) (case sensitive)
//			._- matches a single character in the list ._- (case sensitive)
//		$ asserts position at the end of a line
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		return m.matches();
	}

	public static boolean isValidPassword(char[] password) {
		String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,30}$";
//		^ asserts position at start of a line
		// Positive Lookahead (?=.[a-z])
		// Assert that the Regex below matches
		// . matches any character (except for line terminators)
		// * matches the previous token between zero and unlimited times, as many times
		// as possible, giving back as needed (greedy)
		// Match a single character present in the list below [a-z]
		// a-z matches a single character in the range between a (index 97) and z (index
		// 122) (case sensitive)
		// Positive Lookahead (?=.[A-Z])
		// Assert that the Regex below matches
		// . matches any character (except for line terminators)
		// * matches the previous token between zero and unlimited times, as many times
		// as possible, giving back as needed (greedy)
		// Match a single character present in the list below [A-Z]
		// A-Z matches a single character in the range between A (index 65) and Z (index
		// 90) (case sensitive)
		// Positive Lookahead (?=.\d)
		// Assert that the Regex below matches
		// . matches any character (except for line terminators)
		// * matches the previous token between zero and unlimited times, as many times
		// as possible, giving back as needed (greedy)
		// \d matches a digit (equivalent to [0-9])
		// Positive Lookahead (?=.[@$!%*?&])
		// Assert that the Regex below matches
		// . matches any character (except for line terminators)
		// * matches the previous token between zero and unlimited times, as many times
		// as possible, giving back as needed (greedy)
		// Match a single character present in the list below [@$!%*?&]
		// @$!%*?& matches a single character in the list @$!%*?& (case sensitive)
		// Match a single character present in the list below [A-Za-z\d@$!%*?&]
		// {8,30} matches the previous token between 8 and 30 times, as many times as
		// possible, giving back as needed (greedy)
		// A-Z matches a single character in the range between A (index 65) and Z (index
		// 90) (case sensitive)
		// a-z matches a single character in the range between a (index 97) and z (index
		// 122) (case sensitive)
		// \d matches a digit (equivalent to [0-9])
		// @$!%*?& matches a single character in the list @$!%*?& (case sensitive)
//		$ asserts position at the end of a line
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(new String(password));
		return m.matches();
	}
}
