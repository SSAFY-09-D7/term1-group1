package boj1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			q.offer(i + 1);
		}

		sb.append("<");

		while (q.size() > 1) {

			for (int i = 0; i < k - 1; i++) {
				int temp = q.peek();
				q.offer(temp);
				q.poll();
			}
			sb.append(q.peek() + ", ");
			q.poll();
		}
		sb.append(q.peek());

		sb.append(">");
		System.out.println(sb);
	}

}
