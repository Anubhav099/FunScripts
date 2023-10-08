// Name of the problem - Scheduling
// NPTEL Getting Started With Competitive Programming
// 2023 Week 12 : Programming Assignment 1

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Main {
	public static void main(String[] arrrrrrrrrrgs) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		// System.setOut(new PrintStream(new FileOutputStream("output.txt")));

		Scanner sc = new Scanner(System.in);
		int noOfDays = sc.nextInt();
		int noOfHrs = sc.nextInt();
		int lessonsToSkip = sc.nextInt();

		List<List<Integer>> day = new ArrayList<>();
		for (int i = 0; i < noOfDays; i++) {
			String curDay = sc.next();
			List<Integer> lessons = new ArrayList<>();
			for (int j = 0; j < noOfHrs; j++)
				if (curDay.charAt(j) == '1') 
					lessons.add(j);
			day.add(lessons);
		}
		// for (List<Integer> l: day)
		// 	System.out.println(l);
		System.out.print(solve(day, noOfDays, lessonsToSkip));
	}
	
	// RECSURSIVE APPROACH
	private static int solve(List<List<Integer>> day, int noOfDays, int lessonsToSkip) {
		int[][] dp = new int[noOfDays][lessonsToSkip + 1];
		for (int[] row: dp) Arrays.fill(row, -1);
		return solve(0, day, noOfDays, lessonsToSkip, dp);
	}
	// returns ans -> minimum number of hours to spend in the university
	private static int solve(int curDay, List<List<Integer>> day, int n, int k, int[][] dp) {
		if (curDay == n) return 0;

		if (dp[curDay][k] != -1) return dp[curDay][k];

		List<Integer> todaysPlan = day.get(curDay);
		int ans = (int)1e8;
		int noOfLessonsToday = todaysPlan.size();
		for (int i = 0; i < noOfLessonsToday; i++)
			for (int j = i; j < noOfLessonsToday; j++) {
				int hrsToAttendToday = todaysPlan.get(j) - todaysPlan.get(i) + 1;
				int lecturesToSkip = noOfLessonsToday - (j - i + 1);
				if (k - lecturesToSkip >= 0)
					ans = Math.min(ans, hrsToAttendToday + solve(curDay + 1, day, n, k - lecturesToSkip, dp));
			}
		if(k - noOfLessonsToday >= 0) ans = Math.min(ans, solve(curDay + 1, day, n, k - noOfLessonsToday, dp));

		return dp[curDay][k] = ans;
	}
}



// Tabulation:
private static int solve(List<List<Integer>> day, int noOfDays, int lessonsToSkip) {
	int[][] dp = new int[noOfDays + 1][lessonsToSkip + 1];

	for (int curDay = noOfDays - 1; curDay >= 0; curDay--) {
		for (int k = 0; k <= lessonsToSkip; k++) {
			List<Integer> todaysPlan = day.get(curDay);
			int ans = (int)1e8;
			int noOfLessonsToday = todaysPlan.size();
			for (int i = 0; i < noOfLessonsToday; i++)
				for (int j = i; j < noOfLessonsToday; j++) {
					int hrsToAttendToday = todaysPlan.get(j) - todaysPlan.get(i) + 1;
					int lecturesToSkip = noOfLessonsToday - (j - i + 1);
					if (k - lecturesToSkip >= 0) ans = Math.min(ans, hrsToAttendToday + dp[curDay + 1][k - lecturesToSkip]);
				}
			if(k - noOfLessonsToday >= 0) ans = Math.min(ans, dp[curDay + 1][k - noOfLessonsToday]);

			dp[curDay][k] = ans;
		}
	}
	// System.out.println(Arrays.deepToString(dp));
	return dp[0][lessonsToSkip];
}