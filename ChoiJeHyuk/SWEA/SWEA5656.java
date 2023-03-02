package SWEA5656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 구슬은 N번 쏠 수 있고 벽돌들의 정보 W x H
 */
public class Solution {

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int N, W, H;
	static int[][] map;
	static int answer;
	static int[][] play;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[] sel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 구슬의 수
			W = Integer.parseInt(st.nextToken()); // 가로길이
			H = Integer.parseInt(st.nextToken()); // 세로길이

			map = new int[H][W];
			play = new int[H][W];
			answer = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// print(map);
			sel = new int[N];
			permutation(0);
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void permutation(int k) {
		// basis part
		if (k == N) {
			copy(); // 배열 복사
			start(); // 벽돌깨기 시작
			int temp = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (play[i][j] != 0) {
						temp++;
					}
				}
			}
			answer = Math.min(answer, temp); // 최소값
			return;
		}

		// inductive part
		// 구슬을 떨어트리는 여러가지 순서 // 중복순열
		for (int i = 0; i < W; i++) {
			sel[k] = i;
			permutation(k + 1);
		}

	}

	// 구슬 떨어트릴 배열 복사
	private static void copy() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				play[i][j] = map[i][j];
			}
		}
	}

	// 제일 위에있는 벽돌찾기
	private static void start() {
		// N개 중복순열
		for (int i = 0; i < sel.length; i++) {
			for (int j = 0; j < H; j++) {
				if (play[j][sel[i]] != 0) { // 행을 내리면서 0이 아닌곳 찾기
					boom(j, sel[i], play[j][sel[i]]); // 벽돌을 만났을때 부수기
					down(); // 벽돌을 부순 후 아래로 내려주기
					break;
				}
			}
		}
	}

	private static void down() {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < W; i++) { // 열
			for (int j = 0; j < H; j++) { // 행
				if (play[j][i] != 0) { // 0이 아닌부분 스택에 넣어주기
					stack.push(play[j][i]);
					play[j][i] = 0;
				}
			}

			for (int j = H - 1; j >= 0; j--) { // 배열의 뒤부터 값 넣어주기
				if (stack.size() == 0) { // 스택이 비면 다음 열로
					break;
				}
				play[j][i] = stack.pop();
			}

		}
	}

	private static void boom(int x, int y, int idx) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, idx));
		play[x][y] = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();

			// 값만큼 사방탐색하면서 0으로 만들기
			for (int i = 0; i < p.cnt; i++) {
				// 사방탐색
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d] * i;
					int nc = p.c + dc[d] * i;
					if (nr >= 0 && nr < H && nc >= 0 && nc < W && play[nr][nc] != 0) {
						q.offer(new Point(nr, nc, play[nr][nc]));
						play[nr][nc] = 0;

					}
				}
			}
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
