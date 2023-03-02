package BOJ17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, E;
	static ArrayList<Integer>[] adj;
	static boolean[] v;
	// static int[][] map;
	static int[] population;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];
		population = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < num; j++) {
				int b = Integer.parseInt(st.nextToken());
				adj[i].add(b);
				//adj[b].add(i);
			}

		}
		v = new boolean[N + 1];

		recursive(1);
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	// 방문배열 v가 돌면서 부분집합으로  A선거구를 나눔
	private static void recursive(int idx) {
		// 부분집합
		if (idx == N + 1) {
			if (check()) { // 연결되어 있는지 확인
				int A = 0, B = 0;
				for (int i = 1; i <= N; i++) {
					if (v[i])
						A += population[i];
					else
						B += population[i];
				}

				answer = Math.min(answer, Math.abs(A - B));
			}
			return;
		}
		v[idx] = true;
		recursive(idx + 1);
		v[idx] = false;
		recursive(idx + 1);
	}

	private static boolean check() {
		boolean[] visited = new boolean[N + 1];
		
		int checkA = 0;
		int checkB = 0;
		// A구역
		for (int i = 1; i <= N; i++) {
			if(v[i]) {
				checkA = i;
				break;
			}
		}
		// B구역
		for (int i = 1; i <= N; i++) {
			if(!v[i]) {
				checkB = i;
				break;
			}
		}
		// 포함된 구역이 없으면 false
		if (checkA == 0 || checkB == 0) return false;
		
		// A선거구 부터 확인
		PriorityQueue<Integer> q = new PriorityQueue<>();
		visited[checkA] = true;
		q.add(checkA);
		
		while (!q.isEmpty()) {
			Integer p = q.poll();
			for (int i = 0; i < adj[p].size(); i++) {
				if(visited[adj[p].get(i)] || !v[adj[p].get(i)]) continue; // 이미 방문 했다면 // A구역이 아니면
				visited[adj[p].get(i)] = true; // 방문
				q.add(adj[p].get(i)); 
			}

		}

		// B선거구 확인
		q.add(checkB);
		visited[checkB] = true;
		while (!q.isEmpty()) {
			Integer p = q.poll();
			for (int i = 0; i < adj[p].size(); i++) {
				if(visited[adj[p].get(i)] || v[adj[p].get(i)]) continue;
				visited[adj[p].get(i)] = true;
				q.add(adj[p].get(i));
			}

		}
		
		//연결이 안되었다면
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

}
