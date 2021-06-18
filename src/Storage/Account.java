package Storage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import Encryption.AESUtil;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class Account {

	private String username;
	private String password;
	private int rank;
	private LocalDate birthday;
	private String fullName;
	private String phoneNum;
	private Date createDate;

	public Account(String un, String pw, String fN, LocalDate bd, String pN) {
		this.username = un.replace("_admin007", "");
		this.rank = un.contains("_admin007") ? 0 : 1;
		this.fullName = fN;
		this.birthday = bd;
		this.phoneNum = pN;
		this.createDate = Date.valueOf(LocalDate.now());
		String BCryptHash = BCryptHash(pw);

		try {
			this.password = AESUtil.encryptPasswordBased(BCryptHash, AESUtil.readKey("keyFile"),
					AESUtil.readIv("paramFile"));
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private byte[] getSalt() {
		String tempt = this.username;
		while (tempt.length() < 32) {
			tempt += tempt;
		}
		byte[] data = new byte[16];
		for (int i = 0; i < 32; i += 2) {
			data[i / 2] = (byte) (((float) (Character.digit(tempt.charAt(i), 36)) * (-Math.PI * Math.PI))
					+ ((float) Character.digit(tempt.charAt(i + 1), 36)) * (Math.PI * Math.PI));
		}
		return data;
	}

	private String BCryptHash(String pw) {
		byte[] sha256Hash = sha256(pw);
		int cost = 12;
		byte[] BCryptHash = BCrypt.withDefaults().hash(cost, this.getSalt(), sha256Hash);
		return new String(BCryptHash, StandardCharsets.UTF_8);
	}

	public Account(String un) {
		this.username = un.toLowerCase();
	}

	public Account(ResultSet rs) {
		// username, password, rank, birthday, fullname, salt, phoneNumber
		try {
			this.username = rs.getString("username");
			this.password = rs.getString("password");
			this.rank = rs.getInt("rank");
			this.birthday = new java.sql.Date(rs.getDate("birthday").getTime()).toLocalDate();
			this.fullName = rs.getString("fullname");
			this.phoneNum = rs.getString("phoneNumber");
			this.createDate = rs.getDate("createDate");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static byte[] sha256(String value) {
		MessageDigest digest;
		byte[] hash = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hash;

	}

	public static void main(String[] args) throws IOException {
		Account a = new Account("fudio", "Ng01637202484", "Nguyễn Đỗ Thế Nguyên", LocalDate.of(2001, Month.JANUARY, 1),
				"0337202484");
		System.out.println(a);
		System.out.println(a.getHasedPw());
		System.out.println(a.check("Ng01637202484"));
		a.insert("Account.db");
		a.selectAll("Account.db");
	}

	public boolean check(String password) {
		byte[] sha256Hash;
		sha256Hash = sha256(password);
		return BCrypt.verifyer().verify(sha256Hash, this.getHasedPw().getBytes(StandardCharsets.UTF_8)).verified;

	}

	private String getHasedPw() {
		try {
			return AESUtil.decryptPasswordBased(this.password, AESUtil.readKey("keyFile"), AESUtil.readIv("paramFile"));
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getUsername() {
		return this.username;
	}

	public int getRank() {
		return rank;
	}

	public LocalDate getBirthday_() {
		return birthday;
	}

	public String getBirthday() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LL/yyyy");
		return this.birthday.format(formatter);
	}

	public String getFullName() {
		return fullName;
	}

	private Connection connect(String path) {
		// SQLite connection string
		String url = "jdbc:sqlite:" + path;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public void insert(String path) {
		String sql = "REPLACE INTO Account(username, password, rank, birthday, fullname, phoneNumber, createDate) VALUES(?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(path); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, this.username);
			pstmt.setString(2, this.password);
			pstmt.setInt(3, this.rank);
			pstmt.setDate(4, this.getBirthdayDate());
			pstmt.setString(5, this.fullName);
			pstmt.setString(6, this.phoneNum);
			pstmt.setDate(7, this.createDate);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Date getCreateDate() {
		return createDate;
	}

	private Date getBirthdayDate() {
		return Date.valueOf(birthday);
	}

	private void selectAll(String path) {
		String sql = "SELECT * FROM Account";

		try (Connection conn = this.connect(path);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("username") + "\t" + rs.getString("password") + "\t" + rs.getInt("rank")
						+ "\t" + rs.getDate("birthday") + "\t" + rs.getString("fullname") + "\t"
						+ rs.getString("phoneNumber") + "\t" + rs.getDate("createDate"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setFullName(String text) {
		this.fullName = text;
	}

	public void setBirthday(LocalDate date) {
		this.birthday = date;
	}

	public void setPhoneNum(String text) {
		this.phoneNum = text;
	}
}