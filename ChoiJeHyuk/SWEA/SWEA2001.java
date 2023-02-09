import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t= Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][n];
			int sum = 0;
			int max = 0;
			
			for (int i = 0; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i <= arr.length-m; i++) {
				for (int j = 0; j <= arr.length-m; j++) {
					sum = 0;
					for (int k = 0; k < m; k++) {
						for (int l = 0; l < m; l++) {
							sum += arr[i+k][j+l];
						}
					}
					if(max < sum) {
						max = sum;
					}
				}
			}
			System.out.println("#" + tc + " " + max);
			
			
		}
		

	}

}
