import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
// import java.util.concurrent.atomic.*;

public class Main {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
		System.out.println(solve(arr, n));
	}
	static int solve(int[] arr, int n) {
		int stepsRequiredInAsc = ascBubbleSort(Arrays.copyOf(arr, n), n);
		int stepsRequiredInDesc = descBubbleSort(arr, n);

		// System.out.println(stepsRequiredInAsc + " " + stepsRequiredInDesc);
		return Math.min(stepsRequiredInAsc, stepsRequiredInDesc);
	}
	static int ascBubbleSort(int[] arr, int n) {
		int steps = 0;
		for (int i = 0; i < n; i++) {
			int swapped = 0;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j + 1] < arr[j]) {
					swap(arr, j, j + 1);
					swapped++;
				}
			}
			steps += swapped;
		}
		return steps;
	}
	static int descBubbleSort(int[] arr, int n) {
		int steps = 0;
		for (int i = 0; i < n; i++) {
			int swapped = 0;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j + 1] > arr[j]) {
					swap(arr, j, j + 1);
					swapped++;
				}
			}
			steps += swapped;
		}
		return steps;
	}
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
	}
}
