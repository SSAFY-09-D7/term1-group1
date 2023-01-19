package homeStudy;

import java.util.Scanner;

public class koreaNewYearHomework_3 {
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
		
			for(int i=0;i<saltnum;i++) {
				
				board[xyd[i][0]][xyd[i][1]]=1;
				if(xyd[i][2]==1) {//하
					int nx=xyd[i][0]+3;
					int ny=xyd[i][1];
					if(checkboard(nx,ny,n)) {
						if(board[nx][ny]==1) {
							System.out.println("#"+t+" "+(i+1));
							check=1;
							break;
						}
						board[nx][ny]=1;
						nx=nx+2;
						if(checkboard(nx,ny,n)) {
							if(board[nx][ny]==1) {
								System.out.println("#"+t+" "+(i+1));
								check=1;
								break;
							}
							board[nx][ny]=1;
							nx=nx+1;
							if(checkboard(nx,ny,n)) {
								if(board[nx][ny]==1) {
									System.out.println("#"+t+" "+(i+1));
									check=1;
									break;
								}
								board[nx][ny]=1;
							}
						}
					}
				}
				if(xyd[i][2]==2) {//우
					int nx=xyd[i][0];
					int ny=xyd[i][1]+3;
					if(checkboard(nx,ny,n)) {
						if(board[nx][ny]==1) {
							System.out.println("#"+t+" "+(i+1));
							check=1;
							break;
						}
						board[nx][ny]=1;
						ny=ny+2;
						if(checkboard(nx,ny,n)) {
							if(board[nx][ny]==1) {
								System.out.println("#"+t+" "+(i+1));
								check=1;
								break;
							}
							board[nx][ny]=1;
							ny=ny+1;
							if(checkboard(nx,ny,n)) {
								if(board[nx][ny]==1) {
									System.out.println("#"+t+" "+(i+1));
									check=1;
									break;
								}
								board[nx][ny]=1;	
							}
						}
					}
					
				}
			}
			if(check==0) {
				System.out.println("#"+t+" "+0);//같은 자리를 뛴 소금쟁이가 없음.
			}
		}

	}

}
