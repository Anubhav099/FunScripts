import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
// import java.util.concurrent.atomic.*;

public class Main {
	public static class Pair<F, S> {
		private F first;
		private S second;

		public Pair(F first, S second) {
			this.first = first;
			this.second = second;
		}

		public F first() {
			return first;
		}

		public S second() {
			return second;
		}
	}
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		// System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
		System.out.println(solve(arr, n));
	}
	static int solve(int[] arr, int n) {
		int[] left = new int[n];
		Stack<Pair<Integer, Integer>> stk = new Stack<>();
		for (int i = 0; i < n; i++) {
			int curNum = arr[i];
			while (!stk.isEmpty() && stk.peek().first <= curNum) stk.pop();

			if (stk.isEmpty()) left[i] = 0;
			else left[i] = stk.peek().second;

			stk.push(new Pair<Integer, Integer>(curNum, i));
		}
		int[] right = new int[n];
		stk.clear();
		for (int i = n - 1; i >= 0; i--) {
			int curNum = arr[i];
			while (!stk.isEmpty() && stk.peek().first <= curNum) stk.pop();

			if (stk.isEmpty()) right[i] = 0;
			else right[i] = stk.peek().second;
			
			stk.push(new Pair<Integer, Integer>(curNum, i));
		}
		// System.out.println(Arrays.toString(arr));
		// System.out.println(Arrays.toString(left));
		// System.out.println(Arrays.toString(right));
		int maxIndexProd = 0;
		for (int i = 0; i < n; i++) {
			maxIndexProd = Math.max(maxIndexProd, right[i] * left[i]);
		}
		return maxIndexProd;
	}
}
