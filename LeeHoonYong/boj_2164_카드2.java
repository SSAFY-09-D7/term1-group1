import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int N= Integer.parseInt(br.readLine());
			Queue<Integer> Q = new LinkedList<>();
			for(int i=1;i<=N;i++) {
				Q.offer(i);
			}
			while(Q.size()!=1) {
				Q.poll();
				int now=Q.poll();
				Q.offer(now);
			}
			System.out.println(Q.peek());
		
			
	}
}
