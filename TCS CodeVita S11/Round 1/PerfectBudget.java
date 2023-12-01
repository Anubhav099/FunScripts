import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
// import java.util.concurrent.atomic.*;

public class Main {
	public static void main(String[] args) throws Exception{

		try {

			Scanner sc = new Scanner(System.in);

			int n = sc.nextInt();

			int mx = Integer.MIN_VALUE;
			int mn = Integer.MAX_VALUE;
			while (n-- > 0) {
				int cost = sc.nextInt();
				mx = Math.max(mx, cost);
				int bonus = sc.nextInt();
				int penalty = sc.nextInt();
				if (penalty < 0 && -penalty > bonus) penalty = -bonus;
				mn = Math.min(mn, bonus + penalty - cost);
			}
			System.out.print(mx - mn);
			
		} catch (Exception e) {
			System.out.print("");
		}
	}
}
