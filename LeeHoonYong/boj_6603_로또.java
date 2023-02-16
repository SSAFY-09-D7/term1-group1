import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int k;
	static int[] arr;
	static int[] res;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] s = br.readLine().split(" ");
			k = Integer.parseInt(s[0]);
		
			if(k==0) {
				return;
			}
			arr = new int[k];
			res = new int[6];
			for (int i = 1; i <= k; i++) {
				arr[i-1] = Integer.parseInt(s[i]);
			}
			Arrays.sort(arr);
			solve(0,0);
			System.out.println();
		}
	}
	private static void solve(int idx, int num) {
		
		if(num==6) {
			for (int i = 0; i < res.length; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
			return;
		}
		
		if(idx>=k) {
			return;
		}
		for(int i=idx;i<k;i++) {
			res[num]=arr[i];
			solve(i+1,num+1);
			
		}
		
	}

}
