import java.util.*;
import java.io.*;

public class Swea1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int flag = 0;
			sb.append("#"+tc+" ");
			String original = br.readLine();
			
			for(int i = 0; i < original.length(); i++) {
				if(original.charAt(i) == '1' && flag == 0) {
					ans++;
					flag = 1;
				}else if(original.charAt(i) == '0' && flag == 1) {
					ans++;
					flag = 0;
				}
			}
			
			sb.append(ans+"\n");
		}
		
		System.out.println(sb);
	}
}
