import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 1, 0};
	static int[][] arr;
	static int[][][] v, routes;
	static int N;
	
	static int solve(int x, int y, int d) {
		if (x == N - 1 && y == N - 1) {
			routes[x][y][d] = 1;
			return routes[x][y][d];
		}
		
		for(int k = 0; k < 3; k++) {
			if (d - k > 1 || d - k < -1) continue;
			
			int nx = x + dx[k];
			int ny = y + dy[k];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			if (arr[nx][ny] == 1) continue;
			
			if (k == 1 && (arr[x + 1][y] == 1 || arr[x][y + 1] == 1)) continue;
			
			if(v[nx][ny][k] == 1) {
				routes[x][y][d] += routes[nx][ny][k];
			}else{
				v[nx][ny][k] = 1;
				routes[x][y][d] += solve(nx, ny, k);
			}
		}

		return routes[x][y][d];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		routes = new int[N][N][3];
		v = new int[N][N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		v[0][1][0] = 1;
		solve(0, 1, 0);
		
		System.out.println(routes[0][1][0]);
	}
}
