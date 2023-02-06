package main;

import java.util.*;
import java.io.*;

public class Swea1249 {
	static int[][] arr = new int[100][100];
	static int ans, N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] v = new int[100][100];
	
	
	static void solve(int x, int y, int cost) {
		if (x == N - 1 && y == N - 1) {
			ans = Math.min(ans, cost);
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			int nx = x + dx[k], ny = y + dy[k];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || cost + arr[nx][ny] >= v[nx][ny]) continue;
			
			v[nx][ny] = cost + arr[nx][ny];
			solve(nx, ny, cost + arr[nx][ny]);
		}
	}
	
	public static void main(String[] argsp) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			ans = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < N; i++) {
				String[] input = br.readLine().split("");
				
				for(int j = 0; j < N; j++) {
					v[i][j] = Integer.MAX_VALUE;
					arr[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			v[0][0] = arr[0][0];
			solve(0, 0, 0);
			sb.append(ans+"\n");
		}
		
		System.out.println(sb);
	}
}
