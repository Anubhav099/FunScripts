import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FindPermWhereAdjacentPerfectSquare {
	static AtomicInteger found = new AtomicInteger(0);
	public static void main (String[] args) throws java.lang.Exception {
		System.out.println("Trying to find all possible permutation of numbers ranging from 1 to 'n', such that \n1> every circularly adjacent pair of numbers is a perfect square and \n2> every number appears only once. \n");
		// oneOfTheValidAnswers: [17, 19, 30, 6, 3, 13, 12, 24, 25, 11, 5, 31, 18, 7, 29, 20, 16, 9, 27, 22, 14, 2, 23, 26, 10, 15, 1, 8, 28, 21, 4, 32]
		
		Scanner sc = new Scanner(System.in);

		while (found.get() == 0) {
			System.out.println("Enter the number of numbers to permute: ");
			int n = sc.nextInt();

			int[] arr = new int[n];
			for (int i = 1; i <= n; i++)
				arr[i - 1] = i;

			permute(0, arr);

			if (found.get() != 0) System.out.println("\nTotal " + found.get() + " solutions found for " + n + " numbers. Every circularly adjacent pair of numbers is a perfect square.");
			else System.out.println(":( No solution found for " + n + " numbers! Try another number. \n");
		}
    }
	private static void permute(int ind, int[] arr)
	{
		if (ind == arr.length) {
			if (isPerfectSquare(arr[0] + arr[arr.length - 1])) {
				found.set(found.get() + 1);
				System.out.println(Arrays.toString(arr));
			}
			return;
		}
		for (int i = ind; i < arr.length; i++)
		{
			swap(arr, i, ind);
			if (ind == 0 || (ind > 0 && isPerfectSquare(arr[ind] + arr[ind - 1])))
				permute(ind + 1, arr);
			swap(arr, i, ind);
		}
	}

	private static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i] ;
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static boolean isPerfectSquare(int n) {
		int sqrt = (int) Math.sqrt(n);
		return sqrt * sqrt == n;
	}
}