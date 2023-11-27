import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;
// import java.util.concurrent.atomic.*;

public class Main {
	static class Pair {
		int x, y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		try {

			Scanner sc = new Scanner(System.in);

			int r = sc.nextInt(), c = sc.nextInt();
			int[][] maze = new int[r][c];
			for (int i = 0; i < r; i++)
				for (int j = 0; j < c; j++)
					maze[i][j] = sc.nextInt();

			Pair start = new Pair(sc.nextInt(), sc.nextInt());
			Pair end = new Pair(sc.nextInt(), sc.nextInt());

			System.out.print(shortestPath(maze, r, c, start, end));
			
		} catch (Exception e) {
			System.out.print("STUCK");
		}
	}
	static String shortestPath(int[][] maze, int r, int c, Pair start, Pair end) {
		boolean[][] vis = new boolean[r][c];
		Pair ans =  dfs(start.x, start.y, 0, 0, 0, maze, vis, r, c, end.x, end.y);

		// System.out.println(ans.x + " " + ans.y);
		return ans.x == (int)1e9? "STUCK": Integer.toString(ans.x);
	}
	static Pair dfs(int x, int y, int dist, int count2, int count3, int[][] maze, boolean[][] vis, int r, int c, int endx, int endy) {
		if (x < 0 || y < 0 || x >= r || y >= c || vis[x][y] || maze[x][y] == 1 || count2 > 2)
			return new Pair((int)1e9, (int)1e9);
		if (x == endx && y == endy) return new Pair(dist, count3);

		if (maze[x][y] == 2) count2++;
		else if (maze[x][y] == 3) count3++;
		dist++;

		vis[x][y] = true;

		Pair ans = dfs(x + 1, y, dist, count2, count3, maze, vis, r, c, endx, endy);
		Pair b = dfs(x, y + 1, dist, count2, count3, maze, vis, r, c, endx, endy);
		if (b.y < ans.y) ans = b;
		else if (b.y == ans.y && b.x < ans.x) ans = b;
		b = dfs(x - 1, y, dist, count2, count3, maze, vis, r, c, endx, endy);
		if (b.y < ans.y) ans = b;
		else if (b.y == ans.y && b.x < ans.x) ans = b;
		b = dfs(x, y - 1, dist, count2, count3, maze, vis, r, c, endx, endy);
		if (b.y < ans.y) ans = b;
		else if (b.y == ans.y && b.x < ans.x) ans = b;

		vis[x][y] = false;

		return ans;
	}
}
