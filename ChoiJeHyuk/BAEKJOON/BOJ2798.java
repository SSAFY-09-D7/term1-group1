package BOJ2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int sum;
	static int answer = 0;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[] card = new int[n];
		
		s = br.readLine();
		st = new StringTokenizer(s);
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		recursive(card, new int[3], 0, 0);
		
		System.out.println(answer);
	}

	private static void recursive(int[] card, int[] sel, int idx, int k) {
		
		if(k == sel.length) {
			sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(answer < sum && sum <= m) {
				answer = sum;
			}
			
			return;
		}
		
		for(int i = idx; i < card.length; i++) {
			sel[k] = card[i];
			recursive(card, sel, i+1, k+1);
		}
	}

}
