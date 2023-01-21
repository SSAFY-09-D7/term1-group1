package homeStudy;

import java.util.Scanner;

public class koreaNewYearHomework_6 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n=sc.nextInt();
			int board[][]=new int[n+1][n+1];
			int stx=sc.nextInt();
			int sty=sc.nextInt();
			int jumper=sc.nextInt();
			int[][] jumpers=new int[jumper][2];
			for(int i=0;i<jumper;i++) {
				jumpers[i][0]=sc.nextInt();
				jumpers[i][1]=sc.nextInt();
				board[jumpers[i][0]][jumpers[i][1]]=1;
			}
			int move=sc.nextInt();
			int[][] moves=new int[move][2];
			for(int i=0;i<move;i++) {
				moves[i][0]=sc.nextInt();
				moves[i][1]=sc.nextInt();
			}
			int rex=0;
			int rey=0;
			int check=0;
			for(int i=0;i<move;i++) {
				check=0;
				for(int j=0;j<moves[i][1];j++) {
					if(moves[i][0]==1) {
						stx-=1;
						if(stx<=0 || stx>n || sty<=0|| sty>n) {
							check=1;
							break;
						}
						for(int k=0;k<jumper;k++) {
							if(stx==jumpers[k][0] &&sty==jumpers[k][1]) {
								check=1;
								break;
							}
						}
						if(check==1) {
							break;
						}	
					}else if(moves[i][0]==2) {
						sty+=1;
						if(stx<=0 || stx>n || sty<=0|| sty>n) {
							check=1;
							break;
						}
						for(int k=0;k<jumper;k++) {
							if(stx==jumpers[k][0] &&sty==jumpers[k][1]) {
								check=1;
								break;
							}
						}
						if(check==1) {
							break;
						}
					}else if(moves[i][0]==3) {
						stx+=1;
						if(stx<=0 || stx>n || sty<=0|| sty>n) {
							check=1;
							break;
						}
						for(int k=0;k<jumper;k++) {
							if(stx==jumpers[k][0] &&sty==jumpers[k][1]) {
								check=1;
								break;
							}
						}
						if(check==1) {
							break;
						}
					}else {
						sty-=1;
						if(stx<=0 || stx>n || sty<=0|| sty>n) {
							check=1;
							break;
						}
						for(int k=0;k<jumper;k++) {
							if(stx==jumpers[k][0] &&sty==jumpers[k][1]) {
								check=1;
								break;
							}
						}
						if(check==1) {
							break;
						}
					}
				}
				if(check==1) {
					break;
				}
			}
			if(check==1) {
				System.out.println("#t"+t+" "+0+" "+0);
			}else {
				rex=stx;
				rey=sty;
				System.out.println("#"+t+" "+rex+" "+rey);
			}
		}
	}

}
