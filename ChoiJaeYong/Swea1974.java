import java.util.*;
import java.io.*;

public class Swea1974 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = {0, 0, 0, 1, 1, 1, 2, 2, 2};
		int[] dy = {0, 1, 2, 0, 1, 2, 0, 1, 2};
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		int[] ans = new int[T];
		int[][] arr = new int[9][9];
		
		for(int tc = 1; tc <= T; tc++) {
			ans[tc - 1] = -1;//아직 모름
			
			for(int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//가로, 세로
			for(int i = 0; i < 9; i++) {
				int[] h = new int[10];//행
				int[] v = new int[10];//렬
				
				for(int j = 0; j < 9; j++) {
					if (h[arr[i][j]] == 0) h[arr[i][j]] = 1;
					else {
						ans[tc - 1] = 0;
						break;
					}
					
					if (v[arr[j][i]] == 0) v[arr[j][i]] = 1;
					else {
						ans[tc - 1] = 0;
						break;
					}
				}
			}
			
			if (ans[tc - 1] != -1) continue;
			
			//사각형
			for(int i = 0; i < 9; i+= 3) {//행
				for(int j = 0; j < 9; j += 3) {
					//한 사각형 범위 정함
					int[] s = new int[10];
					for(int k = 0; k < dx.length; k++) {
						if (s[arr[i + dx[k]][j + dy[k]]] == 0) s[arr[i + dx[k]][j + dy[k]]] = 1;
						else {
							ans[tc - 1] = 0;
							break;
						}
					}
				}
			}
			
			if (ans[tc - 1] == -1) ans[tc - 1] = 1;
		}
		
		for(int i = 0; i < ans.length; i++) {
			sb.append("#"+(i + 1)+" "+ans[i]+"\n");
		}
		
		System.out.println(sb);
	}
}
