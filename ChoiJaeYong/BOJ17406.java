import java.util.*;
import java.io.*;

public class BOJ17406 {
	static int N, M, K, ans;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[] sel, v;
	static int[][] tmp_arr;
	static int[][] spins;
	
	static void combinations(int idx) {
		if (idx == K) {
			tmp_arr = new int[N][M];
			
			for(int i = 0; i < N; i++) tmp_arr[i] = Arrays.copyOf(arr[i], arr[i].length);
			
			for(int i = 0; i < K; i++) {
				rotation(spins[sel[i]][0], spins[sel[i]][1], spins[sel[i]][2]);
			}
			
			
			for(int i = 0; i < N; i++) {
				int sum = 0;
				
				for(int j = 0; j < M; j++) {
					sum += tmp_arr[i][j];
				}
				
				ans = Math.min(ans, sum);
			}
			
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if (v[i] == 1) continue;
			
			v[i] = 1;
			sel[idx] = i;
			combinations(idx + 1);
			v[i] = 0;
		}
	}
	
	static void rotation(int r, int c, int s) {
		for(int k = 0; k < s; k++) {
			int x = r - s + k, y = c - s + k, d = 0;
			int first = tmp_arr[x][y];
			
			while(true) {
				int nx = x + dx[d], ny = y + dy[d];
				
				if (nx < r - s + k || nx > r + s - k || ny < c - s + k || ny > c + s - k) {
					if (d == 3) break;
					else {
						d++;
						continue;
					}
				}
				
				if (nx == r - s + k && ny == c - s + k) {
					tmp_arr[x][y] = first;
				}else {
					tmp_arr[x][y] = tmp_arr[nx][ny];
				}
				
				x = nx;y = ny;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());M = Integer.parseInt(st.nextToken());K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		sel = new int[K];v = new int[K];
		ans = Integer.MAX_VALUE;spins = new int[K][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			spins[i][0] = Integer.parseInt(st.nextToken()) - 1;spins[i][1] = Integer.parseInt(st.nextToken()) - 1;spins[i][2] = Integer.parseInt(st.nextToken());
		}
		
		combinations(0);
		
		System.out.println(ans);
	}
}
