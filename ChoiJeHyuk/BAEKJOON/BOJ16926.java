package boj16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < Math.min(N, M) / 2; i++) {
			for (int j = 0; j < R; j++) {
				turntable(arr, i);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void turntable(int[][] table, int i) {
		int temp = table[0 + i][0 + i];
		int startx = i;
		int endx = table[0].length - 1 - i;
		int starty = i;
		int endy = table.length - 1 - i;
		int x = startx;
		int y = starty;
		int flag = 0;

		while (true) {
			if (flag == 4) {
				break;
			}

			int nx = x + dx[flag];
			int ny = y + dy[flag];

			if (nx < startx || ny < starty || nx > endx || ny > endy) {
				flag++;
				continue;
			}

			table[y][x] = table[ny][nx];
			y = ny;
			x = nx;

		}
		table[starty+1][startx] = temp;
	}

}
