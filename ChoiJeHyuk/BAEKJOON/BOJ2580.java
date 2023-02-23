package BOJ2580;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;

	static ArrayList<Point> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];

		for (int r = 0; r < 9; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 9; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 0)
					list.add(new Point(r, c));
			}
		}

		solve(0);
	}

	// 리스트에 넣을때 이런식으로 넣기 연습
	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	private static void solve(int k) {
		// basis part
		if (k == list.size()) {
			print(map);
			System.exit(0);
		}

		// inductive part
		// 리스트에서 r값 c값 가져옴
		int r = list.get(k).r;
		int c = list.get(k).c;

		for (int i = 1; i <= 9; i++) {
			// 가지치기
			if (check(r, c, i)) {
				map[r][c] = i;
				solve(k + 1);
				map[r][c] = 0;
			}

		}
	}

	// 중복되는 값이 없으면 true , 있으면 false 
	private static boolean check(int r, int c, int index) {
		// 가로 세로 확인
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == index || map[i][c] == index)
				return false;
		}
		// 3*3 정사각형 확인 3으로 나눠주고 3을 곱해서 기준잡아줌
		int nr = (r / 3) * 3;
		int nc = (c / 3) * 3;
		for (int i = nr; i < nr + 3; i++) {
			for (int j = nc; j < nc + 3; j++) {
				if (map[i][j] == index)
					return false;
			}
		}
		// 없으면 true
		return true;
	}

	// 배열 출력 
	// 코드 길어지면 이런식으로도 짜보기
	private static void print(int[][] map) {
		for (int r = 0; r < 9; r++) {
			for (int c = 0; c < 9; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}
