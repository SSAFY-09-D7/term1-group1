package homeStudy;

import java.util.Scanner;

public class baekjoon_15652 {
	static int n;
	static int m;
	public static void search(int i,int k,int[] arr) {
		if(i==m) {
			arr[i]=k;
			for(int j=1;j<=m;j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int j=k;j<=n;j++) {
			arr[i]=k;
			search(i+1,j,arr);
		}
	}

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		int[] arr=new int[m+1];
		
		for(int i=1;i<=n;i++) {
			search(1,i,arr);
		}
		

	}

}
