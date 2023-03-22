package BOJ2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;               
		}
	}

	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int time;
	static int cz;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// print(map);

		bfs(0, 0);
		check();
	}

	private static void check() {
		cheeze();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				melt(i, j);
			}
		}
		time++;
		int end = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				end += map[i][j];
			}
		}
		// System.out.println(end);
		if (end == 0) {
			System.out.println(time);
			System.out.println(cz);
		} else {
			v = new boolean[N][M];
			bfs(0, 0);
			check();

		}

	}

	private static void cheeze() {
		cz = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					cz++;
				}
			}
		}
	}

	private static void melt(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[r][c] == 1 && v[nr][nc]) {
				map[r][c] = 0;
				break;
			}
		}
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		v[r][c] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
					v[nr][nc] = true;
					q.add(new Point(nr, nc));
				}
			}
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
