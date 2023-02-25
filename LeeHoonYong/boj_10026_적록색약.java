import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {
	static class Point{
		int r;
		int c;
		Point(int r, int c){
			this.r= r;
			this.c=c;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =	Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		char[][] map2 = new char[N][N];
		
		boolean[][] v = new boolean[N][N];
		boolean[][] v2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if(s.charAt(j)=='G') {
					map[i][j]= s.charAt(j);
					map2[i][j]= 'R';
				}else {
					map[i][j]= s.charAt(j);
					map2[i][j]= s.charAt(j);					
				}
			}
		}
		
		int[] dr= {0,1,0,-1};
		int[] dc= {1,0,-1,0};
		Queue<Point> q = new ArrayDeque<>();
		int level=0;
		int level2=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='R' || map[i][j]=='G' || map[i][j]=='B'){
					level++;
					q.offer(new Point(i,j));
					v[i][j]=true;
					int now=map[i][j];
					map[i][j]='.';
					while(!q.isEmpty()) {
						Point p = q.poll();
						
						for (int dir = 0; dir < 4; dir++) {
							int nr= p.r + dr[dir];
							int nc= p.c + dc[dir];
							if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
							if(v[nr][nc]) continue;
							if(now==map[nr][nc]) {
								q.offer(new Point(nr,nc));
								v[nr][nc]=true;							
								map[nr][nc]='.';
							}
						}		
					}
				}
				
				if(map2[i][j]=='R' || map2[i][j]=='G' || map2[i][j]=='B'){
					level2++;
					q.offer(new Point(i,j));
					v2[i][j]=true;
					int now=map2[i][j];
					map2[i][j]='.';
					while(!q.isEmpty()) {
						Point p = q.poll();
						
						for (int dir = 0; dir < 4; dir++) {
							int nr= p.r + dr[dir];
							int nc= p.c + dc[dir];
							if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
							if(v2[nr][nc]) continue;
							if(now==map2[nr][nc]) {
								q.offer(new Point(nr,nc));
								v2[nr][nc]=true;							
								map2[nr][nc]='.';
							}
						}		
					}
				}
			}
		}
		System.out.println(level+" "+level2);
	}

	
}
