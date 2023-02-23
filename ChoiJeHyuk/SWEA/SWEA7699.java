package swea7699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[] alpha;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			answer = 0;
			
			map = new char[R][C];
			visited = new boolean[R][C];
			alpha = new int[26];
			
			for (int i = 0; i < R; i++) {
				map[i] = br.readLine().toCharArray(); // 입력받는거 다시보기
				
				
			}
			// 방문처리 먼저 하고 시작
			alpha[map[0][0] - 65] =1;
			visited[0][0] = true;
			dfs(0,0,1); // x, y , depth
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void dfs(int r, int c, int depth) {
		answer = Math.max(answer, depth);
		//System.out.println(depth);
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr <0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || alpha[map[nr][nc] - 65] == 1 ) continue;
			
			alpha[map[nr][nc] -65] = 1;
			visited[nr][nc] = true;
			dfs(nr,nc,depth+1);
			alpha[map[nr][nc] -65] = 0;
			visited[nr][nc] = false;
			
		}
	}

	

}
