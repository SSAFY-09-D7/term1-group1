package SWEA9229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int M;
	static int[] weight;
	static int answer;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int T = 1; T <= TC; T++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			answer = 0;
			max = 0;
			st = new StringTokenizer(br.readLine());
			weight = new int[N];
			for (int i = 0; i < N; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			combi(weight,new int[2],0,0);
			
			if(answer == 0) {
				answer = -1;
			}
			System.out.println("#" + T + " " + answer);
		}
		
		
	}

	private static void combi(int[] arr, int[] sel, int idx, int k) {
		if(k == 2) {
			//System.out.println(Arrays.toString(sel));
			int sum = sel[0] + sel[1];
			
			
			if(sum <= M && sum > max) {
				max = sum;
				answer = sum;
			}
			
			
			return;
		}
		
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combi(arr, sel, i + 1, k + 1);
		}
	}

	

}
