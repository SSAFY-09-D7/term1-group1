package SWEA6808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Solution {
	static int[] one;
	static int[] two;
	static int[] check;
	static int onesum, twosum;
	static int answer, end;
	static int max = 0;
	static int oneanswer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			one = new int[9];
			two = new int[9];
			check = new int[9];
			int cnt = 0;
			answer = 0;
			oneanswer = 0;
			end = 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1;

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < one.length; i++) {
				one[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= 18; i++) {
				int temp = i;
				if (IntStream.of(one).anyMatch(x -> x == temp)) {
					continue;
				} else {
					two[cnt] = i;
					cnt++;
				}
			}

			permutation(0, 0);

			System.out.println("#" + tc + " " + oneanswer + " " + answer);

		}
		
	}

	private static void permutation(int cnt, int flag) {
		if (cnt == 9) {
			// System.out.println(Arrays.toString(check));
			// System.out.println(Arrays.toString(one));
			twosum = 0;
			onesum = 0;
			for (int i = 0; i < one.length; i++) {
				// System.out.println(one[i] + " " + check[i]);
				if (one[i] < check[i]) {
					twosum += check[i] + one[i];
				} else if (one[i] > check[i]) {
					onesum += one[i] + check[i];
				}

			}
			// System.out.println(onesum + " " + twosum);
			if (onesum < twosum) {
				answer++;
			} else if (onesum > twosum) {
				oneanswer++;
			}

			return;
		}
		for (int i = 0; i < 9; i++) {
			if ((flag & (1 << i)) != 0)
				continue;
			check[cnt] = two[i];
			permutation(cnt + 1, flag | (1 << i));
		}
	}
}
