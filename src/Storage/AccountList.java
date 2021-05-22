package Storage;

import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AccountList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6967904973869758331L;
	private String path = "Account.db";
	private Queue<Account> accountList;

	public AccountList() {
		accountList = new LinkedList<>();
		readFile(this.path);
	}

	protected void readFile(String path) {
		String sql = "SELECT username, password, rank, birthday, fullname, phoneNumber FROM Account";

		try (Connection conn = this.connect(path);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				this.accountList.add(new Account(rs));
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		this.sortQueue();
	}

	public int minIndex(int sortIndex) {
		int min_index = -1;
		Account min_value = new Account("zzzzzzzzzzzzzzzz");
		int s = this.accountList.size();
		for (int i = 0; i < s; i++) {
			Account current = this.accountList.peek();

			this.accountList.poll();

			if (stringCompare(current.getUsername(), min_value.getUsername()) <= 0 && i <= sortIndex) {
				min_index = i;
				min_value = current;
			}
			this.accountList.add(current);
		}
		return min_index;
	}

	public static int stringCompare(String str1, String str2) {

		int l1 = str1.length();
		int l2 = str2.length();
		int lmin = Math.min(l1, l2);

		for (int i = 0; i < lmin; i++) {
			int str1_ch = (int) str1.charAt(i);
			int str2_ch = (int) str2.charAt(i);

			if (str1_ch != str2_ch) {
				return str1_ch - str2_ch;
			}
		}

		if (l1 != l2) {
			return l1 - l2;
		}

		else {
			return 0;
		}
	}

	public void insertMinToRear(int min_index) {
		Account min_value = new Account("");
		int s = this.accountList.size();
		for (int i = 0; i < s; i++) {
			Account current = this.accountList.peek();
			this.accountList.poll();
			if (i != min_index)
				this.accountList.add(current);
			else
				min_value = current;
		}
		this.accountList.add(min_value);
	}

	public void sortQueue() {
		for (int i = 1; i <= this.accountList.size(); i++) {
			int min_index = minIndex(this.accountList.size() - i);
			insertMinToRear(min_index);
		}
	}

	private Connection connect(String path2) {
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

	protected Queue<Account> getAccountList() {
		return accountList;
	}

	protected void writeFile(String path) {
		while (!this.accountList.isEmpty()) {
			this.accountList.poll().insert("Account.db");
		}
	}

	public boolean addAccount(Account a) {
		String t = a.getUsername();
		for (Account i : this.accountList) {
			if (i.getUsername().equals(t))
				return false;
		}
		this.accountList.add(a);
		this.writeFile(this.path);
		return true;
	}

	protected Account findAccount(String username) {
		for (Account i : this.accountList)
			if (i.getUsername().equals(username))
				return i;
		return null;
	}

	public Account accountSearch(int x, int y, String s) {
		List<Account> t = new ArrayList<Account>(this.accountList);
		if (y >= x) {
			int mid = x + (y - x) / 2;
			Account a = (Account) t.get(mid);
			int rs = AccountList.stringCompare(a.getUsername(), s);
			// If the element is present at the
			// middle itself
			if (rs == 0)
				return a;

			// If element is smaller than mid, then
			// it can only be present in left subarray
			if (rs > 0)
				return accountSearch(x, mid - 1, s);

			// Else the element can only be present
			// in right subarray
			return accountSearch(mid + 1, y, s);
		}

		// We reach here when element is not present
		// in array
		return null;
	}

	public Account accountSearch(String s) {
		return this.accountSearch(0, this.accountList.size() - 1, s);
	}

	public static void main(String[] args)
			throws InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException,
			NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
		// https://stackoverflow.com/questions/60705536/task-not-serializable-error-while-calling-udf-to-spark-dataframe
		AccountList a = new AccountList();
		a.addAccount(new Account("fudio", "fudio", "A", LocalDate.of(2001, Month.JANUARY, 1), "0337202484"));
		a.addAccount(new Account("fudi", "fudio", "A", LocalDate.of(2001, Month.JANUARY, 1), "0337202484"));
		System.out.println(a.accountSearch("fudio"));
		System.out.println(a.getAccountList());
		a.writeFile(a.path);
		System.out.println(a.getAccountList());
	}
}
