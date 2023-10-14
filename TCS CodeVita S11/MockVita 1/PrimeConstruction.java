import java.util.*;
import java.lang.*;

public class HelloWorld {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		List<Long> li = new ArrayList<>();
		long q = Long.MAX_VALUE;
		while (sc.hasNext()) {
			long curNum = sc.nextLong();
			q = Math.min(q, curNum);
			li.add(curNum);
		}
		long potentialP = calcLCM(li, q);
		potentialP += q;

		String message = "None";
		if (isPrime(potentialP)) message = "" + potentialP;
		System.out.print(message);
	}

	private static boolean isPrime(long num) {
		if (num < 2) return false;
		if (num % 2 == 0 || num % 3 == 0) return false;
		for (int i = 5; i <= Math.sqrt(num) + 1; i += 6) {
			if (num % (i) == 0 || num % (i + 2) == 0) return false;
		}
		return true;
	}

	private static long calcLCM(List<Long> li, long q) {
		int n = li.size();
		int ind = 0;
		long res = -1;
		for (int i = 0; i < n; i++) {
			if (li.get(i) != q) {
				res = li.get(i);
				ind = i;
				break;
			}
		}
		for (int i = ind + 1; i < n; i++) {
			if (li.get(i) == q) continue;
			res = (res * li.get(i)) / gcd(li.get(i), res);
		}
		return res;
	}

	private static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}