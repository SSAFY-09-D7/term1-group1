import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int[][] noo = new int[N + 1][N + 1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				noo[i][j] = arr[i - 1][j - 1] + noo[i - 1][j] + noo[i][j - 1] - noo[i - 1][j - 1];
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
			sb.append(noo[c][d] - noo[a - 1][d] - noo[c][b - 1] + noo[a - 1][b - 1]+"\n");
		}
		
		System.out.println(sb);
	}
}
