import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test01 {
	
	static int result=0;
	static int[] arr;
	static int N=0;
	static int M=0;
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] s =br.readLine().split(" ");
		
		arr=new int[N];
		int sum=0;
		int max=0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(s[i]);
			sum+=arr[i];
			max=Math.max(max, arr[i]);
		}
		
		Arrays.sort(arr);
		
		M =Integer.parseInt(br.readLine());
		
		if(M<sum) {
			//
			search(1,max);
			//
			System.out.println(result);
		}else {
			System.out.println(max);
		}
		
	}
	static void search(int st, int en) {
		if(st>en) {
			return;
		}
		int sum=0;
		int mid=(st+en)/2;
		for(int i=0;i<N;i++) {
			if(arr[i]<=mid) {
				sum+=arr[i];
			}else {
				sum+=mid;
			}
		}
		if(sum>M) {
			en=mid-1;
			search(st,en);
		}else {
			result=mid;
			st=mid+1;
			search(st,en);
		}
	}

}
