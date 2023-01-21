package homeStudy;

import java.util.Scanner;

public class koreaNewYearHomework_4 {
	static boolean checkboard(int nx, int ny, int n) {
		if(nx>=0 && nx<n && ny>=0 && ny<n) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n=sc.nextInt();
			int saltnum=sc.nextInt();
			int[][] board =new int[n][n];
			int[][] xyd =new int[saltnum][3];
			for(int i=0;i<saltnum;i++) {
				xyd[i][0]=sc.nextInt();//x
				xyd[i][1]=sc.nextInt();//y
				xyd[i][2]=sc.nextInt();//dir
			}
			int check=0;
			int result=saltnum;
			for(int i=0;i<saltnum;i++) {
				if(board[xyd[i][0]][xyd[i][1]]==1) {
					result--;
					continue;
				}
				else {
					if(xyd[i][2]==1) {//상
					int nx=xyd[i][0]-3;
					int ny=xyd[i][1];
					if(checkboard(nx,ny,n)) {
						if(board[nx][ny]==1) {
							result--;
							continue;
						}else {
							nx=nx-2;
						}
						if(checkboard(nx,ny,n)) {
							if(board[nx][ny]==1) {
								result--;
								continue;
							}else {
								nx=nx-1;
							}
							if(checkboard(nx,ny,n)) {
								if(board[nx][ny]==1) {
									result--;
									continue;
								}else {
									board[nx][ny]=1;
								}
							}else {
								result--;
							}
						}else {
							result--;
						}
					}else {
						result--;
					}
				}
				if(xyd[i][2]==2) {//하
					int nx=xyd[i][0]+3;
					int ny=xyd[i][1];
					if(checkboard(nx,ny,n)) {
						if(board[nx][ny]==1) {
							result--;
							continue;
						}else {
							nx=nx+2;
						}
						if(checkboard(nx,ny,n)) {
							if(board[nx][ny]==1) {
								result--;
								continue;
							}else {
								nx=nx+1;
							}
							if(checkboard(nx,ny,n)) {
								if(board[nx][ny]==1) {
									result--;
									continue;
								}else {
									board[nx][ny]=1;
								}
							}else {
								result--;
							}
						}else {
							result--;
						}
					}else {
						result--;
					}
				}
				if(xyd[i][2]==3) {//좌
					int nx=xyd[i][0];
					int ny=xyd[i][1]-3;
					if(checkboard(nx,ny,n)) {
						if(board[nx][ny]==1) {
							result--;
							continue;
						}else {
							ny=ny-2;
						}
						if(checkboard(nx,ny,n)) {
							if(board[nx][ny]==1) {
								result--;
								continue;
							}else {
								ny=ny-1;
							}
							if(checkboard(nx,ny,n)) {
								if(board[nx][ny]==1) {
									result--;
									continue;
								}else {
									board[nx][ny]=1;
								}
							}else {
								result--;
							}
						}else {
							result--;
						}
					}else {
						result--;
					}
				}
				if(xyd[i][2]==4) {//우
					int nx=xyd[i][0];
					int ny=xyd[i][1]+3;
					if(checkboard(nx,ny,n)) {
						if(board[nx][ny]==1) {
							result--;
							continue;
						}else {
							ny=ny+2;
						}
						if(checkboard(nx,ny,n)) {
							if(board[nx][ny]==1) {
								result--;
								continue;
							}else {
								ny=ny+1;
							}
							if(checkboard(nx,ny,n)) {
								if(board[nx][ny]==1) {
									result--;
									continue;
								}else {
									board[nx][ny]=1;
								}
							}else {
								result--;
							}
						}else {
							result--;
						}
					}else {
						result--;
					}
				}
				}
				
			}
			System.out.println("#"+t+" "+result);//같은 자리를 뛴 소금쟁이가 없음.
		}
	}
}