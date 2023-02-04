import java.io.*;
import java.util.StringTokenizer;

public class Swea7964 {
	static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	static int N, M;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			arr[N / 2][N / 2] = arr[N / 2 - 1][N / 2 - 1] = 2;
			arr[N / 2 - 1][N / 2] = arr[N / 2][N / 2 - 1] = 1;
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int ty = Integer.parseInt(st.nextToken()) - 1, tx = Integer.parseInt(st.nextToken()) - 1, color = Integer.parseInt(st.nextToken());

				arr[tx][ty] = color;

				for(int k = 0; k < 8; k++) {
					int x = tx + dx[k], y = ty + dy[k];
					
					while(!(x < 0 || x >= N || y < 0 || y >= N || arr[x][y] == 0)) {
						if (arr[x][y] == color) {
							for(int space = 1; space < Math.max(Math.abs(tx - x), Math.abs(ty - y)); space++) {
								arr[tx + dx[k] * space][ty + dy[k] * space] = color;
							}
							break;
						}else {
							x += dx[k]; y += dy[k];
						}
					}
				}
			}
			
			int black = 0, white = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 1) black++;
					else if (arr[i][j] == 2) white++;
				}
			}
			sb.append(black+" "+white+"\n");
		}
		
		System.out.println(sb);
	}
}
