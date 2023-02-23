package boj2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> answer = new Stack<>();

		sb.append(0 + " ");
		stack.push(Integer.parseInt(st.nextToken()));
		answer.push(0);
		for (int i = 1; i < n; i++) {
			int check = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty() && stack.peek() <= check) {
				stack.pop();
				answer.pop();
			}
			if (!answer.isEmpty()) {
				sb.append(answer.peek() + 1 + " ");
			} else {
				sb.append(0 + " ");
			}
			stack.push(check);
			answer.push(i);
		}
		System.out.println(sb);
	}

}
