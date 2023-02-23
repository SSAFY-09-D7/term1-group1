package BOJ1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static int[][] map;
	static boolean[] v;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		v = new boolean[26];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 0);
		System.out.println(answer);
	}

	private static void dfs(int r, int c, int cnt) {
		if (v[map[r][c]] == true) {
			answer = Math.max(answer, cnt);
			return;
		}

		v[map[r][c]] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				dfs(nr, nc, cnt + 1);
			}
		}
		v[map[r][c]] = false;
	}

}
