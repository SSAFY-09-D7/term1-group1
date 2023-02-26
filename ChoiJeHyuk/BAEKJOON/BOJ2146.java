package BOJ2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] v;
	static int cnt = 1;
	static int min = Integer.MAX_VALUE;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		v = new boolean[N][N];

		// 0은 바다 1은 육지
		// 가장 짧은 다리 설치
		// Math.min ( Math.abs(X1-X2) + Math.abs(Y1-Y2) )
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					bfs(i, j);

				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (map[r][c] != map[i][j] && map[i][j] != 0 && map[r][c] != 0) {
							min = Math.min((Math.abs(i - r) + Math.abs(j - c)), min);
							
						}
					}
				}
			}
		}
		System.out.println(min-1);

	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		v[r][c] = true;
		q.offer(new Point(r, c));
		map[r][c] = cnt;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					q.offer(new Point(nr, nc));
					map[nr][nc] = cnt;
				}

			}
		}
	}

}

