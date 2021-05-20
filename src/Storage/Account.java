package Storage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

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
	private byte[] salt;

	public Account(String un, String pw, String fN, LocalDate bd) {
		this.username = un.toLowerCase();
		this.rank = this.username.contains("_admin007") ? 0 : 1;
		this.fullName = fN;
		this.birthday = bd;
		this.salt = new byte[16];
		byte[] sha256Hash;
		try {
			sha256Hash = sha256(pw);
			new SecureRandom().nextBytes(this.salt);
			byte[] BCryptHash = BCrypt.withDefaults().hash(12, this.salt, sha256Hash);
			String a = new String(BCryptHash, StandardCharsets.UTF_8);
			this.password = AESUtil.encryptPasswordBased(a, AESUtil.readKey("keyFile"), AESUtil.readIv("paramFile"));
		} catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | BadPaddingException | IllegalBlockSizeException
				| IOException e) {
			e.printStackTrace();
		}
	}
	public Account(String un) {
		this.username=un.toLowerCase();
	}

	public Account(ResultSet rs) {
		// username, password, rank, birthday, fullname, salt
		try {
			this.username = rs.getString("username");
			this.password = rs.getString("password");
			this.rank = rs.getInt("rank");
			this.birthday = new java.sql.Date(rs.getDate("birthday").getTime()).toLocalDate();
			this.fullName = rs.getString("fullname");
			this.salt = rs.getBytes("salt");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static byte[] sha256(String value) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
		return hash;
	}

	public static void main(String[] args) throws IOException {
		Account a = new Account("fudio", "Ng01637202484", "Nguyễn Đỗ Thế Nguyên", LocalDate.of(2001, Month.JANUARY, 1));
		System.out.println(a);
		System.out.println(a.getHasedPw());
		System.out.println(a.check("Ng01637202484"));
		a.insert("Account.db");
		a.selectAll("Account.db");
	}

	public boolean check(String password) {
		byte[] sha256Hash;
		try {
			sha256Hash = sha256(password);
			return BCrypt.verifyer().verify(sha256Hash, this.getHasedPw().getBytes(StandardCharsets.UTF_8)).verified;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return false;
		}

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

	public LocalDate getBirthday() {
		return birthday;
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
		String sql = "REPLACE INTO Account(username, password, rank, birthday, fullname, salt) VALUES(?,?,?,?,?,?)";

		try (Connection conn = this.connect(path); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, this.username);
			pstmt.setString(2, this.password);
			pstmt.setInt(3, this.rank);
			pstmt.setDate(4, this.getBirthdayDate());
			pstmt.setString(5, this.fullName);
			pstmt.setBytes(6, this.salt);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	private Date getBirthdayDate() {
		return Date.valueOf(birthday);
	}

	public void selectAll(String path) {
		String sql = "SELECT username, password, rank, birthday, fullname, salt FROM Account";

		try (Connection conn = this.connect(path);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getString("username") + "\t" + rs.getString("password") + "\t" + rs.getInt("rank")
						+ "\t" + rs.getDate("birthday") + "\t" + rs.getString("fullname"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}