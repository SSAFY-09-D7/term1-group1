import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BOJ1914 {
	static int N;
	static StringBuffer sb = new StringBuffer();
	
	static void hanoi(int plates, int from_, int to_) {
		if (plates == 1) {
			sb.append(from_+" "+to_+"\n");
			return;
		}
		
		hanoi(plates - 1, from_, 6 - from_ - to_);
		hanoi(1, from_, to_);
		hanoi(plates - 1, 6 - from_ - to_, to_);
	}
	
	public static void main(String[] args){
		N = Integer.parseInt(new Scanner(System.in).nextLine());
		BigInteger res = new BigInteger("1");
		
		for(int i = 0; i < N; i++) {
			res = res.multiply(new BigInteger("2"));
		}res = res.subtract(new BigInteger("1"));
		
		sb.append(res+"\n");
		
		if (N <= 20) hanoi(N, 1, 3);
		
		System.out.println(sb);
	}
}
