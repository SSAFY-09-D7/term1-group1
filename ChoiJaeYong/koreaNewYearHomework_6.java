package test;

import java.util.*;
import java.io.*;

public class Test {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken()) - 1, y = Integer.parseInt(st.nextToken()) - 1;
			int jumpers = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < jumpers; i++) {
				//값이 -1이면 점퍼
				arr[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = -1;
			}
			
			int sim = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < sim; i++) {
				int d = Integer.parseInt(st.nextToken()) - 1, s = Integer.parseInt(st.nextToken());
				
				for(int walk = 0; walk <= s; walk++) {
					int nx=x+dx[d]*walk, ny=y+dy[d]*walk;
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] == -1) {
						x = 0; y = 0;
						break;
					}
				}
				
				if (x == 0 && y == 0) break;
				x += dx[d] * s; y += dy[d] * s;
			}
			
			if (x == 0 && y == 0) sb.append(x+" "+y+"\n");
			else sb.append((x + 1)+" "+(y + 1)+"\n");
		}
		
		System.out.println(sb);
	}
}
