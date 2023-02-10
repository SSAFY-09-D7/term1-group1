import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	static int N=0;
	static int[][] arr;
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//신맛은 곱 쓴맛은 합
		N =Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] s =br.readLine().split(" ");
			arr[i][0]=Integer.parseInt(s[0]);
			arr[i][1]=Integer.parseInt(s[1]);
		}
		solve(0,1,0,0);
		System.out.println(result);
	}

	private static void solve(int idx, int s, int b,int num) {
		if(idx==N) {
			if(num==0) {
				return;
			}
			result=Math.min(Math.abs(s-b), result);
			return;
		}
		solve(idx+1,s*arr[idx][0],b+arr[idx][1],num+1);
		solve(idx+1,s,b,num);
		
	}
	
}
