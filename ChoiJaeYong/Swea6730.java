import java.util.*;
import java.io.*;

//상하좌우
public class Swea6730 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int up = 0, down = 0;
			sb.append("#"+tc+" ");
			
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1; i < N; i++) {
				if (arr[i] > arr[i - 1]) up = Math.max(up, arr[i] - arr[i - 1]);
				else if (arr[i] < arr[i - 1]) down = Math.max(down,  arr[i - 1] - arr[i]);
			}
			
			sb.append(up+" "+down+"\n");
		}
		
		System.out.println(sb);
	}
}
