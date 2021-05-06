package Storage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
		this.username = un;
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

}