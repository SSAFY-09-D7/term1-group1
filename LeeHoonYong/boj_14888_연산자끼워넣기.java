package homeStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int N;
	static int num;
	static int result=0;
	static int max=Integer.MIN_VALUE;
	static int min= Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] s =br.readLine().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=Integer.parseInt(s[i]);
		}
		
		s =br.readLine().split(" ");
		int[] op = new int[4];
		for (int i = 0; i < op.length; i++) {
			op[i]=Integer.parseInt(s[i]);
		}
		
		solve(arr,op,1,arr[0]);
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void solve(int[] arr, int[] op, int idx,int mid) {
		if(idx==N) {
			num++;
			max=Math.max(max, mid);
			min=Math.min(min, mid);
			//System.out.println(mid);
			return;
		}
		
		
		for(int i=0;i<4;i++) {
			if(op[i]!=0) {
				if(i==0) {
					op[i]--;
					mid+=arr[idx];
					solve(arr,op,idx+1,mid);
					op[i]++;
					mid-=arr[idx];
				}else if(i==1) {
					op[i]--;
					mid-=arr[idx];
					solve(arr,op,idx+1,mid);
					op[i]++;
					mid+=arr[idx];
				}
				else if(i==2) {
					op[i]--;
					mid*=arr[idx];
					solve(arr,op,idx+1,mid);
					op[i]++;
					mid/=arr[idx];
				}
				else if(i==3) {
					op[i]--;
					mid/=arr[idx];
					solve(arr,op,idx+1,mid);
					op[i]++;
					mid*=arr[idx];
				}
			}
		}
		//solve(arr,op,idx,mid);
		
		
		
	}
		
}
