// Name of the problem - Shrek's Dungeon
// NPTEL Getting Started With Competitive Programming
// 2023 Week 11 : Programming Assignment 2

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

		System.out.println(solve(arr, n));
	}
	private static int solve(int[] arr, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] >= i - j) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
	}
}