import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;



public class Solution {
	static class Point{
		int r;
		int c;
		int t;
		Point(int r, int c, int t){
			this.r=r;
			this.c=c;
			this.t=t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T =	Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++) {
			int flag=0;
			String[] s = br.readLine().split(" ");
			int N =Integer.parseInt(s[0]);
			int M =Integer.parseInt(s[1]);
			int R =Integer.parseInt(s[2]);
			int C =Integer.parseInt(s[3]);
			int L =Integer.parseInt(s[4]);

			int[][] map = new int[N][M];
			boolean[][] v= new boolean[N][M];

			for (int i = 0; i < N; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j < M; j++) {
					map[i][j]=Integer.parseInt(s[j]);
				}
			}
			int ans=0;
			int[] dr = {-1,1,0,0,-1,-1,1,1};//상,하,좌,우,상우,상좌,하우,하좌
			int[] dc = {0,0,-1,1,1,-1,1,-1};//0 1  2 3  4  5   6   7			

			Queue<Point> q = new ArrayDeque<Point>();
			q.offer(new Point(R,C,1));
			v[R][C]=true;
			//map[R][C]=-1;


			while(!q.isEmpty()) {
				Point p = q.poll();
				
				int now =map[p.r][p.c];
				
				for (int dir = 0; dir < 4; dir++) {
					
					
					int nr =p.r+dr[dir];
					int nc =p.c+dc[dir];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
					if(map[nr][nc]==0)continue;
					if(v[nr][nc]==true) continue;
					if(now==1) { // 0,1,2,3		
						if(dir==0) {//상
							if(map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==7) continue;
						}
						if(dir==1) {//하
							if(map[nr][nc]==3 || map[nr][nc]==5 || map[nr][nc]==6) continue;
						}
						if(dir==2) {//좌
							if(map[nr][nc]==2 || map[nr][nc]==6 || map[nr][nc]==7) continue;
						}
						if(dir==3) {//우
							if(map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==5) continue;
						}
					}
					else if(now==2) {// 0,1 상하
						if(dir==2 || dir==3)continue;
						if(dir==0) {//상
							if(map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==7) continue;
						}
						if(dir==1) {//하
							if(map[nr][nc]==3 || map[nr][nc]==5 || map[nr][nc]==6) continue;
						}
					}
					else if(now==3) {// 2, 3 좌우
						if(dir==0 || dir==1)continue;
						if(dir==2) { //좌
							if(map[nr][nc]==2 || map[nr][nc]==6 || map[nr][nc]==7) continue;
						}
						if(dir==3) { //우
							if(map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==5) continue;
						}
						
					}
					else if(now==4) {//4 상우
						if( dir==1|| dir==2)continue;
						if(dir==0) {//상
							if(map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==7) continue;
						}
						if(dir==3) { //우
							if(map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==5) continue;
						}
					}
					else if(now==5) {//6 하우
						if(dir==0 || dir==2)continue;
						if(dir==1) {//하
							if(map[nr][nc]==3 || map[nr][nc]==5 || map[nr][nc]==6) continue;
						}
						if(dir==3) { //우
							if(map[nr][nc]==2 || map[nr][nc]==4 || map[nr][nc]==5) continue;
						}
					}
					else if(now==6) {//7 하좌
						if(dir==0 || dir==3)continue;
						if(dir==1) {//하
							if(map[nr][nc]==3 || map[nr][nc]==5 || map[nr][nc]==6) continue;
						}
						if(dir==2) { //좌
							if(map[nr][nc]==2 || map[nr][nc]==6 || map[nr][nc]==7) continue;
						}
					}
					else if(now==7) {//5 상좌
						if(dir==1|| dir==3)continue;
						if(dir==0) {//상
							if(map[nr][nc]==3 || map[nr][nc]==4 || map[nr][nc]==7) continue;
						}
						if(dir==2) { //좌
							if(map[nr][nc]==2 || map[nr][nc]==6 || map[nr][nc]==7) continue;
						}
					}					
					if(p.t==L) {
						continue;
					}
					q.offer(new Point(nr,nc,p.t+1));
					v[nr][nc]=true;
				}


			}


			int num=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(v[i][j]==true) {
						num++;
					}
				}
			}
			ans=num;
			System.out.println("#"+t+" "+ans);


		}
	}
}