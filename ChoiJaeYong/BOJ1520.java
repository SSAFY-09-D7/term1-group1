import java.util.*;
import java.io.*;

//상하좌우
public class BOJ1520 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] arr;
	static int[][] visited;
	static int M, N;
	static int[][] routes;
	
	static int traverse(int x, int y) {
		if (x == M - 1 && y == N - 1) {
			routes[x][y] = 1;
			return 1;
		}
		
		for(int k = 0; k < 4; k++) {
			int nx = x + dx[k], ny = y + dy[k];
			
			if (nx >= 0 && nx < M && ny >= 0 && ny < N && arr[nx][ny] < arr[x][y]) {
				if (visited[nx][ny] == 0) {
					visited[nx][ny] = 1;	
					routes[x][y] += traverse(nx, ny);
				}else routes[x][y] += routes[nx][ny];
			}
		}
		
		return routes[x][y];
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visited = new int[M][N];
        routes = new int[M][N];
        
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	for(int j = 0; j < N; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        visited[0][0] = 1;
        traverse(0, 0);
        System.out.println(routes[0][0]);
    }
}
