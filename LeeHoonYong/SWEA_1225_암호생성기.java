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
		for(int t=1;t<=10;t++) {
			int N= Integer.parseInt(br.readLine());
			String[] s= br.readLine().split(" ");
			Queue<Integer> Q = new LinkedList<>();
			//int[] arr =new int[8];
			for(int i=0; i<s.length; i++) {
				Q.offer(Integer.parseInt(s[i]));
			}
			int idx=0;
			
			int now=0;
			while(true) {
				idx++;
				if(idx==6) {
					idx=1;
				}
				now=Q.poll()-idx;
				if(now<=0) {
					now=0;
					Q.offer(now);
					break;
				}else {					
					Q.offer(now);
				}
			}
			System.out.print("#"+t);
			while(!Q.isEmpty()) {
				System.out.print(" "+Q.poll());
			}
			System.out.println();
		}
	}
}
