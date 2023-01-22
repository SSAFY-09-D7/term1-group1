package homeStudy;

import java.util.Scanner;

public class SWEA_2806_N_Queen {
	private static int result=0;
	
	public static void back_tracking(int n, int[] arr,int idx) {
		if(idx==n) {
			result++;
			return;
		}
		for(int i=0;i<n;i++) {
			arr[idx]=i;
			
			int check2=0;
			for(int j=0;j<idx;j++) {//대각선 체크
				if(Math.abs(idx-j)==Math.abs(arr[idx]-arr[j])) {
					check2=1;
					break;
				}
			}
			if(check2==1) {
				continue;
			}
			int check=0;
			for(int j=0;j<idx;j++) {//행체크
				if(arr[j]==arr[idx]) {
					check=1;
					break;
				}
			}
			if(check==1) {
				continue;
			}
			back_tracking(n,arr,idx+1);
		}
		return;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			result=0;
			int n=sc.nextInt();
			for(int i=0;i<n;i++) {
				int[] arr = new int[n];
				arr[0]=i;//시작 0열에 스타트 만듬
				back_tracking(n,arr,1);
			}
			System.out.println("#"+t+" "+result);
		}
		
	}

}
