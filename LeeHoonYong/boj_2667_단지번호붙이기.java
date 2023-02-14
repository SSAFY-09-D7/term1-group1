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
//	static int w;
//	static int h;
//	static int k;
	static int N;
	static int num;
	static ArrayList<Integer> numArray;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int cnt=0;

		N = Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=(int)s.charAt(j)-'0';
			}
		}
		visited=new int[N][N];
		numArray= new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				num=0;
				if(map[i][j]==1) {
					cnt++;
					bfs(i,j);
					numArray.add(num);
				}
			}
		}
		System.out.println(cnt);
		Collections.sort(numArray);
		for (int i = 0; i < numArray.size(); i++) {
			System.out.println(numArray.get(i));
		}


	}
	private static void bfs(int x, int y) {
		q.offer(new Pair(x,y));
		visited[x][y]=1;
		while(!q.isEmpty()) {
			Pair p=q.poll();
			num++;
			for(int i=0;i<4;i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
				if(nx<0 || nx>=N || ny<0 || ny>=N)continue;
				if(visited[nx][ny]==1 || map[nx][ny]==0)continue;
				q.offer(new Pair(nx,ny));
				visited[nx][ny]=1;
				map[nx][ny]=0;
			}
		}

	}

}
