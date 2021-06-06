package GUI;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Storage.Account;
import Storage.AccountList;

public class GuiAdmin {
	JFrame f;

	/**
	 * @wbp.parser.entryPoint
	 */
	public GuiAdmin(Account login) {
		if (login.getRank() != 0)
			return;
		f = new JFrame();
		f.setLocation(new Point(500, 200));
		f.setTitle("ADMIN");

		f.getContentPane().setLayout(null);

		final JTable jt = new JTable(new DefaultTableModel(new Object[] { "Tên đăng nhập", "H�? tên", "Ng�y sinh",
				"Giới tính", "Công việc", "S�?T", "Email", "Mạng xã hội" }, 0)) {
			/**
					 * 
					 */
					private static final long serialVersionUID = 1855268773107793891L;

			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		jt.setBounds(30, 40, 200, 300);

		JScrollPane sp = new JScrollPane(jt);
		sp.setBounds(0, 166, 849, 317);
		f.getContentPane().add(sp);

		final DefaultTableModel model = (DefaultTableModel) jt.getModel();
		AccountList a = new AccountList();
		for (Account i : a.getAccountList()) {
			if (i.getRank() != 0)
				model.addRow(new Object[] { i.getUsername(), i.getFullName(), i.getBirthday(), "", "", i.getPhoneNum(),
						"", "" });
		}

		JLabel lblNewLabel = new JLabel("Quản lý tài khoản");
		lblNewLabel.setFont(new Font("UTM Times", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 177, 33);
		f.getContentPane().add(lblNewLabel);

		final JButton ADbuttonDX = new JButton("�?ăng xuất");
		ADbuttonDX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(ADbuttonDX, "Bạn có muốn đăng xuất", "Logout",
						JOptionPane.YES_NO_OPTION);
				if (output == 0) {
					GuiMain frm1 = new GuiMain();
					frm1.setVisible(true);
					f.dispose();
				}
			}
		});
		ADbuttonDX.setBorder(UIManager.getBorder("CheckBox.border"));
		ADbuttonDX.setBounds(720, 0, 129, 23);
		f.getContentPane().add(ADbuttonDX);

//		JMenu mnNewMenu = new JMenu("Xem thông tin theo");
//		mnNewMenu.setDelay(0);
//		mnNewMenu.setHorizontalTextPosition(SwingConstants.LEFT);
//		mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
//		mnNewMenu.setVerticalAlignment(SwingConstants.TOP);
//		mnNewMenu.setBounds(691, 130, 148, 26);
//		f.getContentPane().add(mnNewMenu);

//		JButton btnNewButton_1 = new JButton("Tên A-Z");
//		mnNewMenu.add(btnNewButton_1);
//
//		JButton btnNewButton_2 = new JButton("Tên Z-A");
//		mnNewMenu.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Xóa TK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountList a = new AccountList();
				int index = jt.getSelectedRow();
				if (index == -1)
					return;
				String choice = (String) jt.getValueAt(index, 0);
				a.delete(choice);
				model.removeRow(index);
			}
		});
		btnNewButton_3.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton_3.setBounds(594, 132, 89, 23);
		f.getContentPane().add(btnNewButton_3);
		// test
		f.setSize(865, 522);
		f.setVisible(true);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		Account a = new Account("fudio101_admin007", "Ng01637202484", "Nguyễn �?ỗ Thế Nguyên",
				LocalDate.of(2001, Month.JANUARY, 1), "0337202484");
		new GuiAdmin(a);
	}
}