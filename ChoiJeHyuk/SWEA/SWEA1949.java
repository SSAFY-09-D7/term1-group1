package SWEA1949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N, K;
	static int[][] map;
	static int height;
	static int length;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			// 지도의 한 변의 길이 N , 최대 공사 가능 깊이 K
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visited = new boolean[N][N];
			height = 0;
			length = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 가장 높은 곳에서 시작
					height = Math.max(height, map[i][j]);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == height) { 
						dfs(i, j, 1, false); // 위치 깊이 use
						// 산을 파헤치면 true로 
					}
				}
			}
			System.out.println("#" + tc + " " + length);
		}
	}

	private static void dfs(int r, int c, int cnt, boolean used) {
		visited[r][c] = true;
		length = Math.max(length, cnt);
		for (int d = 0; d < 4; d++) { // 4방
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr,nc)) continue; // 여기서 if문 쓰지 말고 check로 빼기 
			if(visited[nr][nc]) continue; // 방문했으면 
			if(map[nr][nc] < map[r][c]) {
				dfs(nr,nc,cnt+1,used);
			}else { // 지형을 깎을때를 else로 그냥 처리하는게 편함
				if(!used) {
					for (int i = 1; i <= K; i++) {
						if(map[nr][nc]-i < map[r][c]) { // i 만큼 깎기
							map[nr][nc] -= i;
							dfs(nr,nc,cnt+1,true); // 다 돌고 온다는 온다는게 중요
							map[nr][nc] += i; //복구 // 끝까지 가서 못가면 다시 원위치 
						}
					}
				}
			}
		}
		visited[r][c] = false;
	}

	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
 
}
