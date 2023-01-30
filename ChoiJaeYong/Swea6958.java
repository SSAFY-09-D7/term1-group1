import java.util.*;
import java.io.*;

public class Swea6958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][m];
			int[] ans = new int[m + 1];
			
			sb.append("#"+tc+" ");
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < n; i++) {
				int correct = 0;
				
				for(int j = 0; j < m; j++) {
					if (arr[i][j] == 1) correct++;
				}
				
				ans[correct]++;
			}
			
			for(int i = m; i >= 0; i--) {
				if(ans[i] > 0) {
					sb.append(ans[i]+" "+i+"\n");
                    break;
				}
			}
		}
		System.out.println(sb);
	}
}
