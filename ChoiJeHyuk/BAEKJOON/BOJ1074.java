package boj1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, size;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);

		cut(0, 0, size);

	}

	private static void cut(int x, int y, int size) {

//		if (size == 2) {
//			for (int i = x, xEnd = x + size; i < xEnd; i++) {
//				for (int j = y, yEnd = y + size; j < yEnd; j++) {
//					if (i == r && j == c) {
//						System.out.println(cnt);
//						System.exit(0);
//					}
//					cnt++;
//				}
//			}
//		}

		if (size == 1) {
			System.out.println(cnt);
			return;
		}
		int half = size / 2;
		if (r < x + half && c < y + half) {
			cut(x, y, half);
		} else if (r < x + half && c >= y + half) {
			cnt += size * size / 4;
			cut(x, y + half, half);
		} else if (r >= x + half && c < y + half) {
			cnt += size * size / 4 * 2;
			cut(x + half, y, half);
		} else if (r >= x + half && c >= y + half) {
			cnt += size * size / 4 * 3;
			cut(x + half, y + half, half);
		}

	}

}
