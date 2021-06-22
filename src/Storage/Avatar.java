package Storage;

import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Avatar {
	/**
	 * Connect to the test.db database
	 *
	 * @return the Connection object
	 */
	private static Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:Account.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public static void main(String[] args) {
		Avatar.updatePicture("fudio", "testPic.jpg");
		Avatar.readPictureToFile("fudi", "output.jpg");
//		ImageIcon a = new ImageIcon(Avatar.readPicture("fudi"), "description");
	}

	/**
	 * Read the file and returns the byte array
	 * 
	 * @param file
	 * @return the bytes of the file
	 */
	private static byte[] readFile(String file) {
		ByteArrayOutputStream bos = null;
		try {
			File f = new File(file);
			FileInputStream fis = new FileInputStream(f);
			byte[] buffer = new byte[1024];
			bos = new ByteArrayOutputStream();
			for (int len; (len = fis.read(buffer)) != -1;) {
				bos.write(buffer, 0, len);
			}
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e2) {
			System.err.println(e2.getMessage());
		}
		return bos != null ? bos.toByteArray() : null;
	}

	public static Image readPicture(String username) {
		Image image = null;
		// update sql
		String selectSQL = "SELECT avatar FROM Account WHERE username=?";
		ResultSet rs = null;
		FileOutputStream fos = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();

			InputStream input = rs.getBinaryStream("avatar");
			if (input != null) {
				image = ImageIO.read(input);
			}
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
				if (fos != null) {
					fos.close();
				}

			} catch (SQLException | IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return image;
	}

	/**
	 * read the picture file and insert into the material master table
	 *
	 * @param materialId
	 * @param filename
	 */
	public static void readPictureToFile(String username, String filename) {
		// update sql
		String selectSQL = "SELECT avatar FROM Account WHERE username=?";
		ResultSet rs = null;
		FileOutputStream fos = null;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = connect();
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();

			// write binary stream into file
			File file = new File(filename);
			fos = new FileOutputStream(file);

//			System.out.println("Writing BLOB to file " + file.getAbsolutePath());
			while (rs.next()) {
				InputStream input = rs.getBinaryStream("avatar");
				if (input != null) {
					byte[] buffer = new byte[1024];
					while (input.read(buffer) > 0) {
						fos.write(buffer);
					}
				}
			}
		} catch (SQLException | IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
				if (fos != null) {
					fos.close();
				}

			} catch (SQLException | IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Update picture for a specific material
	 *
	 * @param username
	 * @param filename
	 */
	public static void updatePicture(String username, String filename) {
		// update sql
		String updateSQL = "UPDATE Account " + "SET avatar = ? " + "WHERE username=?";

		try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {

			// set parameters
			pstmt.setBytes(1, readFile(filename));
			pstmt.setString(2, username);

			pstmt.executeUpdate();
//			System.out.println("Stored the file in the BLOB column.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public Avatar() {
	}
}
