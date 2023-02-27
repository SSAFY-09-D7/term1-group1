package BOJ2567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[102][102];
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		int answer = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					map[j][k] = 1;					
				}
			}
		}

		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				if(map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						
						if(nr>=0 && nr < 102 && nc >=0 && nr <102) {
							if(map[nr][nc] == 0) {
								answer++;
							}
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

}
