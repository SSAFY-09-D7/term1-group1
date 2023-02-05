import java.io.*;
import java.util.*;

public class 최적_경로 {
	static int ans;
	static int[][] arr = new int[10][2];
	static int[] v = new int[10];
	static int N;
	static int cx, cy, hx, hy;
	
	static void solve(int sum, int lx, int ly, int depth) {
		if (depth == N) {
			ans = Math.min(ans, sum + Math.abs(lx - hx) + Math.abs(ly - hy));
			
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if (v[i] == 0 && sum + Math.abs(arr[i][0] - lx) + Math.abs(arr[i][1] - ly) < ans) {
				v[i] = 1;
				solve(sum + Math.abs(arr[i][0] - lx) + Math.abs(arr[i][1] - ly), arr[i][0], arr[i][1], depth + 1);
				v[i] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			cx = Integer.parseInt(st.nextToken()); cy = Integer.parseInt(st.nextToken());
			hx = Integer.parseInt(st.nextToken()); hy = Integer.parseInt(st.nextToken());

			for(int i = 0; i < N; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				v[i] = 0;
			}
			
			for(int i = 0; i < N; i++) {
				v[i] = 1;
				solve(Math.abs(cx - arr[i][0]) + Math.abs(cy - arr[i][1]), arr[i][0], arr[i][1], 1);
				v[i] = 0;
			}
			
			sb.append(ans+"\n");
		}
		
		System.out.println(sb);
	}
}
