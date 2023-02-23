package swea1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		end: while (cnt <10) {
			StringBuilder sb = new StringBuilder();
			int T = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp = 0;
			int answer = 0;
			int input = 0;
			for (int i = 0; i < 8; i++) {
				input = Integer.parseInt(st.nextToken());
				dq.offer(input);
			
			}
			
			L: while (true) {

				for (int i = 1; i <= 5; i++) {
					if (dq.peekLast() == 0) {
						break L;
					}
					temp = dq.element();
					dq.poll();
					temp -= i;
					if (temp < 0) {
						temp = 0;
					}
					dq.offer(temp);
				}
			}

			sb.append("#" + T + " ");
			for (int i = 0; i < 8; i++) {
				answer = dq.poll();
				sb.append(answer + " ");

			}
			System.out.println(sb);
			cnt ++;

		}
	}

}
