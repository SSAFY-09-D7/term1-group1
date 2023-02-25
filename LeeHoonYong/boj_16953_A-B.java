import java.util.*;
import java.io.*;
public class Main {
	
	static long B;
	static long A;
	static long ans=Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		A = Integer.parseInt(s[0]);
		B = Integer.parseInt(s[1]);
		
		
		solve1(A,1);
		
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
 	}


	private static void solve1(long k,long level) {
		if(k>B) {
			return;
		}
		if(k==B) {
			ans=Math.min(ans, level);
			return;
		}	
		solve1(k*2,level+1);
		solve1(k*10+1,level+1);
	}
	
	
}
