package BOJ10163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int k = 1;
		int[][] arr = new int[1001][1001];
		//Arrays.fill(arr, 0);
		int[] paper = new int[4];
		int temp = 1;
		int answer = 0;
		int check = 0;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			for (int j = 0; j < paper.length; j++) {
				paper[j] = Integer.parseInt(st.nextToken());	
			}
			for (int r = paper[0]; r <= paper[0] + paper[2]-1; r++) {
				for (int c = paper[1]; c <= paper[1] + paper[3]-1 ; c++) {
					arr[r][c] = k;
				}
			}
			k++;				
		}
		
		while(n>0) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j] == temp) {
						answer++;
					}
				}
			}
			n = n -1;
			sb.append(answer);
			sb.append("\n");
			answer = 0;
			temp++;
		}
		System.out.println(sb);
		
		
		

	}

}
