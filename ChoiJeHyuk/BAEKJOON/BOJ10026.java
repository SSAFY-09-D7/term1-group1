package BOJ10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][] mapB;
	static boolean[][] v;
	static int red, green, blue;
	static int answer = 0;
	static int color;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Point {
		int r;
		int c;
		int check;

		public Point(int r, int c, int check) {
			super();
			this.r = r;
			this.c = c;
			this.check = check;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		mapB = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				if (s[j].equals("R")) {
					map[i][j] = 0;
				} else if (s[j].equals("G")) {
					map[i][j] = 1;
				} else if (s[j].equals("B")) {
					map[i][j] = 2;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				mapB[i][j] = map[i][j];
			}
		}

		
		red = 0;
		green = 0;
		blue = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					red++;
					bfs(i, j, 0);
				} else if (map[i][j] == 1) {
					green++;
					bfs(i, j, 0);
				} else if (map[i][j] == 2) {
					blue++;
					bfs(i, j, 0);
				}
			}
		}
		answer = red + green + blue;
		sb.append(answer + " ");
		
		answer = 0;
		red = 0;
		green = 0;
		blue = 0;
		map = mapB;
		v = new boolean[N][N];
		
		trans();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					red++;
					bfs(i, j, 1);
				} else if (map[i][j] == 1) {
					green++;
					bfs(i, j, 1);
				} else if (map[i][j] == 2) {
					blue++;
					bfs(i, j, 1);
				}
			}
		}
		answer = red + green + blue;
		
		sb.append(answer);
		System.out.println(sb);

	}

	private static void bfs(int r, int c, int check) {
		Queue<Point> q = new LinkedList<>();
		v[r][c] = true;
		q.offer(new Point(r, c, check));
		color = map[r][c];
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			map[p.r][p.c] = -1;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == color) {
					v[nr][nc] = true;
					q.offer(new Point(nr, nc, check));
				}
			}
		}

	}

	private static void trans() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 0;
					color = 0;
				}
			}
		}
	}

}
