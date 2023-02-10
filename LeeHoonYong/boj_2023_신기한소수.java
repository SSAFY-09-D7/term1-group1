package homeStudy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	static int N;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr= new int[N];
		solve(0);
	}
	private static void solve(int idx) {
		if(idx==N) {
			sb=new StringBuilder();
			for(int i=0;i<N;i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(idx==0 && i==0) continue;
			arr[idx]=i;
			if(isPrime(arr,idx)) {
				//System.out.println(Arrays.toString(arr));
				solve(idx+1);
			}
		}
	}
	private static boolean isPrime(int[] arr,int idx) {
		int num=0;
		for (int j=0;j<idx;j++) {
			num+=arr[j];
			num*=10;
		}
		num+=arr[idx];
		
		if(num<=1) return false;
		if(num<=3) return true;
		if (num % 2 ==0) return false;
        for(int div = 3; div <= Math.sqrt(num); div+=2) {
            if(num % div == 0) return false;
        }
        return true;
	}
	
}