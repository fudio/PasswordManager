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
import Storage.Account;
import Storage.AccountList;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

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
		lblNewLabel_5.setBounds(42, 190, 101, 24);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("S\u00F4\u0301 \u0111i\u00EA\u0323n thoa\u0323i");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(42, 236, 93, 18);
		contentPane.add(lblNewLabel_6);

		fullnameField = new JTextField();
		fullnameField.setBounds(180, 193, 171, 22);
		contentPane.add(fullnameField);
		fullnameField.setColumns(10);

		phoneField = new JTextField();
		phoneField.setBounds(180, 232, 171, 22);
		contentPane.add(phoneField);
		phoneField.setColumns(10);

		ButtonDangKy = new JButton("\u0110\u0102NG KY\u0301 ");
		ButtonDangKy.setBackground(Color.LIGHT_GRAY);
		ButtonDangKy.setForeground(Color.BLACK);
		ButtonDangKy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ButtonDangKy.setBounds(132, 319, 149, 48);
		contentPane.add(ButtonDangKy);

		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(42, 280, 103, 13);
		contentPane.add(lblNewLabel_4);

		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(180, 271, 171, 22);
		contentPane.add(dateChooser);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2001);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();
		dateChooser.setDate(date);
		dateChooser.setDateFormatString("dd/MM/YYYY");

		final JCheckBox showPassword = new JCheckBox("Hiện mật khẩu");
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
		showPassword.setBounds(238, 163, 111, 23);
		contentPane.add(showPassword);

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
