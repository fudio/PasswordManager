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

	public Account(String un, String pw, String fN, LocalDate bd, String pN) {
		this.username = un;
		this.rank = this.username.contains("_admin007") ? 0 : 1;
		this.fullName = fN;
		this.birthday = bd;
		this.phoneNum = pN;
		String BCryptHash = BCryptHash(pw);
		try {
			this.password = AESUtil.encryptPasswordBased(BCryptHash, AESUtil.readKey("keyFile"),
					AESUtil.readIv("paramFile"));
		} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException
				| InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException
				| IOException e) {
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
		} catch (InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException
				| InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException
				| IOException e) {
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
		String sql = "REPLACE INTO Account(username, password, rank, birthday, fullname, phoneNumber) VALUES(?,?,?,?,?,?)";

		try (Connection conn = this.connect(path); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, this.username);
			pstmt.setString(2, this.password);
			pstmt.setInt(3, this.rank);
			pstmt.setDate(4, this.getBirthdayDate());
			pstmt.setString(5, this.fullName);
			pstmt.setString(6, this.phoneNum);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
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
						+ rs.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}
}