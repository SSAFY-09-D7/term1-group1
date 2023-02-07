package boj6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		while (true) {
			sb =  new StringBuilder();
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}
			int[] arr = new int[k];
			for (int i = 0; i < k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			recursive(arr, new int[6], 0, 0);
			System.out.println(sb);
			
		}

	}

	private static void recursive(int[] arr, int[] sel, int idx, int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}
		if (idx == arr.length) {
			return;
		}

		sel[k] = arr[idx];
		recursive(arr, sel, idx + 1, k + 1);
		recursive(arr, sel, idx + 1, k);

	}

}
