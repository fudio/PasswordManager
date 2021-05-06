package Encryption;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Test {
	public static void main(String[] args) throws Exception {
		String message = "This string contains a secret message.";

		// generate a key
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		keygen.init(128);
		byte[] key = keygen.generateKey().getEncoded();
		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");

		byte[] iv = new byte[16];
		new SecureRandom().nextBytes(iv);
		IvParameterSpec ivspec = new IvParameterSpec(iv);

		// initialize the cipher for encrypt mode
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivspec);

		// encrypt the message
		byte[] encrypted = cipher.doFinal(message.getBytes());
		System.out.println("Ciphertext: " + hexEncode(encrypted) + "\n");

		// Write IV
		FileOutputStream fs = new FileOutputStream(new File("paramFile"));
		BufferedOutputStream bos = new BufferedOutputStream(fs);
		bos.write(iv); //ivspec.getIV()
		bos.close();

		// Read IV
		byte[] fileData = new byte[16];
		DataInputStream dis = null;

		dis = new DataInputStream(new FileInputStream(new File("paramFile")));
		dis.readFully(fileData);
		if (dis != null) {
			dis.close();
		}

		// reinitialize the cipher for decryption
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(fileData));

		// decrypt the message
		byte[] decrypted = cipher.doFinal(encrypted);
		System.out.println("Plaintext: " + new String(decrypted) + "\n");
	}

	public static String hexEncode(byte[] input) {
		if (input == null || input.length == 0) {
			return "";
		}

		int inputLength = input.length;
		StringBuilder output = new StringBuilder(inputLength * 2);

		for (int i = 0; i < inputLength; i++) {
			int next = input[i] & 0xff;
			if (next < 0x10) {
				output.append("0");
			}

			output.append(Integer.toHexString(next));
		}

		return output.toString();
	}
}
