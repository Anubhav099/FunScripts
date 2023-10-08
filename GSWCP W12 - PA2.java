// Name of the problem - (longest common subsequence)
// NPTEL Getting Started With Competitive Programming
// 2023 Week 12 : Programming Assignment 2

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Main {
	public static void main(String[] arrrrrrrrrrgs) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		System.out.print(solve(a, b));
	}
	private static int solve(String a, String b) {
		int A = a.length();
		int B = b.length();
		int[][] dp = new int[A + 1][B + 1];

		for (int i = 1; i <= A; i++) {
			for (int j = 1; j <= B; j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[A][B];
	}
}