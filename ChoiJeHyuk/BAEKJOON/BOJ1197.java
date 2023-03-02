package BOJ1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 프림_인접리스트_PriorityQueue
 */
public class Main {

	static class Vertex implements Comparable<Vertex> {
		int end, cost;

		public Vertex(int end, int cost) {
			super();
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static int V, E;
	static ArrayList<Vertex>[] adj;
	//static int[] dist;
	static boolean[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		adj = new ArrayList[V + 1];

		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj[a].add(new Vertex(b, c));
			adj[b].add(new Vertex(a, c));
		}

		//dist = new int[V+1];
		v = new boolean[V+1];

		//Arrays.fill(dist, Integer.MAX_VALUE);
		//dist[1] = 0;

		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		v[1] = true;
		q.addAll(adj[1]);
		int cnt =1;

		int sum = 0;
		while (cnt < V) {
			Vertex p = q.poll();
			if(v[p.end]) continue;
			v[p.end] = true;
			
			sum+= p.cost;
			cnt++;
			q.addAll(adj[p.end]);
		}
		System.out.println(sum);

	}

}
