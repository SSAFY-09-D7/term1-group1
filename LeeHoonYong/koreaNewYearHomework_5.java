package homeStudy;

import java.util.Iterator;
import java.util.Scanner;

public class koreaNewYearHomework_5 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int y=sc.nextInt();
			int x=sc.nextInt();
			int n=sc.nextInt();
			int money=0;
			int[][] board=new int[y+1][x+1];
			for(int i=1;i<=y;i++) {
				for(int j=1;j<=x;j++) {
					board[i][j]=sc.nextInt();
				}
			}
			int[][] stman= new int[n][3];
			for(int i=0;i<n;i++) {
				stman[i][0]=sc.nextInt();
				stman[i][1]=sc.nextInt();
				stman[i][2]=sc.nextInt();
			}
			int b=sc.nextInt();
			int[][] bomb = new int [b][2];
			for(int i=0;i<b;i++) {
				bomb[i][0]=sc.nextInt();
				bomb[i][1]=sc.nextInt();
				board[bomb[i][0]][bomb[i][1]]=0;
			}
			for(int i=0;i<n;i++) {
				int sy=stman[i][0];
				int sx=stman[i][1];
				int jump=stman[i][2];
				int check=0;
				for(int j=0;j<jump;j++) {
					int k=board[sy][sx];
					int dir= k/10;
					int jumpnum=k%10;
					if(dir==1) {
						sx+=jumpnum;
					}else if(dir==2) {
						sy+=jumpnum;
					}else if(dir==3) {
						sx-=jumpnum;
					}else {
						sy-=jumpnum;
					}
					if(sx<=0|| sx>x || sy<=0 || sy>y) {
						money=money-1000;
						check=1;
						break;
					}
				}
				if(check==0) {
					int sangum=board[sy][sx]*100;
					sangum-=1000;
					money+=sangum;
				}
			}
			System.out.println("#"+t+" "+money);
		}
		
	}

}
