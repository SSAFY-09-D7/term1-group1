package SWEA7465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, M;
	static int[] set;
	static int a, b;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			set = new int[N + 1];
			answer = 0;
			
			for (int i = 0; i < set.length; i++) {
				set[i] = i;
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());

				union(a, b);

			}
			for (int j = 1; j < set.length; j++) {
				if (set[j] == j) {
					answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);

		}
	}

	private static void union(int a, int b) {
		a = find_rep(a);
		b = find_rep(b);

		if (a != b) {
			set[a] = set[b];
		}
	}

	private static int find_rep(int org) {
		if (set[org] == org)
			return org;
		else
			return set[org] = find_rep(set[org]);

	}

}
