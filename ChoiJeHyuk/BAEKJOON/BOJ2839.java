package BOJ2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int div = N/5;
		int answer = 0;
		int remain;
		while(div >= 0) {
			remain = N - div * 5;
			if(remain % 3 == 0) {
				answer = div + remain / 3;
				break;
			}
			div--;
		}
		if(answer == 0) {
			answer = -1;
		}
		System.out.println(answer);
	}
 
}