import java.util.*;
import java.io.*;

public class BOJ17281 {
	static int N;
	static int[][] arr;
	static int[] sel;
	static int[] v;
	static int ans;
	
	static void play_ball() {
		int score = 0, player = 0;

		for(int i = 0; i < N; i++) {
			int out = 0;
			int[] base = new int[3];

			while(true) {
				int result = arr[i][sel[player++]];
				player %= 9;
				
				if (result == 0) {
					if (++out == 3) {
						base[0] = base[1] = base[2] = out = 0;
						break;
					}
				}else if (result == 1) {
					score += base[2];
					base[2] = base[1];
					base[1] = base[0];
					base[0] = 1;
				}else if (result == 2) {
					score += base[2] + base[1];
					base[2] = base[0];
					base[1] = 1;base[0] = 0;
				}else if (result == 3) {
					score += base[2] + base[1] + base[0];
					base[2] = 1;base[0] = base[1] = 0;
				}else if (result == 4) {
					score += base[2] + base[1] + base[0] + 1;
					base[2] = base[1] = base[0] = 0;
				}
			}
		}

		ans = Math.max(ans, score);
	}
	
	static void solve(int k) {
		if (k == 9) {
			play_ball();
			return;
		}
		
		if (k == 3) {
			solve(k + 1);
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if (v[i] == 1) continue;
			
			v[i] = 1;
			sel[k] = i;
			solve(k + 1);
			v[i] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		v = new int[9];
		sel = new int[9];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		v[0] = 1;
		solve(0);
		
		System.out.println(ans);
	}
}
