import java.util.*;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		for(int tc = 1; tc <= t; tc++) {
			int x = sc.nextInt(), y = sc.nextInt(), n = sc.nextInt();
			int ans = -1000 * n;
			int[][] arr = new int[x][y];
			int[][] jumper = new int[n][3];
			
			for(int i = 0; i < x; i++) {
				for(int j = 0; j < y; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < n; i++) {
				jumper[i][0] = sc.nextInt() - 1;
				jumper[i][1] = sc.nextInt() - 1;
				jumper[i][2] = sc.nextInt();
			}
			
			int traps = sc.nextInt();

			for(int i = 0; i < traps; i++) {
				int a = sc.nextInt(), b = sc.nextInt();
				arr[a - 1][b - 1] = -1;
			}
			
			for(int i = 0; i < n; i++) {//참가자 시뮬레이션
				int lx = jumper[i][0], ly = jumper[i][1];
				int score = 0;
				
				if (arr[lx][ly] == -1) continue;
				
				for(int j = 0; j < jumper[i][2]; j++) {//점프 횟수
					int d = arr[lx][ly] / 10 - 1, space = arr[lx][ly] - arr[lx][ly] / 10 * 10;
					lx += dx[d] * space;
					ly += dy[d] * space;
					if (lx < 0 || lx >= x || ly < 0 || ly >= y || arr[lx][ly] == -1) {
						score = 0;
						break;
					}
					score = arr[lx][ly];
				}
				
				ans += score * 100;
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
