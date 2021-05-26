package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;

public class GuiMain extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2407220582024135734L;
	protected static final Component ButtonOut = null;
	private JPanel pan_1;
	private JLabel website;
	private JLabel contact_1;
	private JLabel website_1;
	private JLabel lblNewLabel;
	private JMenu MenuFirst;
	private JButton buttonDNmain;
	private JButton buttonDKmain;

	/**
	 * Creates new form JLabelLink
	 */
	public GuiMain() {
		this.setTitle("CARROT TEAM");
		this.setSize(795, 551);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		new JPanel();
		contact_1 = new JLabel();
		contact_1.setForeground(Color.PINK);
		contact_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		contact_1.setHorizontalTextPosition(SwingConstants.CENTER);
		contact_1.setHorizontalAlignment(SwingConstants.CENTER);
		contact_1.setBounds(35, 334, 207, 73);
		contact_1.setFont(new Font("UTM Trajan Pro Bold", Font.PLAIN, 16));

		pan_1 = new JPanel();
		pan_1.setForeground(new Color(0, 0, 0));
		website_1 = new JLabel();
		website_1.setHorizontalAlignment(SwingConstants.CENTER);
		website_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		website_1.setHorizontalTextPosition(SwingConstants.CENTER);
		website_1.setForeground(Color.PINK);
		website_1.setFont(new Font("UTM Trajan Pro Bold", Font.PLAIN, 16));
		website_1.setBounds(35, 126, 207, 73);

		website = new JLabel();
		website.setForeground(Color.PINK);
		website.setBorder(UIManager.getBorder("DesktopIcon.border"));
		website.setHorizontalTextPosition(SwingConstants.CENTER);
		website.setHorizontalAlignment(SwingConstants.CENTER);
		website.setBounds(35, 233, 207, 73);
		website.setFont(new Font("UTM Trajan Pro Bold", Font.PLAIN, 16));

		contact_1.setText("Nh\u00F3m t\u00E1c gi\u1EA3");
		contact_1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		website_1.setText("\u0110\u00E0o t\u1EA1o tr\u1EF1c tuy\u1EBFn");
		website_1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		website.setText("Trang SV");
		website.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pan_1.setLayout(null);

		pan_1.add(contact_1);
		pan_1.add(website_1);
		pan_1.add(website);
		this.setContentPane(pan_1);
		this.setVisible(true);
		sendMail(contact_1);
		goWebsite(website);
		goWebsite_1(website_1);

		lblNewLabel = new JLabel("CARROT TEAM");
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setFont(new Font("UTM Ambrose", Font.PLAIN, 40));
		lblNewLabel.setBounds(35, 11, 355, 90);
		pan_1.add(lblNewLabel);

		MenuFirst = new JMenu("T\u00E0i kho\u1EA3n");
		MenuFirst.setForeground(Color.PINK);
		MenuFirst.setDelay(0);
		MenuFirst.setBounds(660, 11, 115, 26);
		pan_1.add(MenuFirst);

		buttonDNmain = new JButton("\u0110\u0103ng nh\u1EADp");
		buttonDNmain.setForeground(Color.PINK);
		buttonDNmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiLogin frm1 = new GuiLogin();
				frm1.setVisible(true);
				dispose();
			}
		});

		MenuFirst.add(buttonDNmain);

		buttonDKmain = new JButton("  \u0110\u0103ng k\u00FD  ");
		buttonDKmain.setForeground(Color.PINK);
		buttonDKmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GuiRegier frm1 = new GuiRegier();
				frm1.setVisible(true);
				dispose();
			}
		});
		MenuFirst.add(buttonDKmain);
		
		JLabel lb = new JLabel("");
		lb.setBounds(1, 1, 1026, 673);
		lb.setHorizontalTextPosition(SwingConstants.CENTER);
		lb.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane();
		getContentPane().add(lb);
		System.out.print("x:" + lb.getSize().width + "y: " + lb.getSize().height);
		
		try {
			BufferedImage image = ImageIO.read(new File("bg1.jpeg"));
			ImageIcon icon = new ImageIcon(image.getScaledInstance(1019, 669, image.SCALE_SMOOTH));
			lb.setIcon(icon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pan_1.add(lb);

	}

	public static void main(String args[]) {
		/*
		 * Create and display the form
		 */
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new GuiMain().setVisible(true);
			}
		});
	}

	private void goWebsite(JLabel website) {
		website.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://sv.ut.edu.vn"));
				} catch (URISyntaxException | IOException ex) {
					// It looks like there's a problem
				}
			}
		});
	}

	private void goWebsite_1(JLabel website) {
		website.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://courses.ut.edu.vn/"));
				} catch (URISyntaxException | IOException ex) {
					// It looks like there's a problem
				}
			}
		});
	}

	private void sendMail(JLabel contact) {
		contact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URI("https://www.facebook.com/Thach.Huynh.ZoneNop/"));
				} catch (URISyntaxException | IOException ex) {
					// It looks like there's a problem
				}
			}
		});
	}
}