package BOJ10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i]=Integer.parseInt(st.nextToken());
		}
		
		nextPermutation();
		
	}

	private static void nextPermutation() {
		int idx = N -1;
		for (int i = N-1; i > 0; i--) {
			idx--;
			if(input[i-1] < input[i]) {
				idx = i;
				break;
			}
		}
		
		if(idx == 0) {
			System.out.println("-1");
			return ;
		}
		
		for(int i = N-1; i >=idx; i--) {
			if(input[idx-1] < input[i]) {
				int temp = input[idx-1];
				input[idx-1] = input[i];
				input[i] = temp;
				break;
			}
		}
		Arrays.sort(input, idx, N);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}

}
