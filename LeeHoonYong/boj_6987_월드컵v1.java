import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	static int[][] res;
	static int[] ans;
	static int R;
	static int C;
	static int[][] ex1;
	static int[][] ex2;
	static int[][] ex3;
	static int[][] ex4;
	static int[][] roundarr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr =new int[4][18];
		for (int i = 0; i < 4; i++) {
			String[] s =br.readLine().split(" ");	
			for (int j = 0; j < 18; j++) {
				arr[i][j]=Integer.parseInt(s[j]);
			}
		}

		ans = new int[4];
		res = new int[6][3];
		ex1 = new int[6][3];
		ex2 = new int[6][3];
		ex3 = new int[6][3];
		ex4 = new int[6][3];
		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if(k==0) {
						ex1[i][j]=arr[k][3*i+j];
					}else if(k==1) {
						ex2[i][j]=arr[k][3*i+j];
					}else if(k==2) {
						ex3[i][j]=arr[k][3*i+j];
					}else if(k==3) {
						ex4[i][j]=arr[k][3*i+j];
					}
				}
			}			
		}
	//	print(ex1);

		roundarr= new int[15][2];
		int k=0;
		for (int i = 0; i < 5; i++) {
			for (int j = i+1; j < 6; j++) {
				roundarr[k][0] =i;
				roundarr[k][1]= j;
				k++;
			}
		}

		solve(0);

		for (int i = 0; i < 4; i++) {
			System.out.print(ans[i]+" ");
		}


	}

//	private static void print(int[][] ex1) {
//		for(int i=0;i<6;i++) {
//			for(int j=0;j<3;j++) {
//				System.out.print(ex1[i][j]+" ");
//			}
//			System.out.println();
//		}
//
//	}

	private static void solve(int idx) {

		if(idx==15) {

			int num1=0;
			int num2=0;
			int num3=0;
			int num4=0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if(ex1[i][j]==res[i][j]) {
						num1++;
					}
					if(ex2[i][j]==res[i][j]) {
						num2++;
					}
					if(ex3[i][j]==res[i][j]) {
						num3++;
					}
					if(ex4[i][j]==res[i][j]) {
						num4++;
					}
				}
			}
			if(num1==18) {
				ans[0]=1;
			}
			if(num2==18) {
				ans[1]=1;
			}
			if(num3==18) {
				ans[2]=1;
			}
			if(num4==18) {
				ans[3]=1;
			}

			return;
		}


		//  팀1 승리
		res[roundarr[idx][0]][0]++;
		res[roundarr[idx][1]][2]++;
		solve(idx+1);
		res[roundarr[idx][0]][0]--;
		res[roundarr[idx][1]][2]--;
		// 팀1 무승부
		res[roundarr[idx][0]][1]++;
		res[roundarr[idx][1]][1]++;
		solve(idx+1);
		res[roundarr[idx][0]][1]--;
		res[roundarr[idx][1]][1]--;
		// 팀1 패배
		res[roundarr[idx][0]][2]++;
		res[roundarr[idx][1]][0]++;
		solve(idx+1);
		res[roundarr[idx][0]][2]--;
		res[roundarr[idx][1]][0]--;

	}
}
