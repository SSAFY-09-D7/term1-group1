package homeStudy;

import java.util.Scanner;
import java.util.*;

public class baekjoon_15654 {
	static int n;
	static int m;
	public static void search(int idx,int[] arr, int[] arr2,boolean[] visited) {
		if(idx==m) {
			for(int i=0;i<m;i++) {
				System.out.print(arr2[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				arr2[idx]=arr[i];
				visited[i]=true;
				search(idx+1,arr,arr2,visited);
				visited[i]=false;
			}else {
				continue;
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m =sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int[] arr2=new int[m];
		boolean[] visited=new boolean[n];
		Arrays.sort(arr);
		
		search(0,arr,arr2,visited);
	}

}
