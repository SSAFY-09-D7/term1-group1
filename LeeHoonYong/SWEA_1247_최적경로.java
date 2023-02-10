import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int minDist =100000;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			minDist =100000;
			int N=Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			int[][] arr = new int[N+2][2];
			int[] dist = new int[N];
			boolean[] vis = new boolean[N];
			int k=0; int a=0;
			for(int i=0;i<s.length;i++) {
				if(i%2==0) {
					arr[k][0]=Integer.parseInt(s[i]);
					a++;
				}else {
					arr[k][1]=Integer.parseInt(s[i]);
					a++;
				}
				if(a%2==0) {
					k++;
				}
			}
//			for(int i=0;i<arr.length;i++) {
//				System.out.println(arr[i][0]+" "+arr[i][1]);
//			}
			
			recursive(arr,dist,0,vis);
			System.out.println("#"+t+" "+minDist);
		}
	}

	private static void recursive(int[][] arr,int[] dist, int idx,boolean[] vis) {
		if(idx==dist.length) {
//			for(int i=0;i<dist.length;i++) {
//				System.out.print(dist[i]+" ");
//			}
//			System.out.println();
			int sum=0;
			for(int i=0;i<dist.length+1;i++) {
				if(i==0) {//회사에서 고객 처음
					sum+=Math.abs(arr[0][0]-arr[dist[i]+2][0])+Math.abs(arr[0][1]-arr[dist[i]+2][1]);
				}
				else if(i==dist.length) {//고객에서 집 마지막
					sum+=Math.abs(arr[1][0]-arr[dist[i-1]+2][0])+Math.abs(arr[1][1]-arr[dist[i-1]+2][1]);
					
				}else {
					sum+=Math.abs(arr[dist[i]+2][0]-arr[dist[i-1]+2][0])+Math.abs(arr[dist[i]+2][1]-arr[dist[i-1]+2][1]);
				}
			}
			//System.out.println("sum"+sum);
			minDist=Math.min(minDist, sum);
			return;
		}
		for(int i=0;i<dist.length;i++) {
			if(vis[i]==false) {
				vis[i]=true;
				dist[idx]=i;
				recursive(arr,dist,idx+1,vis);
				vis[i]=false;
			}
		}	
	}
	

}
