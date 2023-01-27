import java.util.*;
import java.io.*;

public class Swea7964 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
			int[] arr = new int[n + 2];
			st = new StringTokenizer(br.readLine());
			int ans = 0;
			
			arr[0] = arr[n + 1] = 1;
			for(int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx = 0;
			
			while(idx + d < n + 1) {
				int last = -1;
				
				for(int i = idx + 1; i <= idx + d; i++) {
					if (arr[i] == 1) last = i;
				}
				
				if (last == -1) {
					arr[idx + d] = 1;
					ans++;
					idx += d;
				}else {
					idx = last;
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
