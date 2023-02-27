
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static  int N;
	static int[][] map;
	static int Ans = 0;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		map = new int[N][N];
		
		solve(0);
		System.out.println(Ans);
	}
	
	private static void solve(int r) {
		if(r==N) {
			Ans++;
		}
	
		for(int c=0; c<N; c++) {
			if(check(r,c)) {
				map[r][c] = 1; 
				solve(r+1);
				map[r][c] = 0;
			}
		}
	}
	
	// 상 , 상좌 , 상우
	private static boolean check(int r, int c) {
		// 상
		for (int i = r-1; i >= 0; i--) {
			if(map[i][c]==1) return false;
		}
		// 상좌	
		int r1=r-1;
		int c1=c-1;

		while(r1>=0 && c1>=0) {
			if(map[r1][c1]==1)return false;
			r1--;
			c1--;
		}
		// 상우
		r1=r-1;
		c1=c+1;
		while(r1>=0 && c1<N) {
			if(map[r1][c1]==1)return false;
			r1--;
			c1++;
		}

		return true;
	}

	private static void print(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c]+" ");
			}
			System.out.println();
		}
	}
}

