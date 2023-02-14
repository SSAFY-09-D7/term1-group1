import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class Main {
	static int n;
	static int m;
	static int num=0;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		BigInteger bi = new BigInteger("1");
		
		for(long i=n;i>=n-m+1;i--) {
			BigInteger bi2 = bi.valueOf(i);
			BigInteger bi3 = bi.valueOf(n+1-i);
			bi=bi.multiply(bi2);
			bi=bi.divide(bi3);
		}
		System.out.println(bi);
	}	
}
