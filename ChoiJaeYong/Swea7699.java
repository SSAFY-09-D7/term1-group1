package boj;

import java.util.*;
import java.io.*;

public class Swea3234 {
	static StringBuffer sb = new StringBuffer();
	static char[][] arr = new char[20][20];
	static int[][] v = new int[20][20];
	static int[] alps = new int[26];
	static int ans;
	static int R, C;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void dfs(int x, int y, int depth) {
		ans = Math.max(ans, depth);
		
		for(int k = 0; k < 4; k++) {
			int nx = x + dx[k], ny = y + dy[k];
			
			if (nx < 0 || nx >= R || ny < 0 || ny >= C || v[nx][ny] == 1 || alps[arr[nx][ny] - 65] == 1) continue;
			
			alps[arr[nx][ny] - 65] = 1;
			v[nx][ny] = 1;
			dfs(nx, ny, depth + 1);
			alps[arr[nx][ny] - 65] = 0;
			v[nx][ny] = 0;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());C = Integer.parseInt(st.nextToken());
			sb.append("#"+tc+" ");
			
			for(int i = 0; i < R; i++) {
				char[] input = br.readLine().toCharArray();
				
				for(int j = 0; j < C; j++) {
					arr[i][j] = input[j];
				}
			}
			
			v[0][0] = 1;
			alps[arr[0][0] - 65] = 1;
			dfs(0, 0, 1);
			v[0][0] = 0;
			alps[arr[0][0] - 65] = 0;
			
			sb.append(ans+"\n");
		}
		
		System.out.println(sb);
	}
}
