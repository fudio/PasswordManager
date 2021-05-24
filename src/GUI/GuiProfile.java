package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.border.SoftBevelBorder;

import Storage.Account;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.SystemColor;

public class GuiProfile extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3715286819052224971L;
	protected static final Component ButtonOut = null;
	private JPanel pan_1;
	private JTextField fullname;
	private JTextField birthday;
	private JTextField sex;
	private JTextField job;
	private JTextField address;
	private JTextField phone;
	private JTextField email;
	private JTextField fb_link;
	private JMenu mnNewMenu;
	private JButton PrbuttonHoso;
	private JButton PrbuttonCaidat;
	private JButton PrbuttonDX;
	private JButton PrbuttonThoat;
	private JLabel lblNewLabel_2;

	/**
	 * Creates new form JLabelLink
	 * 
	 * @param login
	 */
	public GuiProfile(Account login) {
		this.setTitle("NMT");
		this.setSize(946, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		new JPanel();

		pan_1 = new JPanel();
		pan_1.setForeground(new Color(0, 0, 0));
		pan_1.setLayout(null);
		this.setContentPane(pan_1);

		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin c\u1EE7a b\u1EA1n");
		lblNewLabel
				.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, Color.RED, Color.ORANGE, Color.CYAN, Color.YELLOW));
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

		fullname = new JTextField();
		fullname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fullname.setEditable(false);
		fullname.setText(login.getFullName());
		fullname.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51),
				new Color(102, 255, 255), new Color(255, 255, 153)));
		fullname.setBounds(10, 108, 354, 36);
		pan_1.add(fullname);
		fullname.setColumns(10);

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

		birthday = new JTextField();
		birthday.setFont(new Font("Tahoma", Font.PLAIN, 16));
		birthday.setEditable(false);
		birthday.setText(login.getBirthday());
		birthday.setColumns(10);
		birthday.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51),
				new Color(102, 255, 255), new Color(255, 255, 153)));
		birthday.setBounds(10, 190, 354, 36);
		pan_1.add(birthday);

		sex = new JTextField();
		sex.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sex.setEditable(false);
		sex.setColumns(10);
		sex.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51),
				new Color(102, 255, 255), new Color(255, 255, 153)));
		sex.setBounds(10, 273, 354, 36);
		pan_1.add(sex);

		job = new JTextField();
		job.setFont(new Font("Tahoma", Font.PLAIN, 16));
		job.setEditable(false);
		job.setColumns(10);
		job.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51),
				new Color(102, 255, 255), new Color(255, 255, 153)));
		job.setBounds(10, 354, 354, 36);
		pan_1.add(job);

		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		address.setEditable(false);
		address.setColumns(10);
		address.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51),
				new Color(102, 255, 255), new Color(255, 255, 153)));
		address.setBounds(10, 437, 354, 36);
		pan_1.add(address);

		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phone.setEditable(false);
		phone.setText(login.getPhoneNum());
		phone.setColumns(10);
		phone.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51),
				new Color(102, 255, 255), new Color(255, 255, 153)));
		phone.setBounds(399, 108, 354, 36);
		pan_1.add(phone);

		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		email.setEditable(false);
		email.setColumns(10);
		email.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51),
				new Color(102, 255, 255), new Color(255, 255, 153)));
		email.setBounds(399, 190, 354, 36);
		pan_1.add(email);

		fb_link = new JTextField();
		fb_link.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fb_link.setEditable(false);
		fb_link.setColumns(10);
		fb_link.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 0, 102), new Color(255, 51, 51),
				new Color(102, 255, 255), new Color(255, 255, 153)));
		fb_link.setBounds(399, 273, 354, 36);
		pan_1.add(fb_link);

		mnNewMenu = new JMenu("Ch\u00E0o " + login.getUsername());
		mnNewMenu.setDelay(0);
		mnNewMenu.setBounds(805, 11, 115, 26);
		pan_1.add(mnNewMenu);

		PrbuttonHoso = new JButton("Hồ sơ");
		PrbuttonHoso.setPreferredSize(new Dimension(83, 23));
		PrbuttonHoso.setMinimumSize(new Dimension(100, 23));
		PrbuttonHoso.setMaximumSize(new Dimension(100, 23));
		PrbuttonHoso.setBackground(SystemColor.controlHighlight);
		PrbuttonHoso.setActionCommand("Hồ sơ");
		mnNewMenu.add(PrbuttonHoso);

		PrbuttonCaidat = new JButton("Cài đặt");
		PrbuttonCaidat.setPreferredSize(new Dimension(83, 23));
		PrbuttonCaidat.setBackground(SystemColor.controlHighlight);
		PrbuttonCaidat.setActionCommand("Cài đặt");
		PrbuttonCaidat.setMinimumSize(new Dimension(100, 23));
		PrbuttonCaidat.setMaximumSize(new Dimension(100, 23));
		PrbuttonCaidat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnNewMenu.add(PrbuttonCaidat);

		PrbuttonDX = new JButton("\u0110\u0103ng xu\u1EA5t");
		PrbuttonDX.setBackground(SystemColor.controlHighlight);
		PrbuttonDX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(PrbuttonDX, "Bạn có muốn đăng xuất", "Logout",
						JOptionPane.YES_NO_OPTION);
				if (output == 0) {
					GuiMain frm1 = new GuiMain();
					frm1.setVisible(true);
					dispose();
				}
			}
		});
		mnNewMenu.add(PrbuttonDX);

		PrbuttonThoat = new JButton("Tho\u00E1t");
		PrbuttonThoat.setPreferredSize(new Dimension(83, 23));
		PrbuttonThoat.setBackground(SystemColor.controlHighlight);
		PrbuttonThoat.setMinimumSize(new Dimension(83, 23));
		PrbuttonThoat.setMaximumSize(new Dimension(100, 23));
		PrbuttonThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(PrbuttonThoat, "Bạn có muốn thoát", "Out",
						JOptionPane.YES_NO_OPTION);
				if (output == 0)
					dispose();
			}
		});
		mnNewMenu.add(PrbuttonThoat);

		lblNewLabel_2 = new JLabel("Carrot team - 2021");
		lblNewLabel_2.setFont(new Font("SVN-Rocker", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(682, 474, 248, 26);
		pan_1.add(lblNewLabel_2);
		this.setVisible(true);

	}

	public static void main(String args[]) {
		/*
		 * Create and display the form
		 */
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Account a = new Account("fudio", "Ng01637202484", "Nguyễn Đỗ Thế Nguyên",
						LocalDate.of(2001, Month.JANUARY, 1), "0337202484");
				new GuiProfile(a).setVisible(true);
			}
		});
	}

}