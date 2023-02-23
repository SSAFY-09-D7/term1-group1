package boj2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N;
	static int[][] map;
	static ArrayList<Integer> answer = new ArrayList<>();
	static int home;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				String[] s = str.split("");
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					cnt++;
					bfs(i, j);
					answer.add(home + 1);
					home = 0;
				}
			}
		}

		System.out.println(cnt);
		Collections.sort(answer);
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
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
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[N][N];
		v[r][c] = true;

		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = 0;
			for (int d = 0; d < 4; d++) {
				int nr = p.r + dr[d]; // 상하
				int nc = p.c + dc[d]; // 좌우
				if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					Q.add(new Point(nr, nc));
					home++;
				}
			}
		}
	}

}