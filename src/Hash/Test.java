package Hash;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import at.favre.lib.crypto.bcrypt.BCrypt;

//https://github.com/patrickfav/bcrypt
public class Test {
	public static void main(String[] args) {
		String password = "1234";
		byte[] salt = { 12, 34, 75, 86, 96, 34, 1, 64, 85, 1, 4, 89, 65, 42, 89, 28 };
		System.out.println(Arrays.toString(salt));

		byte[] bcryptHashString = BCrypt.withDefaults().hash(12, salt, password.getBytes(StandardCharsets.UTF_8));
		// $2a$12$BAHJTk.g.S/T.OPXOQnXF.H260TIbIERyohOy7iH7qbR3Xcpivj42
		System.out.println(new String(bcryptHashString, StandardCharsets.UTF_8));

		BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
		System.out.println(result.verified);
	}
}
