package homeStudy;

import java.util.Scanner;

public class koreaNewYearHomework_2 {
	static int[] dx= {0,0,1,-1,1,1,-1,-1};
	static int[] dy= {1,-1,0,0,1,-1,1,-1};

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			int n=sc.nextInt();
			char[][] arr=new char[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					String s=sc.next();
					arr[i][j]=s.charAt(0);
				}
			}
			int high=2;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(arr[i][j]=='B') {
						int around=0;
						int findb=0;
						
						for(int dir=0;dir<8;dir++) {
							int nx=i+dx[dir];
							int ny=j+dy[dir];
							if(nx<0 || nx>=n || ny<0|| ny>=n) continue;
							if(arr[nx][ny]=='G') {
								around++;
							}
						}
						if(around==0) {
							
							for(int k=0;k<n;k++) {
								if(arr[i][k]=='B') {
									findb++;
								}
							}
							for(int k=0;k<n;k++) {
								if(arr[k][j]=='B') {
									findb++;
								}
							}
							
							if(findb>high) {
								high=findb-1;
							}
						}
					}
					
				}
			}
			System.out.println("#"+t+" "+high);
			
		}
	}

}
