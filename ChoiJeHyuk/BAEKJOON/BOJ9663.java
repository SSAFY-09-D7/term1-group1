package BOJ9663;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] map;
	static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		solve(0);
		System.out.println(answer);
	}

	private static void solve(int r) {
		// basis part
		if (r == N) {
			answer++;
		}

		// inductive part
		for (int c = 0; c < N; c++) {
			if (check(r, c)) {
				map[r][c] = 1;
				solve(r + 1);
				map[r][c] = 0;
			}
		}
	}

	// 좌상 , 상 , 우상 체크
	// 퀸이 있으면 false , 없으면 true
	private static boolean check(int r, int c) {
		// 상
		for (int i = 0; i < r; i++) {
			if (map[i][c] == 1)
				return false;
		}
		// 좌상
		for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] == 1)
				return false;
		}
		
		// 우상
		for (int i = r - 1, j = c + 1; i >= 0 && j < N; i--, j++) {
			if (map[i][j] == 1)
				return false;
		}
		
		// 다 확인하고 없으면 true
		return true;
	}

}