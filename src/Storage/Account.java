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
import java.time.format.DateTimeFormatter;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import Encryption.AESUtil;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class Account {

	public static void main(String[] args) throws IOException {
//		Account a = new Account("fudio", "Ng01637202484", "Nguyễn �?ỗ Thế Nguyên", LocalDate.of(2001, Month.JANUARY, 1),
//				"0337202484");
//		System.out.println(a);
//		System.out.println(a.getHasedPw());
//		System.out.println(a.check("Ng01637202484"));
//		a.insert("Account.db");
//		a.selectAll("Account.db");
//		String str = "�?ăng";
//		System.out.println(Account.deAccent(str));
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

	static final boolean MALE = true;
	static final boolean FEMALE = false;

	private String username;
	private String password;
	private int rank;
	private LocalDate birthday;
	private String fullName;
	private String phoneNum;
	private Date createDate;
	private String email;
	private Boolean sex;
	private String facebook;
	private String work;
	private String address;

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
			this.email = rs.getString("email");
			this.sex = rs.getBoolean("sex");
			this.facebook = rs.getString("facebook");
			this.work = rs.getString("work");
			this.address = rs.getString("address");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Account(String un) {
		this.username = un.toLowerCase();
		this.createDate = Date.valueOf(LocalDate.now());
		this.sex = true;
	}

	public Account(String un, String pw, String fN, LocalDate bd, String pN) {
		this.username = un.replace("_admin007", "").toLowerCase();
		this.rank = un.contains("_admin007") ? 0 : 1;
		this.fullName = fN;
		this.birthday = bd;
		this.phoneNum = pN;
		this.createDate = Date.valueOf(LocalDate.now());
		this.sex = true;
		String BCryptHash = BCryptHash(pw);

		try {
			this.password = AESUtil.encryptPasswordBased(BCryptHash, AESUtil.readKey("keyFile"),
					AESUtil.readIv("paramFile"));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Account(String un, String n) {
		this.username = un.toLowerCase();
		this.fullName = n;
		this.createDate = Date.valueOf(LocalDate.now());
		this.sex = true;
	}

	private String BCryptHash(String pw) {
		byte[] sha256Hash = sha256(pw);
		int cost = 12;
		byte[] BCryptHash = BCrypt.withDefaults().hash(cost, this.getSalt(), sha256Hash);
		return new String(BCryptHash, StandardCharsets.UTF_8);
	}

	public boolean check(String password) {
		byte[] sha256Hash;
		sha256Hash = sha256(password);
		return BCrypt.verifyer().verify(sha256Hash, this.getHasedPw().getBytes(StandardCharsets.UTF_8)).verified;

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

	public String getBirthday() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LL/yyyy");
		return this.birthday.format(formatter);
	}

	public LocalDate getBirthday_() {
		return birthday;
	}

	private Date getBirthdayDate() {
		return Date.valueOf(birthday);
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getFullName() {
		return fullName;
	}

	private String getHasedPw() {
		try {
			return AESUtil.decryptPasswordBased(this.password, AESUtil.readKey("keyFile"), AESUtil.readIv("paramFile"));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
			return null;
		} catch (BadPaddingException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public int getRank() {
		return rank;
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

	public String getUsername() {
		return this.username;
	}

	public void insert(String path) {
		String sql = "REPLACE INTO Account(username, password, rank, birthday, fullname, phoneNumber, createDate, email, sex, facebook, work, address) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection conn = this.connect(path); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, this.username);
			pstmt.setString(2, this.password);
			pstmt.setInt(3, this.rank);
			pstmt.setDate(4, this.getBirthdayDate());
			pstmt.setString(5, this.fullName);
			pstmt.setString(6, this.phoneNum);
			pstmt.setDate(7, this.createDate);
			pstmt.setString(8, this.email);
			pstmt.setBoolean(9, this.sex);
			pstmt.setString(10, this.facebook);
			pstmt.setString(11, this.work);
			pstmt.setString(12, this.address);
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
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
						+ rs.getString("phoneNumber") + "\t" + rs.getDate("createDate") + "\t" + rs.getBoolean("sex"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setBirthday(LocalDate date) {
		this.birthday = date;
	}

	public void setFullName(String text) {
		this.fullName = text;
	}

	public void setPhoneNum(String text) {
		this.phoneNum = text;
	}

	public Boolean getSex() {
		return this.sex;
	}

	public String getEmail() {
		return this.email;
	}

	public String getFb() {
		return this.facebook;
	}

	public String getWork() {
		return this.work;
	}

	public String getAddress() {
		return this.address;
	}

	public String getName() {
		if (this.fullName != null) {
			if (this.fullName.contains(" ")) {
				return this.fullName.substring(this.fullName.lastIndexOf(" ") + 1);
			}
		}
		return this.fullName;
	}

//	private static String deAccent(String str) {
//		str = str.replaceAll("đ", "d");
//		str = str.replaceAll("�?", "D");
//		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
//		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//		return pattern.matcher(nfdNormalizedString).replaceAll("");
//	}
//	private static String nonAccentVietnamese(String str) {
//	    str = str.toLowerCase();
//	    str = str.replace("à", "a");
//	    str = str.replace("á", "a");
//	    str = str.replace("ạ", "a");
//	    str = str.replace("ả", "a");
//	    str = str.replace("ã", "a");
//	    str = str.replace("â", "a");
//	    str = str.replace("ầ", "a");
//	    str = str.replace("ấ", "a");
//	    str = str.replace("ậ", "a");
//	    str = str.replace("ẩ", "a");
//	    str = str.replace("ẫ", "a");
//	    str = str.replace("ă", "a");
//	    str = str.replace("ằ", "a");
//	    str = str.replace("ắ", "a");
//	    str = str.replace("ặ", "a");
//	    str = str.replace("ẳ", "a");
//	    str = str.replace("ẵ", "a");
//	    str = str.replace("è", "e");
//	    str = str.replace("é", "e");
//	    str = str.replace("ẹ", "e");
//	    str = str.replace("ẻ", "e");
//	    str = str.replace("ẽ", "e");
//	    str = str.replace("ê", "e");
//	    str = str.replace("�?", "e");
//	    str = str.replace("ế", "e");
//	    str = str.replace("ệ", "e");
//	    str = str.replace("ể", "e");
//	    str = str.replace("ễ", "e");
//	    str = str.replace("ì"|"í"|"ị"|"ỉ"|"ĩ", "i");
//	    str = str.replace(, "i");
//	    str = str.replace(, "i");
//	    str = str.replace(, "i");
//	    str = str.replace(, "i");
//	    str = str.replace("ò"|"ó"|"�?"|"�?"|"õ"|"ô"|"ồ"|"ố"|"ộ"|"ổ"|"ỗ"|"ơ"|"�?"|"ớ"|"ợ"|"ở"|"ỡ", "o");
//	    str = str.replace(, "o");
//	    str = str.replace("ù"|"ú"|"ụ"|"ủ"|"ũ"|"ư"|"ừ"|"ứ"|"ự"|"ử"|"ữ", "u");
//	    str = str.replace("ỳ"|"ý"|"ỵ"|"ỷ"|"ỹ", "y");
//	    str = str.replace("đ", "d");
//	    // Some system encode vietnamese combining accent as individual utf-8 characters
//	    str = str.replace("\u0300", ""); // Huy�?n sắc h�?i ngã nặng 
//	    str = str.replace("\u0301","");
//	    str = str.replace("\u0303","");
//	    str = str.replace("\u0309","");
//	    str = str.replace("\u0323","");
//	    str = str.replace("\u02C6"|"\u0306"|"\u031B", ""); // Â, Ê, Ă, Ơ, Ư
//	    return str;
//	}
}
