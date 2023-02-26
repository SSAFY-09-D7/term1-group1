package BOJ7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static int L;
	static int[][] map;
	static int[][] move;
	static int startx,starty;
	static int movex,movey;
	static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    static int[][] v = new int[301][301];
    static int answer = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			L = Integer.parseInt(br.readLine());
			map = new int[L][L];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			startx = Integer.parseInt(st.nextToken());
			starty = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			movex = Integer.parseInt(st.nextToken());
			movey = Integer.parseInt(st.nextToken());
			
			setv();
			bfs(startx,starty,movex,movey);
			
			System.out.println(v[movex][movey]);
		}
		
		
	}
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	private static void bfs(int r, int c, int x, int y) {

		Queue<Point> Q = new LinkedList();
		v[r][c] = 0;

		Q.offer(new Point(r, c));

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			if(p.r == x && p.c == y) break;
			for (int d = 0; d < 8; d++) {
				int nr = p.r + dx[d];
				int nc = p.c + dy[d];
				// 지도안에 있다면
				if (nr >= 0 && nr < L && nc >= 0 && nc < L &&  (v[nr][nc]==-1 || v[p.r][p.c]+1 < v[nr][nc])) {
					v[nr][nc] = v[p.r][p.c]+1;
					Q.add(new Point(nr, nc));
				}
			}
		}
	}
    public static void setv(){
        for(int i=0;i<=300;i++)
            for(int j=0;j<=300;j++)
                v[i][j]=-1;
    }

}
