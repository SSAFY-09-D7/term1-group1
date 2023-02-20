import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y =y;
	}
}
public class Solution {
	
	static char[][] map;
	static int[][] v;
	static int click;
	static int N;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N =Integer.parseInt(br.readLine());
			map = new char[N][N];
			v = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			click=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') {
						int zero = search(i,j);
						if(zero==0) {
							bfs(i,j);
						}
						
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') {
						int count = search(i,j);
						map[i][j]=(char)(count+'0');
						click++;
					}
				}
			}
			
			
			System.out.println("#"+t+" "+click);
		}
	}
	
	
	static int[] dx = {0,1,0,-1,1,1,-1,-1};
	static int[] dy = {1,0,-1,0,1,-1,1,-1};
	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		
		int num=search(i,j);
		map[i][j]=(char)(num+'0');
		
		q.offer(new Point(i,j));
		v[i][j]=1;
		
		click++;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int dir=0;dir<8;dir++) {
				int nx = p.x + dx[dir];
				int ny = p.y + dy[dir];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(v[nx][ny]==1) continue;
				if(map[nx][ny]!='.')continue;
								
				num=search(nx,ny);
				map[nx][ny]=(char)(num+'0');
				v[nx][ny] = 1;
				if(num==0) {
					q.offer(new Point(nx,ny));
					v[nx][ny] = 1;
				}
			}
			
		}
		
	}
	static int[] dr = {0,1,0,-1,1,1,-1,-1};
	static int[] dc = {1,0,-1,0,1,-1,1,-1};
	private static int search(int x, int y) {
		int num=0;
		for (int i = 0; i <8; i++) {
			int nx = x +dr[i];
			int ny = y +dc[i];
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(map[nx][ny]=='*') {
				num++;
			}
		}
		return num;
	}

	
}