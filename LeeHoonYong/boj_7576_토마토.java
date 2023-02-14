import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
	int x;
	int y;
	int level;
	public Pair(int x,int y,int level) {
		this.x=x;
		this.y=y;
		this.level=level;
	}
}

public class Main2 {
	static int[][] map;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] visited;
	static Queue<Pair> q= new LinkedList<>();
	static int w;
	static int h;
//	static int k;
	
	static int num=0;
	static ArrayList<Integer> numArray;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int cnt=0;

		String[] s = br.readLine().split(" ");
		w =Integer.parseInt(s[0]);
		h =Integer.parseInt(s[1]);
		map=new int[h][w];
		for(int i=0;i<h;i++) {
			s=br.readLine().split(" ");
			for(int j=0;j<w;j++) {
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		visited=new int[h][w];
		//numArray= new ArrayList<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				//num=0;
				if(map[i][j]==1) {
					q.offer(new Pair(i,j,0));
					visited[i][j]=1;
				}
			}
		}
		bfs();
		


	}
	private static void bfs() {
		int k=0;
		while(!q.isEmpty()) {
			Pair p=q.poll();
			k=p.level;
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				if(nx<0 || nx>=h || ny<0 || ny>=w)continue;
				if(visited[nx][ny]==1 || map[nx][ny]==-1 || map[nx][ny]==1)continue;
				q.offer(new Pair(nx,ny,p.level+1));
				visited[nx][ny]=1;
				map[nx][ny]=1;
			}
		}
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(k);

	}

}
