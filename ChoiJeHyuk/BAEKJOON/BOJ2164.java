package boj2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Queue<Integer> queue = new LinkedList<>(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int temp = 0;
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		while(true) {
			if(queue.size() == 1) {
				break;
			}
			queue.poll();
			temp = queue.element();
			queue.poll();
			queue.offer(temp);
			
			
		}
		System.out.println(queue.peek());
		
		
		
	}

}
