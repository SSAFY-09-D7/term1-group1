package swea1218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int length = Integer.parseInt(br.readLine());
			String s = br.readLine();
			String[] strArray = s.split("");
			Stack<Character> stack = new Stack<>();
			int answer = 1;

			for (int i = 0; i < strArray.length; i++) {
				char check = s.charAt(i);
				
				if(check == ')' && stack.peek() == '(') {
					stack.pop();
				}
				else if(check == ']' && stack.peek() == '[') {
					stack.pop();
				}
				else if(check == '}' && stack.peek() == '{') {
					stack.pop();
				}
				else if(check == '>' && stack.peek() == '<') {
					stack.pop();
				}
				else {
					stack.push(check);
				}
			}
			
			if(!stack.isEmpty()) {
				answer = 0;
			}
			System.out.println("#" + tc + " " + answer);

		}

	}

}