package homeStudy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	static int result=0;
	static int[] arr;
	static int M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		s=br.readLine().split(" ");
		arr = new int [s.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(s[i]);
		}
		
		recursive(0,0,0);
		System.out.println(result);
	}
	private static void recursive(int idx,int sum,int num) {
		
		
		if(num==3) {
			result=Math.max(result, sum);
			//System.out.println(sum);
			return;
		}
		if(idx==arr.length) {
			return;
		}
		for(int i=idx;i<arr.length;i++) {
			sum+=arr[i];
			if(sum<=M) {
				recursive(i+1,sum,num+1);
			}
			sum-=arr[i];
		}
		
		
	}
}
