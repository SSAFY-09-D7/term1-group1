package BOJ13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static List<Integer>[] list;
	static boolean[] v;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		v = new boolean[N];
		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// map[a][b] = map[b][a] = 1;
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 0; i < list.length; i++) {
			v[i] = true;
			dfs(i, 0);
			v[i] = false;


		}
		System.out.println(0);

	}

	private static void dfs(int start, int cnt) {
		if (cnt == 4) {
			System.out.println(1);
			System.exit(0);
		}

		List<Integer> nexts = list[start];
		for (int i = 0; i < nexts.size(); i++) {
			if (!v[nexts.get(i)]) {
				v[nexts.get(i)] = true;
				dfs(nexts.get(i), cnt + 1);
				v[nexts.get(i)] = false;
			}
		}
	}

}
