package Storage;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class Account {
	private String username;
	private String password;
	private byte[] hashedPw;
	

	public Account(String username, String password) throws NoSuchAlgorithmException {
		this.username = username;
		this.password = password;//bgvfdfvrtyhbtgvrfcedtrhrevdcsfevrtcffhyyjfhtr
		byte[] sha256hash = sha256(password);
		// String sha256hex = bytesToHex(sha256hash);
		this.hashedPw = BCrypt.withDefaults().hash(12, sha256hash);
	}

	private byte[] sha256(String value) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(value.getBytes(StandardCharsets.UTF_8));
		return hash;
	}

	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Account a = new Account("fudio", "Ng01637202484");
		System.out.println(a);
		System.out.println(new String(a.getHasedPw(),StandardCharsets.UTF_8));
	}

	private byte[] getHasedPw() {
		return this.hashedPw;
	}
}
