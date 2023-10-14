import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.concurrent.atomic.*;

public class Main {
	public static class Pair {
		int val, moveTo;
		public Pair(int val, int moveTo) {
			this.val = val;
			this.moveTo = moveTo;
		}
	}
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		// System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print(solve(arr, n));
	}
	private static int solve(int[] arr, int n) {
		Pair[] left = new Pair[n];
		Pair[] right = new Pair[n];
		int cur = 0;
		int lastPickedInd = -1;
		for (int i = 0; i < n; i++) {
			if (cur < 0) {
				cur = 0;
				lastPickedInd = i - 1;
			}
			if (arr[i] >= 0) cur += arr[i];
			else {
				cur = arr[i];
				lastPickedInd = i - 1;
			}
			right[i] = new Pair(cur, lastPickedInd);
		}
		cur = 0;
		lastPickedInd = n;
		for (int i = n - 1; i >= 0; i--) {
			if (cur < 0) {
				cur = 0;
				lastPickedInd = i + 1;
			}
			if (arr[i] >= 0) cur += arr[i];
			else {
				cur = arr[i];
				lastPickedInd = i + 1;
			}
			left[i] = new Pair(cur, lastPickedInd);
		}

		int l = 0, r = n - 1;
		int diff = 0;
		boolean team1 = false;
		while (l <= r) {
			team1 = !team1;
			if (left[l].val > right[r].val) {
				if (team1) diff += left[l].val;
				else diff -= left[l].val;
				l = left[l].moveTo;
			} else {
				if (team1) diff += right[r].val;
				else diff -= right[r].val;
				r = right[r].moveTo;
			}
		}
		return Math.abs(diff);
	}
}