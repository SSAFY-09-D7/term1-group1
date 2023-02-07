package boj;

import java.util.*;
import java.io.*;

class Node {
	int x, y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}

public class BOJ15686 {
	static StringBuffer sb = new StringBuffer();
	static int[][] arr = new int[50][50];
	static int[][] v = new int[50][50];
	static int N, M;
	static int[] choice;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Node> chicken = new ArrayList<Node>();
	static List<Node> house = new ArrayList<Node>();
	static int ans = Integer.MAX_VALUE;
	static int[] chosen;
	
	static void solve(int depth, int sel) {
		if (sel == M) {
			int distance = 0;
			
			for(int i = 0; i < house.size(); i++) {
				Node h = house.get(i);
				int hd = Integer.MAX_VALUE;
				
				for(int j = 0; j < M; j++) {
					Node c = chicken.get(choice[j]);
					
					hd = Math.min(hd, Math.abs(c.x - h.x) + Math.abs(c.y - h.y));
				}
				
				distance += hd;
			}
			
			ans = Math.min(distance, ans);

			return;
		}
		
		if (depth >= chicken.size()) {
			return;
		}
		
		choice[sel] = depth;
		solve(depth + 1, sel + 1);
		solve(depth + 1, sel);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());M = Integer.parseInt(st.nextToken());
		choice = new int[M];chosen = new int[M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (arr[i][j] == 1) house.add(new Node(i, j));
				else if (arr[i][j] == 2) chicken.add(new Node(i, j));
			}
		}
		
		solve(0, 0);
		
		System.out.println(ans);
	}
}
