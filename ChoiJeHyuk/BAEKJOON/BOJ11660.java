package BOJ11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][n];
		int[][] sum = new int[n][n];

		
		for (int i = 0; i < arr.length; i++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < arr.length; j++) {
				if(j ==0) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}else {
					arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j-1];
				}
			}
		}
		// arr 0번부터 n-1번까지 더한거 11~13 13 10

		int[] range = new int[4];
		int answer = 0;
		for (int i = 0; i < m; i++) {
			answer = 0;
			s = br.readLine();
			st = new StringTokenizer(s);
			for (int j = 0; j < range.length; j++) {
				range[j] = Integer.parseInt(st.nextToken());
			}
			if(range[0] == range[2] && range[1] != 1) {
				answer = arr[range[2]-1][range[3]-1] - arr[range[0]-1][range[1]-2];
			}
			else if(range[0] == range[2] && range[1] == 1) {
				answer = arr[range[2]-1][range[3]-1];
			}
			
			else if(range[0] != range[2]) {
				for (int j = range[0]; j <= range[2]; j++) {
					if(range[1] != 1) {
						answer += arr[j-1][range[3]-1] - arr[j-1][range[1]-2];
					}
					else if(range[1] == 1) {
						answer += arr[j-1][range[3]-1];
					}
					
				}
			}
			sb.append(answer);
			sb.append("\n");

		}
		System.out.println(sb);
	}

}
