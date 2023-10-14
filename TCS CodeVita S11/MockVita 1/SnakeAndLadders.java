import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
// import java.util.concurrent.atomic.*;

public class Main {
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		// System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		Scanner sc = new Scanner(System.in);
		
		boolean rev = true;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 9; i >= 0; i--) {
			String inputLine = sc.nextLine();
			String[] input = inputLine.split(" ");
			if (rev) {
				int cnt = i * 10 + 1;
				for (int j = 9; j >= 0; j--) {
					String cur = input[j];
					if (cur.charAt(0) == 'S' || cur.charAt(0) == 'L') {
						String toGo = cur.substring(2, cur.length() - 1);
						int dest = -1;
						if (toGo.equals("Start")) dest = 1;
						else if (toGo.equals("End")) dest = 100;
						else dest = Integer.parseInt(toGo);

						map.put(cnt, dest);
					}
					cnt++;
				}
			} else {
				int cnt = i * 10 + 1;
				for (int j = 0; j <= 9; j++) {
					String cur = input[j];
					if ((cur.charAt(0) == 'S' || cur.charAt(0) == 'L') && !cur.equals("Start")) {
						String toGo = cur.substring(2, cur.length() - 1);
						int dest = -1;
						if (toGo.equals("Start")) dest = 1;
						else if (toGo.equals("End")) dest = 100;
						else dest = Integer.parseInt(toGo);

						map.put(cnt, dest);
					}
					cnt++;
				}
			}
			rev = !rev;
		}
		// System.out.println(map);


		List<Integer> dieVals = new ArrayList<>();
		while (sc.hasNext()) {
			int die = sc.nextInt();
			dieVals.add(die);
		}
		// System.out.println(dieVals);


		int curPos = 0;
		int noOfSnakes = 0;
		int noOfLadders = 0;
		for (int i: dieVals) {
			if (curPos == 100) break;
			int newPos = curPos + i;
			if (newPos > 100) continue;
			while (map.containsKey(newPos)) {
				int old = newPos;
				newPos = map.get(newPos);
				if (newPos > old) noOfLadders++;
				else noOfSnakes++;
			}
			curPos = newPos;
		}
		if (curPos != 100) System.out.print("Not possible " + noOfSnakes + " " + noOfLadders + " " + curPos);
		else System.out.print("Possible " + noOfSnakes + " " + noOfLadders);
	}
}