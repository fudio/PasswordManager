package Storage;

import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class AccountList implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6967904973869758331L;

	public static void main(String[] args)
			throws InvalidAlgorithmParameterException, InvalidKeyException, NoSuchPaddingException,
			NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException {
		// https://stackoverflow.com/questions/60705536/task-not-serializable-error-while-calling-udf-to-spark-dataframe
		AccountList a = new AccountList();
//		Account t = new Account("fudio", "fudio", "A", LocalDate.of(2001, Month.JANUARY, 1), "0337202484");
//		a.addAccount(t);
//		t = new Account("fudi", "fudio", "A", LocalDate.of(2001, Month.JANUARY, 1), "0337202484");
//		a.addAccount(t);
//		System.out.println(a.accountSearch("fudio"));
//		System.out.println(a.getAccountList());
//		a.writeFile(a.path);
//		System.out.println(a.getAccountList());
		a.searchByUsernameSort("fdi");
		a.searchByFullNameSort("Nguyên");
	}

	// Compare 2 String, return 0 if they equal, return a positive number if str1 is
	// greater than str2 and return a negative number if str1 is less than str 2
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
		} else {
			return 0;
		}
	}

	private Queue<Float> compareList;

	private Queue<Account> list;

	private final String path = "Account.db";

	private Queue<Account> searchList;

	public AccountList() {
		list = new LinkedList<Account>();
		searchList = new LinkedList<Account>();
		compareList = new LinkedList<Float>();
		readFile();
	}

	public Account accountSearch(int x, int y, String s) {
		List<Account> t = new ArrayList<Account>(this.list);
		if (y >= x) {
			int mid = x + (y - x) / 2;
			Account a = (Account) t.get(mid);
			int rs = AccountList.stringCompare(a.getUsername(), s);
			// If the element is present at the middle itself
			if (rs == 0) {
				return a;
			}
			// If element is smaller than mid, then it can only be
			// present in left subarray
			if (rs > 0) {
				return accountSearch(x, mid - 1, s);
			}
			// Else the element can only be present in right subarray
			return accountSearch(mid + 1, y, s);
		}
		// We reach here when element is not present in array
		return null;
	}

	public Account accountSearch(String s) {
		return this.accountSearch(0, this.list.size() - 1, s);
	}

	public boolean addAccount(Account a) {
		String t = a.getUsername();
		for (Account i : this.list) {
			if (i.getUsername().equals(t)) {
				return false;
			}
		}
		this.list.add(a);
		this.writeFile(this.path);
		return true;
	}

	private Connection connect(String path_) {
		// SQLite connection string
		String url = "jdbc:sqlite:" + path_;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	private void createSearchList() {
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			Float currentCompare = this.compareList.poll();
			Account current = this.list.poll();
			if (!currentCompare.equals(Float.valueOf(0))) {
				this.searchList.add(current);
			}
			this.compareList.add(currentCompare);
			this.list.add(current);
		}
	}

	public boolean delete(String choice) {
		List<Account> list = new ArrayList<Account>(this.list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUsername().equals(choice)) {
				list.remove(i);
				this.list = new LinkedList<Account>(list);
				this.sortQueue();
				this.deleteAllOfDatabase(this.path);
				this.writeFile(this.path);
				return true;
			}
		}
		return false;
	}

	private void deleteAllOfDatabase(String path) {
		String sql = "DELETE FROM Account";
		try (Connection conn = this.connect(path); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public boolean editAccount(Account a) {
		String t = a.getUsername();
		List<Account> list = new ArrayList<Account>(this.list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getUsername().equals(t)) {
				list.remove(i);
				list.add(a);
				this.list = new LinkedList<Account>(list);
				this.sortQueue();
				this.writeFile(this.path);
				return true;
			}
		}
		return false;
	}

	protected Account findAccount(String username) {
		for (Account i : this.list) {
			if (i.getUsername().equals(username)) {
				return i;
			}
		}
		return null;
	}

	public Queue<Account> getAccountList() {
		return list;
	}

	// // Returns length of LCS for X[0..m-1], Y[0..n-1]
//	static void lcs(String X, String Y, int m, int n) {
//		int[][] L = new int[m + 1][n + 1];
//
//		// Following steps build L[m+1][n+1] in bottom up fashion. Note
//		// that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
//		for (int i = 0; i <= m; i++) {
//			for (int j = 0; j <= n; j++) {
//				if (i == 0 || j == 0)
//					L[i][j] = 0;
//				else if (X.charAt(i - 1) == Y.charAt(j - 1))
//					L[i][j] = L[i - 1][j - 1] + 1;
//				else
//					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
//			}
//		}
//
//		// Following code is used to print LCS
//		int index = L[m][n];
//		int temp = index;
//
//		// Create a character array to store the lcs string
//		char[] lcs = new char[index + 1];
//		lcs[index] = '\u0000'; // Set the terminating character
//
//		// Start from the right-most-bottom-most corner and
//		// one by one store characters in lcs[]
//		int i = m;
//		int j = n;
//		while (i > 0 && j > 0) {
//			// If current character in X[] and Y are same, then
//			// current character is part of LCS
//			if (X.charAt(i - 1) == Y.charAt(j - 1)) {
//				// Put current character in result
//				lcs[index - 1] = X.charAt(i - 1);
//
//				// reduce values of i, j and index
//				i--;
//				j--;
//				index--;
//			}
//
//			// If not same, then find the larger of two and
//			// go in the direction of larger value
//			else if (L[i - 1][j] > L[i][j - 1])
//				i--;
//			else
//				j--;
//		}
//
//		// Print the lcs
//		System.out.print("LCS of " + X + " and " + Y + " is ");
//		for (int k = 0; k <= temp; k++)
//			System.out.print(lcs[k]);
//	}
	public Queue<Account> getSearchList() {
		return this.searchList;
	}

	public List<Statistics> getStatitical() {
		String sql = "SELECT createDate, count(*) FROM Account GROUP BY createDate";
		List<Statistics> list_ = new ArrayList<Statistics>();
		try (Connection conn = this.connect(this.path);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				list_.add(new Statistics(rs.getDate("createDate"), rs.getInt("count(*)")));
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list_;
	}

	// Bring the smallest value to the end
	public void insertIndexToRear(int min_index) {
		Account min_value = new Account("");
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			Account current = this.list.poll();
			if (i != min_index) {
				this.list.add(current);
			} else {
				min_value = current;
			}
		}
		this.list.add(min_value);
	}

	private void insertMaxToRearSearchList(int max_index) {
		Account max_value = new Account("");
		Float max_compare = Float.valueOf(0);
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			Account current = this.list.poll();
			Float current_ = this.compareList.poll();
			if (i != max_index) {
				this.list.add(current);
				this.compareList.add(current_);
			} else {
				max_value = current;
				max_compare = current_;
			}
		}
		this.list.add(max_value);
		this.compareList.add(max_compare);
	}

	private int lenghtOfLcs(String X, String Y) {
		int m = X.length(), n = Y.length();
		int[][] L = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					L[i][j] = L[i - 1][j - 1] + 1;
				} else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}

		return L[m][n];
	}

	private int maxIndex(int sortIndex) {
		int max_index = -1;
		Account max_value = new Account("!");
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			Account current = this.list.poll();

			if (stringCompare(current.getUsername(), max_value.getUsername()) >= 0 && i <= sortIndex) {
				max_index = i;
				max_value = current;
			}
			this.list.add(current);
		}
		return max_index;
	}

	private int maxIndexName(int sortIndex) {
		int max_index = -1;
		Account max_value = new Account("!", "!");
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			Account current = this.list.poll();

			if (stringCompare(current.getName(), max_value.getName()) >= 0 && i <= sortIndex) {
				max_index = i;
				max_value = current;
			}
			this.list.add(current);
		}
		return max_index;
	}

	private int maxIndexSearchList(int sortIndex) {
		int max_index = -1;
		Float max_value = Float.valueOf(0);
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			Float current = this.compareList.poll();

			if (Float.compare(max_value, current) <= 0 && i <= sortIndex) {
				max_index = i;
				max_value = current;
			}
			this.compareList.add(current);
		}
		return max_index;
	}

	// Returns the index of the smallest value on queue
	public int minIndex(int sortIndex) {
		int min_index = -1;
		Account min_value = new Account("zzzzzzzzzzzzzzzz");
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			Account current = this.list.poll();

			if (stringCompare(current.getUsername(), min_value.getUsername()) <= 0 && i <= sortIndex) {
				min_index = i;
				min_value = current;
			}
			this.list.add(current);
		}
		return min_index;
	}

	private int minIndexName(int sortIndex) {
		int min_index = -1;
		Account min_value = new Account("", "zzzzzzzzzzzzzzzz");
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			Account current = this.list.poll();
			String name1 = deAccent(current.getName());
			String name2 = deAccent(min_value.getName());
			if (stringCompare(name1, name2) <= 0 && i <= sortIndex) {
				min_index = i;
				min_value = current;
			}
			this.list.add(current);
		}
		return min_index;
	}

	private static String deAccent(String str) {
		str = str.replaceAll("đ", "d");
		str = str.replaceAll("Đ", "D");
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

	protected void readFile() {
		String sql = "SELECT * FROM Account";

		try (Connection conn = this.connect(this.path);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// loop through the result set
			while (rs.next()) {
				this.list.add(new Account(rs));
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		this.sortQueue();
	}

	public void searchByFullNameSort(String fullName) {
		this.compareList.clear();
		this.searchList.clear();
		Account temp;
		String tempFN;
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			temp = this.list.poll();
			tempFN = temp.getFullName();
			Float rank = Integer.valueOf(lenghtOfLcs(fullName, tempFN)).floatValue();
			this.compareList.add(rank / tempFN.length());
			this.list.add(temp);
		}
		sortBySearch();
		createSearchList();
	}

	public void searchByUsernameSort(String username) {
		this.compareList.clear();
		this.searchList.clear();
		Account temp;
		String tempU;
		int s = this.list.size();
		for (int i = 0; i < s; i++) {
			temp = this.list.poll();
			tempU = temp.getUsername();
			this.compareList.add(Integer.valueOf(lenghtOfLcs(username, tempU)).floatValue() / tempU.length());
			this.list.add(temp);
		}
		sortBySearch();
		createSearchList();
	}

	public void sortByNameAZ() {
		for (int i = 1; i <= this.list.size(); i++) {
			int min_index = minIndexName(this.list.size() - i);
			insertIndexToRear(min_index);
		}
	}

	public void sortByNameZA() {
		for (int i = 1; i <= this.list.size(); i++) {
			int max_index = maxIndexName(this.list.size() - i);
			insertIndexToRear(max_index);
		}
	}

	private void sortBySearch() {
		for (int i = 1; i <= this.list.size(); i++) {
			int max_index = maxIndexSearchList(this.list.size() - i);
			insertMaxToRearSearchList(max_index);
		}
	}

	public void sortByUsernameAZ() {
		for (int i = 1; i <= this.list.size(); i++) {
			int min_index = minIndex(this.list.size() - i);
			insertIndexToRear(min_index);
		}
	}

	public void sortByUsernameZA() {
		for (int i = 1; i <= this.list.size(); i++) {
			int max_index = maxIndex(this.list.size() - i);
			insertIndexToRear(max_index);
		}
	}

	public void sortQueue() {
		for (int i = 1; i <= this.list.size(); i++) {
			int min_index = minIndex(this.list.size() - i);
			insertIndexToRear(min_index);
		}
	}

	protected void writeFile(String path) {
		sortQueue();
		while (!this.list.isEmpty()) {
			this.list.poll().insert("Account.db");
		}
	}
}
