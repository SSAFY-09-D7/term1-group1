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
	static int[] dx = {1,0,-1,0,1,-1,1,-1};
	static int[] dy = {0,1,0,-1,1,-1,-1,1};
	static int[][] visited;
	static Queue<Pair> q= new LinkedList<>();
	static int w;
	static int h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int cnt=0;
			String[] s = br.readLine().split(" ");
			w = Integer.parseInt(s[0]);
			h = Integer.parseInt(s[1]);
			if(w==0 && h==0) {
				break;
			}
			map=new int[h][w];
			visited=new int[h][w];
			for (int i = 0; i < h; i++) {
				s=br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					map[i][j]=Integer.parseInt(s[j]);
				}
			}
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
			for(int i=0;i<8;i++) {
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
