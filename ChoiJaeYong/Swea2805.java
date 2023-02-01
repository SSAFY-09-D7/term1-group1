import java.util.*;
import java.io.*;

public class Swea2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int add = 1, span = 0;
			int harvest = 0;
			
			for(int i = 0; i < N; i++) {
				String[] input = br.readLine().split("");
				
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if (j >= N/2 - span && j <= N/2 + span) harvest += arr[i][j];
					if (i == N/2) add = -1;
				}
				span += add;
			}
			
			sb.append(harvest+"\n");
		}
		
		System.out.println(sb);
	}
}
