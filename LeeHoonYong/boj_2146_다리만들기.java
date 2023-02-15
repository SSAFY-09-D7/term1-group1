import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// solution
// 1. 총 bfs를 두번 돌려줌
// 2. map 배열을 Point 형으로 선언. value와 island를 받음.
// island= 섬의 번호
// 첫번째 bfs에서는 각 인덱스마다 섬의 번호를 매겨줌.
//1 1 1 0 0 0 0 2 2 2 
//1 1 1 1 0 0 0 0 2 2 
//1 0 1 1 0 0 0 0 2 2 
//0 0 1 1 1 0 0 0 0 2 
//0 0 0 1 0 0 0 0 0 2 
//0 0 0 0 0 0 0 0 0 2 
//0 0 0 0 0 0 0 0 0 0 
//0 0 0 0 3 3 0 0 0 0 
//0 0 0 0 3 3 3 0 0 0 
//0 0 0 0 0 0 0 0 0 0
//두번째 bfs
//첫번째 bfs후 나온 map 배열을 활용
// bfs는 0이 아니면 실행 
// 각 단계별 level을 표시하는게 필요해서 Pair2 class 활용
// bfs 시작점의 섬의 번호가 아니면서 0이 아닌 인덱스를 만나면 level 출력
class Point{
	int value=0;
	int island=0;
	Point(int value, int island){
		this.value=value;
		this.island=island;
	}
}

class Pair{
	int r;
	int c;
	Pair(int r, int c){
		this.r=r;
		this.c=c;
	}
}

class Pair2{
	int r;
	int c;
	int level;
	Pair2(int r, int c, int level){
		this.r=r;
		this.c=c;
		this.level=level;
	}
}

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Point[][] map;
	static int[][] v1;
	static int[][] v2;
	static int N;
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map=new Point[N][N];
		v1 = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] =new Point(Integer.parseInt(s[j]),0);
			}
		}
		int island=1;
		for (int i = 0; i < N; i++) {	
			for (int j = 0; j < N; j++) {
				if(map[i][j].value == 1 && v1[i][j]==0) {
					bfs1(i, j, island);	
					island++;
				}
			}
		}
		//입력 배열 완료.
		
//		for (int i = 0; i < N; i++) {	
//			for (int j = 0; j < N; j++) {			
//				System.out.print(map[i][j].island+" ");
//			}
//			System.out.println();
//		}
		
		for (int i = 0; i < N; i++) {	
			for (int j = 0; j < N; j++) {
				if(map[i][j].value == 1) {
					bfs2(i,j,map[i][j].island);
				}
			}
		}
		System.out.println(result);
		
	}
	
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	
	private static void bfs1(int r, int c,int island) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(r,c));
		v1[r][c]=1;
		map[r][c].island = island;
		while(!q.isEmpty()) {
			
			Pair p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N 
						&& map[nr][nc].value==1 
						&& v1[nr][nc]==0 ) {
					
					q.offer(new Pair(nr,nc));
					v1[nr][nc]=1;			
					map[nr][nc].island= map[p.r][p.c].island;			
				}			
			}
		}
		
	}
	
	private static void bfs2(int r, int c,int island) {
		Queue<Pair2> q = new LinkedList<>();
		
		v2 = new int[N][N]; //bfs할때마다 방문배열 초기화
		q.offer(new Pair2(r,c,0));
		v2[r][c]=1;
		
		while(!q.isEmpty()) {
			
			Pair2 p = q.poll();

			for (int i = 0; i < 4; i++) {
				
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N //배열 범위 벗어나지 않고
						//0이여도 이 조건에 걸림.
						&& map[nr][nc].island!=island  // 처음 시작한 섬의 번호와 다르고
						&& v2[nr][nc]==0 ) { //방문한 곳이 아닐때
					
					q.offer(new Pair2(nr,nc,p.level+1));					
					v2[nr][nc]=1;
					
					//종료 조건
					if(map[nr][nc].island!=0 && map[nr][nc].island!=island) {
						result=Math.min(result, p.level);
						return;
					}
				}			
			}
		}		
	}
}
