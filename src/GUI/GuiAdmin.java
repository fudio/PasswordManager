package GUI;
 
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Point;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSpinner;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
 
public class GuiAdmin {
    JFrame f;
 
    /**
     * @wbp.parser.entryPoint
     */
    GuiAdmin() {
        f = new JFrame();
        f.setLocation(new Point(300, 300));
        f.setTitle("ADMIN");
 
        String data[][] = { { " ", " ", " ", " ", " ", " ", " ", " "} };
        String column[] = { "Tên đăng nhập", "Họ tên", "Ngày sinh", "Giới tính", "Công việc", "SĐT", "Email", "Mạng xã hội"};
        f.getContentPane().setLayout(null);
 
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 200, 300);
 
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(0, 166, 849, 317);
        f.getContentPane().add(sp);
        
        JLabel lblNewLabel = new JLabel("Quản lý tài khoản");
        lblNewLabel.setFont(new Font("UTM Times", Font.PLAIN, 22));
        lblNewLabel.setBounds(10, 11, 177, 33);
        f.getContentPane().add(lblNewLabel);
        
        final JButton ADbuttonDX = new JButton("Đăng xuất");
        ADbuttonDX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int output = JOptionPane.showConfirmDialog(ADbuttonDX, "Bạn có muốn đăng xuất", "Logout",
						JOptionPane.YES_NO_OPTION);
				if (output == 0) {
					GuiMain frm1 = new GuiMain();
					frm1.setVisible(true);
					//dispose();
				}
			}
		});
        ADbuttonDX.setBorder(UIManager.getBorder("CheckBox.border"));
        ADbuttonDX.setBounds(720, 0, 129, 23);
        f.getContentPane().add(ADbuttonDX);
        
        JMenu mnNewMenu = new JMenu("Xem thông tin theo");
        mnNewMenu.setDelay(0);
        mnNewMenu.setHorizontalTextPosition(SwingConstants.LEFT);
        mnNewMenu.setHorizontalAlignment(SwingConstants.LEFT);
        mnNewMenu.setVerticalAlignment(SwingConstants.TOP);
        mnNewMenu.setBounds(691, 130, 148, 26);
        f.getContentPane().add(mnNewMenu);
        
        JButton btnNewButton_1 = new JButton("Tên A-Z");
        mnNewMenu.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Tên Z-A");
        mnNewMenu.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("Xóa TK");
        btnNewButton_3.setBorder(UIManager.getBorder("CheckBox.border"));
        btnNewButton_3.setBounds(594, 132, 89, 23);
        f.getContentPane().add(btnNewButton_3);
 
        f.setSize(865, 522);
        f.setVisible(true);
    }
 
    /**
     * @wbp.parser.entryPoint
     */
    public static void main(String[] args) {
        new GuiAdmin();
    }
}