import java.io.*;
import java.util.*;

public class BOJ15649 {
	static int N, M, ans;
	static int[] v;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		v = new int[N + 1];
		
		solve(0, new int[M]);
		System.out.println(sb);
	}
	
	static void solve(int cnt, int[] arr) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for (int i = 1; i <= N; i ++) {
			if (v[i] != 0) continue;
			
			v[i] = 1;
			arr[cnt] = i;
			solve(cnt + 1, arr);
			v[i] = 0;
		}
	}
}
