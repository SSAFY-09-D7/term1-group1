import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

class Point{
	int n;
	int time;
	Point(int n, int time){
		this.n = n;
		this.time =time;
	}
}


public class Main {
	
	static boolean v[];
	static int N;
	static int K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s =br.readLine().split(" ");
		N = Integer.parseInt(s[0]); //수빈의 위치
		K = Integer.parseInt(s[1]); // 동생의 위치

		
		
		v = new boolean[100001];

		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(N,0));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.n==K) {
				System.out.println(p.time);
				break;
			}
			
			if( 0<=p.n-1 && p.n-1<=100000 && v[p.n-1]== false ) {
				q.offer(new Point(p.n-1,p.time+1));
				v[p.n-1]= true;				
			}
			if( 0<=p.n+1 && p.n+1<=100000 && v[p.n+1]== false ) {
				q.offer(new Point(p.n+1,p.time+1));
				v[p.n+1]= true;				
			}
			if( 0<=p.n*2 && p.n*2<=100000 && v[p.n*2]== false ) {
				q.offer(new Point(p.n*2,p.time+1));
				v[p.n*2]= true;				
			}
			
		}			
	}
}
