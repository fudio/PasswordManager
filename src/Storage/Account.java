package Storage;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

import Encryption.AESUtil;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class Account extends AESUtil {
	private String username;
	private String password;
	private String password_;
	private byte[] salt;
	private IvParameterSpec ivParameterSpec;

	public Account(String username, String password) throws NoSuchAlgorithmException, InvalidKeyException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
			InvalidKeySpecException {
		this.username = username;
		this.password = password;
		this.salt = new byte[16];
		byte[] sha256Hash = sha256(password);
		new SecureRandom().nextBytes(this.salt);
		byte[] BCryptHash = BCrypt.withDefaults().hash(12, this.salt, sha256Hash);
		this.ivParameterSpec = AESUtil.generateIv();
		String a = new String(BCryptHash, StandardCharsets.UTF_8);
		this.password_ = AESUtil.encryptPasswordBased(a, AESUtil.getKey(), this.ivParameterSpec);
	}

	private static byte[] sha256(String value) throws NoSuchAlgorithmException {
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

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
			InvalidKeySpecException {
		Account a = new Account("fudio", "Ng01637202484");
		System.out.println(a);
		System.out.println(a.getHasedPw());
		// $2a$12$O5nGM9Rl9W6nv.f41TwM1u5Cm3/fijWemqD6FfNebNvcRgJxuaLIm
		// $2a$12$KuuXHsgY9phQ0.GmXquEF.E1x5jfuuIgiqYCV4YEcJFt8yxQQjNHG
		System.out.println(a.check("Ng01637202484"));
	}

	private boolean check(String password) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
			InvalidKeySpecException {
		byte[] sha256Hash = sha256(password);
		return BCrypt.verifyer().verify(sha256Hash, this.getHasedPw().getBytes(StandardCharsets.UTF_8)).verified;
	}

	private String getHasedPw() throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
			InvalidKeySpecException {
		return AESUtil.decryptPasswordBased(this.password_, AESUtil.getKey(), this.ivParameterSpec);
	}
}
