package GUI;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import Storage.AccountList;
import Storage.Account;

public class Login extends AccountList {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5226659379906941778L;
	private boolean result;

	public Login(String username, String password) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
			InvalidKeySpecException {
		this.verify(username, password);
	}

	private void verify(String username, String password) throws InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
			InvalidKeySpecException {
		Account a = this.findAccount(username);
		if (a != null)
			this.result = a.check(password);
		else
			this.result = false;
	}

	public boolean getResufl() {
		return this.result;
	}

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
			InvalidKeySpecException {
		Login a = new Login("fudio", "fudio");
		System.out.println(a.getResufl());
	}
}
