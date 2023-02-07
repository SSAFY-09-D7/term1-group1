package boj15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		recursive(arr, new int[m], 0, 0);
	}

	private static void recursive(int[] arr, int[] sel, int idx, int k) {
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		if (idx == arr.length) {
			return;
		}

		sel[k] = arr[idx];
		recursive(arr, sel, idx + 1, k + 1);
		// 저장하지 않는 경우
		recursive(arr, sel, idx + 1, k);

	}

}
