import java.util.*;
import java.io.*;

public class BOJ2023 {
	static StringBuffer sb = new StringBuffer();
	static StringBuffer num = new StringBuffer();
	static int[] addons = {1, 3, 7, 9};
	static int N;
	
	static void solve() {
		if (num.length() == N) {
			sb.append(num.toString()+"\n");
			return;
		}
		
		for (int i = 0; i < addons.length; i++) {
			num.append(addons[i]);
			
			String value = num.toString();
			
			if (is_prime(Integer.parseInt(value))) {
				solve();
			}
			
			num.deleteCharAt(num.length() - 1);
		}
	}
	
	static boolean is_prime(int n) {
		boolean ans = true;
		
		for(int i = 2; i < (int)Math.pow(n, 0.5) + 1; i++) {
			if (n % i == 0) return false;
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(new Scanner(System.in).nextLine());
		int[] primes = {2, 3, 5, 7};
		
		for(int i = 0; i < primes.length; i++) {
			num.append(primes[i]);
			if (is_prime(Integer.parseInt(num.toString()))) solve();
			num.deleteCharAt(num.length() - 1);
		}
		
		System.out.println(sb);
	}
}
