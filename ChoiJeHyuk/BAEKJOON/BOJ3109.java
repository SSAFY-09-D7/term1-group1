package BOJ3109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static int Ans = 0;
	// 우상 , 우 , 우하
	// 맨위부터 탐색하므로 최적의 경로가 나옴
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int r = 0; r < R; r++) {
			String str = br.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}

		for (int r = 0; r < R; r++) {
			flag = false;
			solve(r, 0);
		}
		System.out.println(Ans);
	}

	private static void solve(int r, int c) {
		// 속도 향상 부분
		if (flag) {
			return;
		}

		if (c == C - 1) {
			Ans++;
			flag = true;
			return;
		}

		// inductive part
		for (int d = 0; d < 3; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.' && !flag) {
				map[nr][nc] = 'x';
				solve(nr, nc);

			}
		}
	}

}
