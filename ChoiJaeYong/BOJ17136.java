import java.io.*;
import java.util.*;

public class BOJ17136 {
	static int ans = Integer.MAX_VALUE;
	static int[][] arr = new int[10][10];
	static int[] papers = new int[6];
	static int cnt = 0;
	
	static {
		papers[1] = papers[2] = papers[3] = papers[4] = papers[5] = 5;
	}
	
	static void solved() {
		int sum = 0;
		
		for(int i = 1; i <= 5; i++) sum += papers[i];
		
		ans = Math.min(ans, 25 - sum);
		
		return;
	}
	
	static boolean check(int x, int y, int psize) {
		if (!(x + psize <= 10 && y + psize <= 10)) return false;
		
		for(int i = x; i < x + psize; i++) {
			for(int j = y; j < y + psize; j++) {
				if(arr[i][j] == 0) return false;
			}
		}
		
		return true;
	}
	
	static void solve(int x, int y, int ones) {
		//x, y는 확실히 1인 곳
		for(int psize = 1; psize <= 5; psize++) {
			//범위 넘어가거나 범위에 0이 포함된 경우 == false
			
			if (papers[psize] == 0 || check(x, y, psize) == false) continue;
			
			//범위 종이 놓기
			for(int j = x; j < x + psize; j++) {
				for(int k = y; k < y + psize; k++) {
					arr[j][k] = 0;
				}
			}
			
			ones -= psize * psize;
			papers[psize] -= 1;
			
			if (ones == 0) {
				solved();
			}else {
				//다음 좌표 조정
				Outter: for(int j = 0; j < 10; j++) {
					for(int k = 0; k < 10; k++) {
						if (arr[j][k] == 1) {
							solve(j, k, ones);
							break Outter;
						}
					}
				}
			}
			
			papers[psize] += 1;
			
			//범위 종이 제거
			for(int j = x; j < x + psize; j++) {
				for(int k = y; k < y + psize; k++) {
					arr[j][k] = 1;
				}
			}
			
			ones += psize * psize;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) cnt++;
			}
		}
		
		Outter: for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(arr[i][j] == 1) {
					solve(i, j, cnt);
					break Outter;
				}
			}
		}

		if (cnt == 0) System.out.println(0);
		else if (ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
}
