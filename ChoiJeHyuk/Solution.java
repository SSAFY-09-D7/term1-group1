package algo21;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int salt = sc.nextInt();
			int[][] lake = new int[n][n];
			
			int[][] saltarr = new int[salt][3];
			int answer = 0;
			
			for (int i = 0; i < salt; i++) {
				saltarr[i][0] = sc.nextInt();
				saltarr[i][1] = sc.nextInt();
				saltarr[i][2] = sc.nextInt();
				
			}
			
			for (int i = 0; i < salt; i++) {
				int cnt = 3;
				int row , col ;
				row = saltarr[i][0];
				col = saltarr[i][1];
				
				int flag = 0;
				
				if(lake[row][col] == 1) {
					System.out.println("#" + (tc+1) + " " + (i+1));
					break;
				}
				
				if(saltarr[i][2] == 1) {
					for (int j = 0; j < 3; j++) {
						row += cnt;
						if(row >= lake.length) {
							flag = -1;
							break;
						}
						else {
							if(lake[row][col] == 1) {
								System.out.println("#" + (tc+1) + " " + (i+1));
								answer = i+1;
								flag = 1;
								break;
							}
							else {
								lake[row][col] = 1;
								cnt--;
							}
						}
					}
					
					if(flag == 1) {
						break;
					}
				}
				
				else if(saltarr[i][2] == 2) {
					for (int j = 0; j < 3; j++) {
						col += cnt;
						if(col >= lake.length) {
							flag = -1;
							break;
						}
						else {
							if(lake[row][col] == 1) {
								answer = i+1;
								flag = 1;
								break;
							}
							else {
								lake[row][col] = 1;
								cnt --;
							}
						}
					}
					if(flag == 1) {
						break;
					}
				}
			}
			//System.out.println("#" + (tc+1) + " " + answer);
		}

	}

}
