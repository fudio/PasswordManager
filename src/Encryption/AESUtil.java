package Encryption;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
	public static String encrypt(String algorithm, String input, SecretKey key, IvParameterSpec iv)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}

	public static String decrypt(String algorithm, String cipherText, SecretKey key, IvParameterSpec iv)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
		return new String(plainText);
	}

	public static SecretKey generateKey(int n) throws NoSuchAlgorithmException {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(n);
		SecretKey key = keyGenerator.generateKey();
		return key;
	}

	public static SecretKey getKeyFromPassword(String password, String salt)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
		SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		return secret;
	}

	public static IvParameterSpec generateIv() {
		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		return new IvParameterSpec(iv);
	}

	public static void encryptFile(String algorithm, SecretKey key, IvParameterSpec iv, File inputFile, File outputFile)
			throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		FileInputStream inputStream = new FileInputStream(inputFile);
		FileOutputStream outputStream = new FileOutputStream(outputFile);
		byte[] buffer = new byte[64];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			byte[] output = cipher.update(buffer, 0, bytesRead);
			if (output != null) {
				outputStream.write(output);
			}
		}
		byte[] outputBytes = cipher.doFinal();
		if (outputBytes != null) {
			outputStream.write(outputBytes);
		}
		inputStream.close();
		outputStream.close();
	}

	public static void decryptFile(String algorithm, SecretKey key, IvParameterSpec iv, File encryptedFile,
			File decryptedFile) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		FileInputStream inputStream = new FileInputStream(encryptedFile);
		FileOutputStream outputStream = new FileOutputStream(decryptedFile);
		byte[] buffer = new byte[64];
		int bytesRead;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			byte[] output = cipher.update(buffer, 0, bytesRead);
			if (output != null) {
				outputStream.write(output);
			}
		}
		byte[] output = cipher.doFinal();
		if (output != null) {
			outputStream.write(output);
		}
		inputStream.close();
		outputStream.close();
	}

	public static SealedObject encryptObject(String algorithm, Serializable object, SecretKey key, IvParameterSpec iv)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, IOException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		SealedObject sealedObject = new SealedObject(object, cipher);
		return sealedObject;
	}

	public static Serializable decryptObject(String algorithm, SealedObject sealedObject, SecretKey key,
			IvParameterSpec iv)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, ClassNotFoundException, BadPaddingException, IllegalBlockSizeException, IOException {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		Serializable unsealObject = (Serializable) sealedObject.getObject(cipher);
		return unsealObject;
	}

	public static String encryptPasswordBased(String plainText, SecretKey key, IvParameterSpec iv)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
	}

	public static String decryptPasswordBased(String cipherText, SecretKey key, IvParameterSpec iv)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException,
			InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		return new String(cipher.doFinal(Base64.getDecoder().decode(cipherText)));
	}

//	public static SecretKey getKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
//		String password = "Nguyensieudeptraii";
//		String salt = "imbaresalt";
//		return AESUtil.getKeyFromPassword(password, salt);
//	}

	private static void saveKey(SecretKey key, String path) throws IOException {
		byte[] keyByte = key.getEncoded();
		FileOutputStream fs = new FileOutputStream(new File(path));
		BufferedOutputStream bos = new BufferedOutputStream(fs);
		bos.write(keyByte);
		bos.close();
	}

	public static SecretKey readKey(String path) throws IOException {
		byte[] fileData = new byte[32];
		DataInputStream dis = new DataInputStream(new FileInputStream(new File(path)));
		dis.readFully(fileData);
		if (dis != null) {
			dis.close();
		}
		return new SecretKeySpec(fileData, "AES");
	}

//	private static void saveIv(IvParameterSpec ivspec, String path) throws IOException {
//		FileOutputStream fs = new FileOutputStream(new File(path));
//		BufferedOutputStream bos = new BufferedOutputStream(fs);
//		bos.write(ivspec.getIV());
//		bos.close();
//	}

	public static IvParameterSpec readIv(String path) throws IOException {
		byte[] fileData = new byte[16];
		DataInputStream dis = null;

		dis = new DataInputStream(new FileInputStream(new File(path)));
		dis.readFully(fileData);
		if (dis != null) {
			dis.close();
		}
		return new IvParameterSpec(fileData);
	}

	public static void main(String[] args)
			throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, IOException {
		String plainText = "www.656546546546.com";
		IvParameterSpec ivParameterSpec = AESUtil.generateIv();
		String password = "baeldung";
		String salt = "12345678";
		SecretKey key = AESUtil.getKeyFromPassword(password, salt);
		// SecretKey key = getKey();
		String cipherText = AESUtil.encryptPasswordBased(plainText, key, ivParameterSpec);
		AESUtil.saveKey(key, "src/Encryption/key/keyFile_");
		SecretKey key2 = AESUtil.readKey("src/Encryption/key/keyFile_");
		String decryptedCipherText = AESUtil.decryptPasswordBased(cipherText, key2, ivParameterSpec);
		System.out.println(plainText);
		System.out.println(decryptedCipherText);
		System.out.println(cipherText);
	}
}
