// NPTEL Getting Started With Competitive Programming
// 2023 Week 10 : Programming Assignment 2

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main (String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);

		// taking inputs
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

		// dp array for memoization
		int[] dp = new int[m + 1];
		
		for (int j = 1; j <= m; j++) {
			int mini = (int)1e8;
			for (int i = 0; i < n; i++)
				if (arr[i] > 0 && j - arr[i] >= 0)
					mini = Math.min(mini, 1 + dp[j - arr[i]]);
			dp[j] = mini;
		}

		// printing the answer
		int ans = dp[m];
		if (dp[m] == (int)1e8) ans = -1;
		System.out.print(ans);
	}

	// recursive solution was giving a Runtime Error...
	/*
	static int solve(int n, int m, int[] arr, int[] dp) {
		if (m == 0) return 0;
		if (m < 0) return (int)1e8;
		if (dp[m] != 0) return dp[m];
		
		int mini = (int)1e8;
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0)
				mini = Math.min(mini, 1 + solve(n, m - arr[i], arr, dp));
		}
		return dp[m] = mini;
	}
	*/
}