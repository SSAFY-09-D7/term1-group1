import java.util.*;
import java.io.*;

public class Swea1234 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Deque<Character> q = new LinkedList<>();
		
		for(int tc = 1; tc <= 2; tc++) {
			sb.append("#"+tc+" ");
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			
			for(int i = 0; i < n; i++) {
				if (q.isEmpty()) q.add(input[1].charAt(i));
				else if (q.getLast() == input[1].charAt(i)) q.pollLast();
				else q.add(input[1].charAt(i));
			}
			
			while(!q.isEmpty()) {
				sb.append(q.poll());
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
