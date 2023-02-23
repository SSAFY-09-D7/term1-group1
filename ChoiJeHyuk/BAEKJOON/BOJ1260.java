package boj1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,V;
	static boolean[] visited;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수 , 간선은 양방향
		V = Integer.parseInt(st.nextToken()); // 시작할 정점의 번호
		
		graph = new int[N+1][N+1]; // 1부터 시작해서 +1
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			graph[x][y] = graph[y][x] = 1;
		}
		
		dfs(V);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(V);
		
	}
	private static void dfs(int d) {
		visited[d] = true; // 방문한건 true
		System.out.print(d + " "); // 시작부터 넣어주고
		for (int i = 1; i < N+1; i++) {
			if(graph[d][i] == 1 && visited[i] == false) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int b) {
		Queue<Integer> q = new LinkedList<Integer>();
		visited[b] = true;
		q.add(b);
		System.out.print(b + " ");
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 1; i < N+1; i++) {
				if(graph[temp][i] ==1 & visited[i] == false) {
					q.offer(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
			
		}
	}

}
