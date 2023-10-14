import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.concurrent.atomic.*;

public class Main {
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		// System.setOut(new PrintStream(new FileOutputStream("output.txt")));

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String actions = sc.nextLine();

		System.out.print(solve(str, actions));
	}
	private static String solve(String input, String acts) {
		int n = input.length();

		StringBuilder str = new StringBuilder(input);
		int i = 0;
		for (int j = 0; j < acts.length(); j++) {
			char c = acts.charAt(j);
			if (c == 'L') {
				if (i > 0) i--;
			} else if (c == 'R') {
				if (i < n - 1) i++;
			} else if (c == 'T') {
				if (str.charAt(i) >= '0' && str.charAt(i) <= '8') {
					str.setCharAt(i, (char)(str.charAt(i) + 1));
				}
			} else if (c == 'D') {
				if (str.charAt(i) >= '1' && str.charAt(i) <= '9') {
					str.setCharAt(i, (char)(str.charAt(i) - 1));
				}
			} else if (c == 'S') {
				j++;
				int ind = acts.charAt(j) - '1';
				char temp = str.charAt(i);
				str.setCharAt(i, str.charAt(ind));
				str.setCharAt(ind, temp);
			}
		}
		return str.toString();
	}
}