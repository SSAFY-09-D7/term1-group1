import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Solution {
	static boolean[] arr;
	static int[][] map;
	static int[] div1;
	static int[] div2;
	static int N;
	static int realans;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			realans=Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j]= Integer.parseInt(s[j]);
				}
			}
			//arr=new boolean[N];
			div1 = new int[N/2];
			div2 = new int[N/2];
			divTwo(0,0);
			System.out.println("#"+t+" "+realans);
		}
		
		
			
	}
	//N개중 N/2개를 고름. ex) 6개중 3개 
	//N/2개씩 2개 배열 만듬
	private static void divTwo(int idx, int num) {	
		if(num==N/2) {
			arr=new boolean[N];
			for(int j=0; j<num;j++) {
				arr[div1[j]]=true; 
			}
			int k=0;
			for(int i=0; i<N;i++) {
				if(arr[i]==false) {
					div2[k]=i;
					k++;
				}
			}
//			System.out.println(Arrays.toString(div1));
//			System.out.println(Arrays.toString(div2));
//			System.out.println();
			
			solve(div1,div2);
			return;
		}
		if(idx==N) {
			return;
		}
		
		for(int i=idx;i<N;i++) {
			div1[num]=i;
			divTwo(i+1,num+1);
		}
	}
	private static void solve(int[] a, int[] b) {
		int sumA=0;
		int sumB=0;
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				sumA+=map[a[i]][a[j]];
				sumA+=map[a[j]][a[i]];
			}
		}
		
		for(int i=0;i<b.length-1;i++) {
			for(int j=i+1;j<b.length;j++) {
				sumB+=map[b[i]][b[j]];
				sumB+=map[b[j]][b[i]];
			}
		}
		
		int ans = Math.abs(sumA - sumB);
		realans = Math.min(ans, realans);
	}
	
	
}