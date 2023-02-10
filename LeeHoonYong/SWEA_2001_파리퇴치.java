import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int result=0;
	static int N;
	static int M;
	static int[][] arr;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			result=0;
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			arr=new int[N][N];
			for (int i = 0; i < N; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j]=Integer.parseInt(s[j]);
				}
			}
			
			for (int i = 0; i <= N-M; i++) {
				for (int j = 0; j <= N-M; j++) {
					result=Math.max(result, solve(i,j));
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
	private static int solve(int r, int c) {
		int sum=0;
		for (int i = r; i < r+M; i++) {
			for (int j = c; j < c+M; j++) {
				sum+=arr[i][j];
			}
		}
		//System.out.println(sum);
		return sum;
		
	}
}
