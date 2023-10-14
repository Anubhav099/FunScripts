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
		String lang = sc.next();
		lang = lang.toLowerCase();
		sc.nextLine();
		String seq = sc.nextLine();
		seq = seq.toLowerCase();
		int n = seq.length();

		HashMap<Character, Integer> ind = new HashMap<>();
		String str = "";
		if (valid(lang, ind)) {
			for (int i = 0; i < n; i++) {
				if (seq.charAt(i) == ' ') {
					System.out.print(" ");
					str = "";
					continue;
				}
				str += seq.charAt(i);
				if (i == n - 1 || seq.charAt(i + 1) == ' ') {
					System.out.print(solve(lang, str, ind));
				}
			}
		}
		else System.out.print("New Language Error");
	}
	private static String solve(String lang, String str, HashMap<Character, Integer> ind) {
		int n = lang.length();
		int m = str.length();
		int[] cnt = new int[n];
		for (int i = 0; i < m; i++) {
			char c = str.charAt(i);
			if (!ind.containsKey(c)) continue;
			cnt[ind.get(c)]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			while (cnt[i]-- != 0) sb.append(lang.charAt(i));
		}
		return sb.toString();
	}
	
	private static boolean valid(String lang, HashMap<Character, Integer> ind) {
		int n = lang.length();

		for (int i = 0; i < n; i++) {
			char c = lang.charAt(i);
			if (ind.containsKey(c)) return false;
			ind.put(c, i);
		}
		return true;
	}
}