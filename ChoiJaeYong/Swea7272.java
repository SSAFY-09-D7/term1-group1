import java.io.*;
import java.util.Arrays;

public class Swea7272 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		int[] alps = new int[26];
		
		alps[1] = 2;
		char[] tmp = new char[]{'A','D','O','P','Q','R'}; 
		
		for(int i = 0; i < tmp.length; i++) {
			alps[(int)tmp[i] - 65] = 1;
		}
		
		for(int tc = 1; tc <= t; tc++) {
			String[] input = br.readLine().split(" ");
			char[] first = input[0].toCharArray(), later = input[1].toCharArray();
			
			sb.append("#"+tc+" ");
			
			if (first.length != later.length) {
				sb.append("DIFF\n");
				continue;
			}
			
			boolean ans = true;
			
			for(int i = 0; i < input[0].length(); i++) {
				if(alps[(int)first[i] - 65] != alps[(int)later[i] - 65]) {
					ans = false;break;
				}
			}
			
			if (ans) sb.append("SAME\n");
			else sb.append("DIFF\n");
		}
		
		System.out.println(sb);
	}
}
