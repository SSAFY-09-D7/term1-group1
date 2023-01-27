import java.util.Arrays;
import java.util.Scanner;

public class koreaNewYearHomework_4 {
	static int[] direction = {0, 3, 5, 6};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(), runners = sc.nextInt();
			int[][] visited = new int[n][n];
			int ans = runners;
			
			for(int i = 1; i <= runners; i++) {
				int x = sc.nextInt(), y = sc.nextInt(), d = sc.nextInt();

				if (d == 1) {//상
					for(int k = 0; k < 4; k++) {
						if (!(x - direction[k] >= 0)) {
							ans--;
							break;
						}
						if(visited[x - direction[k]][y] == 1) {
							ans--;
							break;
						}
						if(k == 3) visited[x - direction[k]][y] = 1;
					}
				}else if(d == 2) {//하
					for(int k = 0; k < 4; k++) {
						if (!(x + direction[k] < n)) {
							ans--;
							break;
						}
						if (visited[x + direction[k]][y] == 1) {
							ans--;
							break;
						}
						if (k == 3) visited[x + direction[k]][y] = 1;
					}
				}else if(d == 3) {//좌
					for(int k = 0; k < 4; k++) {
						if (!(y - direction[k] >= 0)) {
							ans--;
							break;
						}
						if (visited[x][y - direction[k]] == 1) {
							ans--;
							break;
						}
						if (k == 3) visited[x][y - direction[k]] = 1;
					}
				}else {//우
					for(int k = 0; k < 4; k++) {
						if (!(y + direction[k] < n)) {
							ans--;
							break;
						}
						if (visited[x][y + direction[k]] == 1) {
							ans--;
							break;
						}
						if (k == 3) visited[x][y + direction[k]] = 1;
					}
				}
			}
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
