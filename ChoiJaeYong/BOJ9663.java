package test;

import java.util.*;

//최적화 필요..
public class BOJ9663 {
	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[] not;
	static int ans;
	
	//arr에는 열 정보만 담고, 인덱스가 행 역할
	static void solve(int[] arr, int row) {//행은 항상 겹치지 않는다.
		if (row >= N) {
			ans++;
			return;	
		}
		
		for(int i = 0; i < N; i++) {//놓으려는 열, 행은 row
			boolean can = true;
			
			for(int j = 0; j < row; j++) {//놓은 거
				int r = j, c = arr[j];
				
				//대각선 관계거나 같은 열이면 안됨
				if (Math.abs(r - row) == Math.abs(c - i) || i == c) {
					can = false;
					break;
				}
			}
			
			if (can) {
				arr[row] = i;//배치
				solve(arr, row + 1);
				arr[row] = 0;//제거
			}
		}
	}
	
	public static void main(String[] args) {
		N = Integer.parseInt(sc.nextLine());
		not = new int[N];
		
		solve(new int[N], 0);
		
		System.out.println(ans);
		
		sc.close();
	}
}
