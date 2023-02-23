package BOJ1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			String[] str = s.split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				//map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0,0,N);
		
		
	}

	private static void cut(int r, int c, int size) {
		
		int sum = 0;
		for (int i = r, rEnd = r+ size; i < rEnd; i++) {
			for (int j = c, cEnd = c + size; j< cEnd; j++) {
				sum += map[i][j];
			}
		}
		if(sum == size * size) {
			System.out.print("1");
		}
		else if(sum == 0) {
			System.out.print("0");
		}
		else {
			int half = size/2;
			System.out.print("(");
			cut(r,c,half);
			cut(r,c+half, half);
			cut(r+half,c,half);
			cut(r+half,c+half,half);
			System.out.print(")");
		}
		
		
	}

}
