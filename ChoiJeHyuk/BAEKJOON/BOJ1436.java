package BOJ1436;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		int num = 666;
		while(true) {
			
			if(Integer.toString(num).contains("666")) {
				cnt++;
			}
			num++;
			if(cnt == n) {
				bw.write(num-1 +"");
				bw.newLine();
				bw.flush();
				break;
			}
			
		}
	
		

	}

}
