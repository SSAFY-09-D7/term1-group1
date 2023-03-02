package BOJ1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] v;
	static int answer = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 이동채널
		M = Integer.parseInt(br.readLine()); // 고장난 버튼 개수
		v = new boolean[11];
		if(M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				v[Integer.parseInt(st.nextToken())] = true;
			}	
		}
		answer = Math.abs(N - 100);
		for (int i = 0; i <= 1000000; i++) {
			int cnt = check(i);
			if (cnt != 0)
				answer = Math.min(answer, Math.abs(N - i) + check(i));
		}
		System.out.print(answer);
	}

	private static int check(int n) {
		if (n == 0) {
			if (v[n])
				return 0;
			else
				return 1;
		}

		int cnt = 0;
		while (n > 0) {
			if (v[n % 10])
				return 0;
			cnt++;
			n /= 10;
		}

		return cnt;
	}

}
