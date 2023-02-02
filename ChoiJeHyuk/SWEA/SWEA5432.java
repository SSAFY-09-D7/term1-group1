package swea5432;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int cnt = 0;
			int answer = 0;
			
			String s = br.readLine();
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '(' && s.charAt(i+1) == ')') {
					answer += cnt;
					i++;
				}
				else if(s.charAt(i) == '(') {
					cnt++;
				}
				else {
					answer++;
					cnt--;
				}
				
			}
			bw.write("#" + tc + " " + answer);
			bw.newLine();
			bw.flush();
		}
		
	}

}
