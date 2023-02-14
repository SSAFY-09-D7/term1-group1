import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;
	public Pair(int x,int y) {
		this.x=x;
		this.y=y;
	}
}

public class Main {
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] visited;
	static Queue<Pair> q= new LinkedList<>();
	static int w;
	static int h;
	static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt( br.readLine());
		for(int t=0;t<T;t++) {
			int cnt=0;
			
			String[] s = br.readLine().split(" ");
			w = Integer.parseInt(s[0]); //가로길이
			h = Integer.parseInt(s[1]); //세로길이
			k = Integer.parseInt(s[2]); //배추 개수 
			map=new int[h][w];
			for(int i=0;i<k;i++) {
				s = br.readLine().split(" ");
				int x = Integer.parseInt(s[0]); 
				int y = Integer.parseInt(s[1]); 
				map[y][x]=1;
			}
			visited=new int[h][w];
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(map[i][j]==1) {
						cnt++;
						bfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}

	}
	private static void bfs(int x, int y) {
		q.offer(new Pair(x,y));
		visited[x][y]=1;
		while(!q.isEmpty()) {
			Pair p=q.poll();
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				if(nx<0 || nx>=h || ny<0 || ny>=w)continue;
				if(visited[nx][ny]==1 || map[nx][ny]==0)continue;
				q.offer(new Pair(nx,ny));
				visited[nx][ny]=1;
				map[nx][ny]=0;
			}
		}
		
	}

}
