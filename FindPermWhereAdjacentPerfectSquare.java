import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FindPermWhereAdjacentPerfectSquare {
	public static void main (String[] args) throws java.lang.Exception {
		System.out.println("Trying to find all possible permutation of numbers ranging from 1 to 'n', such that \n1> every circularly adjacent pair of numbers is a perfect square and \n2> every number appears only once. \n");
		// oneOfTheValidAnswers: [17, 19, 30, 6, 3, 13, 12, 24, 25, 11, 5, 31, 18, 7, 29, 20, 16, 9, 27, 22, 14, 2, 23, 26, 10, 15, 1, 8, 28, 21, 4, 32]
		
		Scanner sc = new Scanner(System.in);
		int noOfSolFound = 0;

		while (noOfSolFound == 0) {
			System.out.println("Enter the number of numbers to permute: ");
			int n = sc.nextInt();
			if (n > 40) {
				System.out.println(":O Range of number might be too big! Try something < 40.\n");
				continue;
			}
			int[] arr = new int[n];
			for (int i = 1; i <= n; i++)
				arr[i - 1] = i;

			noOfSolFound = permute(0, arr);

			if (noOfSolFound != 0) System.out.println("\nTotal " + noOfSolFound + " solutions found for " + n + " numbers. Every circularly adjacent pair of numbers is a perfect square.");
			else System.out.println(":( No solution found for " + n + " numbers! Try another number. \n(Hint: Enter a number greater than 31)\n");
		}
    }
	private static int permute(int ind, int[] arr)
	{
		if (ind == arr.length) {
			if (isPerfectSquare(arr[0] + arr[arr.length - 1])) {
				System.out.println(Arrays.toString(arr));
				return 1;
			}
			return 0;
		}
		int found = 0;
		for (int i = ind; i < arr.length; i++)
		{
			swap(arr, i, ind);
			if (ind == 0 || (ind > 0 && isPerfectSquare(arr[ind] + arr[ind - 1])))
				found += permute(ind + 1, arr);
			swap(arr, i, ind);
		}
		return found;
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