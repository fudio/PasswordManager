package GUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Queue;

import Storage.Account;

public class Register {
	private Queue<Account> accountList;

	public Register() {
	}

	private void readFile(String path) {
		accountList.clear();
		File myObj = new File(path);
		if (!myObj.exists())
			try {
				myObj.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		try {
			FileInputStream fi = new FileInputStream(new File(path));
			ObjectInputStream oi = new ObjectInputStream(fi);
			Account tempt = (Account) oi.readObject();
			while (tempt != null) {
				accountList.add(tempt);
				tempt = (Account) oi.readObject();
			}
			fi.close();
			oi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Queue<Account> getAccountList() {
		return accountList;
	}

	private void writeFile(String path) {
		File myObj = new File(path);
		myObj.delete();
		try {
			myObj.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			FileOutputStream fo = new FileOutputStream(new File(path));
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			Account tempt = (Account) accountList.poll();
			while (tempt != null) {
				oo.writeObject(tempt);
				tempt = (Account) accountList.poll();
			}
			fo.close();
			oo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
