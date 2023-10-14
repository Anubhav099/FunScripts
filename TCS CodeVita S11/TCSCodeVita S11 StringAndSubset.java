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
		long R = sc.nextLong();
		String s = sc.next();
		String[] strs = s.split(",");

		long sum = 0, next = 1, r = 1;
		int cnt = 0;
		while (sum + next < R) {
			cnt++;
			sum += next;
			next = nCr(n, r);
			r++;
		}
		sum++;

		int[] arr = new int[cnt + 1];
		for (int i = 0; i < cnt; i++) {
			arr[i] = i;
		}
		arr[arr.length - 1] = n;
		int ptr = arr.length - 2;
		while (sum < R) {
			while ((arr[ptr] != arr[ptr + 1] - 1) && (sum < R)) {
				arr[ptr]++;
				sum++;
			}
			ptr--;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(strs[arr[i]]);
			if (i != arr.length - 2) {
				System.out.print(",");
			}
		}
    }
	private static long nCr(long n, long r) {
		long ans = 1;
		for(long i = 0; i < r; i++){
			ans = ans * (n - i);
			ans = ans / (i + 1);
		}
		return ans;
	}
}