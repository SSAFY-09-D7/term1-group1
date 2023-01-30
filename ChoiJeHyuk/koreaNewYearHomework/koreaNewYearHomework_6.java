package algo42;

import java.util.Scanner;

public class koreaNewYearHomework_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[][] maze = new int[n][n];
			int startrow = sc.nextInt();
			int startcol = sc.nextInt();
			int jumpercnt = sc.nextInt();
			int[] jumper = new int[jumpercnt];
			int jumperrow, jumpercol;
			int move;
			int cnt = 0;
			
			for (int i = 0; i < jumpercnt; i++) {
				jumperrow = sc.nextInt();
				jumpercol = sc.nextInt();
				jumperrow -= 1;
				jumpercol -= 1;
				maze[jumperrow][jumpercol] = 1;
			}
			
			move = sc.nextInt();
			int[][] movearr = new int[move][2];
			startrow -=1;
			startcol -=1;
			
			
			for (int i = 0; i < move; i++) {
				movearr[i][0] = sc.nextInt();
				movearr[i][1] = sc.nextInt();
				
				if(movearr[i][0] == 1) {
					startrow -= movearr[i][1];
					if(startrow < 0) {
						System.out.println("#" + tc + " " + "0 0");
						cnt++;
						break;
					}
					else if(maze[startrow][startcol] == 1) {
						System.out.println("#" + tc + " " + "0 0");
						cnt++;
						break;
					}
					
				}
				if(movearr[i][0] == 2) {
					startcol += movearr[i][1];
					if(startcol >= n) {
						System.out.println("#" + tc + " " + "0 0");
						cnt++;
						break;
					}
					else if(maze[startrow][startcol] == 1) {
						System.out.println("#" + tc + " " + "0 0");
						cnt++;
						break;
					}
				}
				if(movearr[i][0] == 3) {
					startrow += movearr[i][1];
					if(startrow >= n) {
						System.out.println("#" + tc + " " + "0 0");
						cnt++;
						break;
					}
					else if(maze[startrow][startcol] == 1) {
						System.out.println("#" + tc + " " + "0 0");
						cnt++;
						break;
					}
				}
				if(movearr[i][0] == 4) {
					startcol -= movearr[i][1];
					if(startcol < 0) {
						System.out.println("#" + tc + " " + "0 0");
						cnt++;
						break;
					}
					else if(maze[startrow][startcol] == 1) {
						System.out.println("#" + tc + " " + "0 0");
						cnt++;
						break;
					}
				}
				
					
				
			}
			if(cnt == 0) {
				System.out.println("#" + tc + " " + (startrow+1) + " " + (startcol+1));
			}
			
			
//			for (int i = 0; i < move; i++) {
//				if(movearr[i][0] == 1) {
//					if(startrow - movearr[i][1] <0) {
//						System.out.println("#" + tc + " " + "0 0");
//						break;
//					}
//					else {
//						maze[startrow-movearr[i][1]][startcol] = 1;
//						//if()
//					}
//					
//				}
//				if(movearr[i][0] == 2) {
//					
//				}
//				if(movearr[i][0] == 3) {
//					
//				}
//				if(movearr[i][0] == 4) {
//					
//				}
//			}
			
		}
	}

}
