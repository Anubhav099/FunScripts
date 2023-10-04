// Name of the problem - Mysterious Jack Pot
// NPTEL Getting Started With Competitive Programming
// 2023 Week 10 : Programming Assignment 1

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			System.out.print(solve(sc.nextInt()));
			if (t > 0)
				System.out.println();
		}
	}
	static int solve(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int min = (int)1e7; // 10^7
			for (int j = i - 1; j >= 2; j--)
				if (i % j == 0)
					min = Math.min(min, dp[(i / j)] + 2 * (j - 1));
			min += 4;
			dp[i] = Math.min(min, dp[i - 1] + 1);
		}
		// System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}