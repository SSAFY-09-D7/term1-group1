package SWEA7236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	static int N;
	static String[][] map;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new String[N][N];
			answer = 0;
			for (int i = 0; i < map.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map.length; j++) {
					map[i][j] = st.nextToken();
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					check(i,j);
				}
			}
			if(answer == 0) {
				answer = 1;
			}
			System.out.println("#" + tc + " " + answer);
			
		}
		
		
	}
	private static void check(int x, int y) {
		int cnt = 0;
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if(map[nx][ny].equals("W")) {
				cnt++;
			}
		}
		if(cnt > answer) {
			answer = cnt;
		}
		
	}

}
