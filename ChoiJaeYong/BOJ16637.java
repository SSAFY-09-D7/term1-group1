import java.util.*;
import java.io.*;

public class BOJ16637 {
	static int[] sel, numbers;
	static int ans = Integer.MIN_VALUE, N;
	static String[] str, operators;
	static Deque<Integer> q = new LinkedList<Integer>();
	
	static int calc(int a, int b, String op) {
		if (op.equals("+")) return a + b;
		else if (op.equals("-")) return a - b;
		else return a * b;
	}
	
	static void solve(int k) {
		if (k == N / 2) {
			q.add(numbers[0]);
			
			for(int i = 0; i < N / 2; i++) {
				if (sel[i] == 1) {
					q.add(calc(q.pollLast(), numbers[i + 1], operators[i]));
				}else {
					q.add(numbers[i + 1]);
				}
			}
			
			int tmp = q.poll();
			
			for(int i = 0; i < N / 2; i++) {
				if (sel[i] == 0) {
					tmp = calc(tmp, q.poll(), operators[i]);
				}
			}
			
			ans = Math.max(ans, tmp);
			
			return;
		}
		
		solve(k + 1);
		
		if (k == 0 || (k > 0 && sel[k - 1] == 0)) {
			sel[k] = 1;
			solve(k + 1);
			sel[k] = 0;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		str = sc.nextLine().split("");
		numbers = new int[N / 2 + 1];
		operators = new String[N / 2];
		sel = new int[N / 2];
		
		for(int i = 0; i < str.length; i++) {
			if (i % 2 == 0) numbers[i / 2] = Integer.parseInt(str[i]);
			else operators[i / 2] = str[i];
		}
		
		solve(0);
		
		System.out.println(ans);
	}
}
