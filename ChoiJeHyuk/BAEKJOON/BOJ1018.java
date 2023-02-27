package BOJ1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static char[][] map;
	static int min;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				check(i,j);
				answer = Math.min(answer, min);
			}
		}
		System.out.println(answer);
	}
	private static void check(int r, int c) {
		int black = 0;
		int white = 0;
		for (int i = r; i < r+8; i++) {
			for (int j = c; j < c+8; j++) {
				if((i + j) % 2 == 0) {
					if(map[i][j] == 'B') white++;
					else black++;
				}else {
					if(map[i][j] == 'W') white++;
					else black++;
				}
				
			}
		}
		min = Math.min(black, white);
		//System.out.println(white + " " +black + " " + min);
		
	}
	
	

}
