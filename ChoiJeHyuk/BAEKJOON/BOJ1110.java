package BOJ1110;

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
		
		int ten = n / 10;
		int one = n % 10;
		int cnt = 0;
		int newnum = 0;
		int sum = 0;
		
		while(true) {
			if(ten + one >=10) {
				sum = ten + one - 10;
			}
			else {
				sum = ten + one;
			}
			newnum = one * 10 + sum;
			ten = newnum / 10;
			one = newnum % 10;
			cnt++;
			if(newnum == n) {
				break;
			}
		}
		
		bw.write(cnt + "");
		bw.newLine();
		bw.flush();
	}

}
