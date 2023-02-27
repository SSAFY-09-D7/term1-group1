package BOJ16938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,L,R,X;
	static int[] level;
	static int sum
	;
	static int answer =0;
	static int max;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 문제수
		L = Integer.parseInt(st.nextToken()); // 두문제합 L <= 합 <= R
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken()); // 두문제 차 >= X
		level = new int[N];
		
		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			level[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 2; i <= N; i++) {
			recursive(level , new int[i] , 0,0);
		}
		System.out.println(answer);
	}
	private static void recursive(int[] level, int[] sel, int idx, int k) {
		if(k == sel.length) {
			//System.out.println(Arrays.toString(sel));
			sum = 0;
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
				min = Math.min(min, sel[i]);
				max = Math.max(max, sel[i]);
			}
			//System.out.println(min + " " + max + " " + sum);
			if(L <= sum && sum <= R && (max-min) >= X) {
				answer++;
			}
			
			return;
		}
		
		for (int i = idx; i < level.length; i++) {
			sel[k] = level[i];
			recursive(level, sel, i+1,k+1);
		}
	}

}
