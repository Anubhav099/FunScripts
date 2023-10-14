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
		int n = sc.nextInt();
		String s = sc.next();

		int occupied = 0;
		int maxOcc = 0;
		int noOfWays = 0;
		int total = 0;

		for (char c: s.toCharArray()) {
			if (c == 'O') {
				total++;

			}
		}
		

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == 'O') {
				occupied++;
			}
			if (i >= total) {
				if (occupied > maxOcc) {
					maxOcc = occupied;
					noOfWays = 1;
				} else if (occupied == maxOcc) {
					noOfWays++;
				}
				if (s.charAt(i - total) == 'O') occupied--;
			}
		}

		int minMov = total - maxOcc;
		if (minMov == 0 || total == s.length()) {
			System.out.print("0 0");
			return;
		} else System.out.print(minMov + " " + noOfWays);
    }
}