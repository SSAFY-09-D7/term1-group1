package git;

import java.io.*;
import java.util.*;

public class SWEA1859 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			long max = 0;
			long answer = 0;

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] > max) {
					max = arr[i];
				}
				answer += max - arr[i];
			}

			bw.write("#" + tc + " " + answer);
			bw.newLine();
			bw.flush();
		}
	}
}