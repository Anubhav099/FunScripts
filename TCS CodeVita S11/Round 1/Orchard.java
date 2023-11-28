import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
// import java.util.concurrent.atomic.*;

public class Main {
	public static void main(String[] args) throws Exception{
		try {
			Scanner sc = new Scanner(System.in);

			String a, b;

			a = sc.next();
			b = sc.next();
			boolean invalid = false;
			for (char c: a.toCharArray()) if (c != 'M' && c != 'L') invalid = true;
			for (char c: b.toCharArray()) if (c != 'M' && c != 'L') invalid = true;

			if (invalid) System.out.print("Invalid input");
			else System.out.print(result(a, b));
		} catch (Exception e) {
			System.out.print("Invalid input");
			return;
		}
	}
	static String result(String a, String b) {
		int[][][] dp = new int[Math.max(a.length(), b.length())][3][2];

		for (int i = 0; i < a.length(); i++) for (int j = 0; j < 3; j++) for (int k = 0; k < 2; k++) dp[i][j][k] = -1;
		int askhoksPoint = perm(a.length() - 1, a, 2, '\0', dp);

		for (int i = 0; i < b.length(); i++) for (int j = 0; j < 3; j++) for (int k = 0; k < 2; k++) dp[i][j][k] = -1;
		int anandsPoint = perm(b.length() - 1, b, 2, '\0', dp);

		// System.out.println(askhoksPoint + " " + anandsPoint);
		return askhoksPoint > anandsPoint ? "Ashok" : anandsPoint > askhoksPoint ? "Anand" : "Draw";
	}
	static int perm(int ind, String s, int len, char prev, int[][][] dp) {
		if (len == -1) return 1;
		if (ind == -1) return 0;
		int ch = prev == 'M' ? 0 : 1;
		if (dp[ind][len][ch] != -1) return dp[ind][len][ch];

		int count = 0;
		if (s.charAt(ind) != prev)
			count += perm(ind - 1, s, len - 1, s.charAt(ind), dp);
		count += perm(ind - 1, s, len, prev, dp);

		return dp[ind][len][ch] = count;
	}
}
