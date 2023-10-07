// Name of the problem - Dussehra
// NPTEL Getting Started With Competitive Programming
// 2023 Week 11 : Programming Assignment 1

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

			System.out.print(solve(arr, n));
			if (t != 0) System.out.println();
		}
	}
	private static int solve(int[] arr, int n) {
		int[] dp = new int[n];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] == arr[i]) {
					if (j == 0) {
						dp[i] = i + 1;
						break;
					}
					else dp[i] = Math.max(dp[i], dp[j - 1] + i - j + 1);
				}
			}
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}
		// System.out.println(Arrays.toString(dp));
		return dp[n - 1];
	}
}