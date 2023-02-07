package boj1065;

import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;

		if (n < 100) {
			System.out.println(n);
		}

		else {
			for (int i = 100; i <= n; i++) {
				int hun = i / 100;
				int ten = i / 10 - hun * 10;
				int one = i % 10;
				if (hun - ten == ten - one) {
					cnt++;
				}
			}
			System.out.println(cnt + 99);
		}

	}

}
