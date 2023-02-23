package swea1861;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] map;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int mini = Integer.MAX_VALUE;
	static int minj = Integer.MAX_VALUE;
	static int temp = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int max = 0;
			int num = Integer.MAX_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0; j < N ; j ++) {
					temp = 1;
					bfs(i, j);
					if((max == temp && min > num) || max < temp) {
						max = temp;						
						num = map[i][j];						

					}

				}
				
			}
			System.out.println("#" + tc + " "  + min + " " + max);
			//System.out.println("#" + tc + " "  +mini+ " " + minj + " " + max);
			//System.out.println("tmp : " +temp);
		}

	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static void bfs(int r, int c) {

		Queue<Point> Q = new LinkedList<>();
		boolean[][] v = new boolean[N][N];
		v[r][c] = true;

		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			// map[p.r][p.c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == map[p.r][p.c]+1 ) {
					v[nr][nc] = true;
					Q.add(new Point(nr, nc));
					temp++; // 방갯수
				}
				
			}
		}
	}
}
