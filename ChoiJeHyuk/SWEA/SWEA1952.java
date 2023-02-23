package swea1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] price;
	static int[] use;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			use = new int[13];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			min = price[3];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= use.length - 1; i++) {
				use[i] = Integer.parseInt(st.nextToken());
			}

			monitor(1, 0);
			System.out.println("#" + tc + " " + min);
		}

	}

	private static void monitor(int month, int cost) {
		if (cost > min) {
			return;
		}
		if (month == 13) {
			min = Math.min(cost, min);
			return;
		}

		if (use[month] == 0) {
			monitor(month + 1, cost);
		}
		if (use[month] > 0) {
			monitor(month + 1, cost + use[month] * price[0]);
			monitor(month + 1, cost + price[1]);
		}

		if (month <= 10) {
			monitor(month + 3, cost + price[2]);
		}
	}
}
