package boj4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int[] dr = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, 1, -1, 1, -1, 1, -1 };
	static int[][] map;
	static int w,h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {		
			StringTokenizer st = new StringTokenizer(br.readLine());
			// [h][w]
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];
			if(w==0 && h == 0) {
				break;
			}
			// 1땅 0바다
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			System.out.println(cnt);
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
		boolean[][] v = new boolean[h][w];
		v[r][c] = true;

		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			map[p.r][p.c] = 0;
			for (int d = 0; d < 8; d++) {
				int nr = p.r + dr[d]; // 상하
				int nc = p.c + dc[d]; // 좌우
				if (nr >= 0 && nr < h && nc >= 0 && nc < w && !v[nr][nc] && map[nr][nc] == 1) {
					v[nr][nc] = true;
					Q.add(new Point(nr, nc));
					
				}
			}
		}
	}



}
