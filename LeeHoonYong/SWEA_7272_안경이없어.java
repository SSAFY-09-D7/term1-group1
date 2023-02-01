package homeStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_7272_안경이없어 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T= Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			char[] hole0={'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
			char[] hole1= {'A','D','O','P','Q','R'};
			char[] hole2= {'B'}; 
			String[] s=br.readLine().split(" ");
			
			StringBuffer s1 = new StringBuffer();
			StringBuffer s2 = new StringBuffer();
		
			for(int i=0;i<s[0].length();i++) {
				for(int j=0;j<hole0.length;j++) {
					if(s[0].charAt(i)==hole0[j]) {
						s1.append('0');
						break;
					}
				}
				for(int j=0;j<hole1.length;j++) {
					if(s[0].charAt(i)==hole1[j]) {
						s1.append('1');
						break;
					}
				}
				for(int j=0;j<hole2.length;j++) {
					if(s[0].charAt(i)==hole2[j]) {
						s1.append('2');
						break;
					}
				}
			}
			
			for(int i=0;i<s[1].length();i++) {
				for(int j=0;j<hole0.length;j++) {
					if(s[1].charAt(i)==hole0[j]) {
						s2.append('0');
						break;
					}
				}
				for(int j=0;j<hole1.length;j++) {
					if(s[1].charAt(i)==hole1[j]) {
						s2.append('1');
						break;
					}
				}
				for(int j=0;j<hole2.length;j++) {
					if(s[1].charAt(i)==hole2[j]) {
						s2.append('2');
						break;
					}
				}
			}
			
			String st1=s1.toString(); //문자열 비교를 위해 String 으로 형변환
			String st2=s2.toString();
			if(s1.length()==s2.length()) {
				if(st1.equals(st2)) {
					bw.write("#"+t+" "+"SAME");
					bw.newLine();
				}else {
					bw.write("#"+t+" "+"DIFF");
					bw.newLine();
				}
			}else {
				bw.write("#"+t+" "+"DIFF");
				bw.newLine();
			}
		}
		br.close();
		bw.flush();
		bw.close();

	}

}
