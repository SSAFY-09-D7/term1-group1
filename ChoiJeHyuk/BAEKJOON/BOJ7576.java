package BOJ7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *  종료조건 해결 x
 *  
 */
public class Main {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] tomato;
	// static boolean[][] v;
	static int M, N;
	static int cnt;
	static int answer;
	static Queue<Point> Q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 안들어있는 칸
		// [N][M]
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int[N][M];
		Q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 익은 토마토를 발견하면 주변 토마토를 1로 만들고
		// 1로 바뀐 토마토는 또 주변을 1로 만들고
		// 안익은 토마토가 없으면 종료
		// 토마토가 모두 못익는 상황이면 -1
		// 배열 모든값이 1이면 0출력

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) {
					Q.add(new Point(i,j));

				}
			}
		}
		bfs();
		
		answer -= 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0)
					answer = -1;
			}
		}
		System.out.println(answer);
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	private static void bfs() {
	
		// boolean[][] v = new boolean[N][M];
		// v[r][c] = true;

		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i < size; i++) {

				Point p = Q.poll();
				// tomato[p.r][p.c] = 1;
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M && tomato[nr][nc] == 0) {
						// v[nr][nc] = true;
						tomato[nr][nc] = 1;
						Q.add(new Point(nr, nc));

					}
//				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && tomato[nr][nc] == -1) {
//					v[nr][nc] = true;
//					tomato[nr][nc] = 1;
//					Q.add(new Point(nr, nc));
//
//				}
				}
			}
			answer++;
		}
	}

}
