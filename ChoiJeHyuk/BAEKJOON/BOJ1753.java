package BOJ1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int e, c;

		public Node(int e, int c) {
			super();
			this.e = e;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.c, o.c);
		}

	}

	static int V, E;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<Node>[] adj;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		adj = new ArrayList[V + 1];
		dist = new int[V + 1];
		visited = new boolean[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 1; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[u].add(new Node(v, w));
		}

		dist[K] = 0;
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.add(new Node(K, 0));

		while (!q.isEmpty()) {
			Node p = q.poll();
			int minIdx = p.e;
			visited[minIdx] = true;

			for (Node next : adj[minIdx]) {
				if (!visited[next.e] && dist[next.e] > dist[minIdx] + next.c) {
					dist[next.e] = dist[minIdx] + next.c;
					q.add(new Node(next.e, dist[next.e]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				sb.append("INF");
			}
			else {
				sb.append(dist[i] + " ");				
			}
			sb.append("\n");
		}
		
		//System.out.println(Arrays.toString(dist));
		
		System.out.println(sb);
	}

}
