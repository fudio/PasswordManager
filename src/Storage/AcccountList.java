package Storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.Queue;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AcccountList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6967904973869758331L;
	private String path = "D:\\\\eclipse-workspace\\\\PasswordManager\\\\src\\\\Storage\\\\Account.dat";
	private Queue<Account> accountList;

	public AcccountList() {
		accountList = new LinkedList<>();
		readFile(this.path);
	}

	protected void readFile(String path) {
		if (!accountList.isEmpty())
			accountList.clear();
		File myObj = new File(path);
		if (!myObj.exists())
			try {
				myObj.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		FileInputStream fi;
		try {
			fi = new FileInputStream(new File(path));
			ObjectInputStream oi = new ObjectInputStream(fi);
			while (true) {
				Account tempt = null;
				try {
					tempt = (Account) oi.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				if (tempt != null)
					accountList.add(tempt);
				else
					break;
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	protected Queue<Account> getAccountList() {
		return accountList;
	}

	protected void writeFile(String path) {
		File myObj = new File(path);
		myObj.delete();
		try {
			myObj.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			FileOutputStream fileOut = new FileOutputStream(new File(path), true);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			Account t = accountList.poll();
			// while (!accountList.isEmpty()) {
			objectOut.writeObject(t);
			// accountList.poll()
			// }
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected boolean addAccount(Account a) {
		for (var i : this.accountList)
			if (i.getUsername() == a.getUsername())
				return false;
		this.accountList.add(a);
		return true;
	}

	protected Account findAccount(String username) {
		for (var i : this.accountList)
			if (i.getUsername() == username)
				return i;
		return null;
	}

	public static void main(String[] args)
			throws InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException,
			NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
		//https://stackoverflow.com/questions/60705536/task-not-serializable-error-while-calling-udf-to-spark-dataframe
		AcccountList a = new AcccountList();
		a.addAccount(new Account("fudio", "fudio", "A", LocalDate.of(2001, Month.JANUARY, 1)));
		a.addAccount(new Account("fudi", "fudio", "A", LocalDate.of(2001, Month.JANUARY, 1)));
		System.out.println(a.getAccountList());
		a.writeFile(a.path);
		System.out.println(a.getAccountList());
	}
}
