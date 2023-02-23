package BOJ1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static boolean v[];

	static class Point {
		int n;
		int cnt;

		public Point(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();

	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(N, 0));
		v = new boolean[100001];
		while (!q.isEmpty()) {
			Point p = q.poll();
			int pn = p.n;
			if (pn == K) {
				System.out.println(p.cnt);
				return;
			}
			for (int i = 0; i < 3; i++) {
				pn = 0;
				if (i == 0) {
					pn = p.n * 2;				
				} else if (i == 1) {
					pn = p.n + 1;					
				} else if (i == 2) {
					pn = p.n - 1;					
				}
				if (pn >= 0 && pn < 100001 && !v[pn]) {
					q.offer(new Point(pn, p.cnt + 1));
					v[pn] = true;
				}

			}

		}
	}

}
