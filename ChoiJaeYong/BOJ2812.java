import java.util.*;
import java.io.*;

public class BOJ2812 {
	public static void main(String[] argsp) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		char[] number = br.readLine().toCharArray();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(number[i]+"");
			
			while(!stack.isEmpty()) {
				if (stack.get(stack.size() - 1) < num && K > 0) {
					K -= 1;
					stack.pop();
				}else {
					break;
				}
			}
			
			stack.push(num);
		}
		
		for(int i = 0; i < K; i++) {
			stack.pop();
		}
		
		for(int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		
		System.out.println(sb);
	}
}
