import java.util.*;

public class koreaNewYearHomework_2 {
	static int[] direction = {0, 3, 5, 6};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(), runners = sc.nextInt();
			int[][] visited = new int[n][n];
			int ans = 0;
			
			for(int i = 1; i <= runners; i++) {
				int x = sc.nextInt(), y = sc.nextInt(), d = sc.nextInt();
				
				if (ans > 0) continue;
				
				if (d == 1) {//하
					for(int k = 0; k < 4; k++) {
						if (!(x + direction[k] < n)) break;
						if (visited[x + direction[k]][y] == 0) visited[x + direction[k]][y] = 1;
						else {
							ans = i;
							break;
						}
					}
				}else {//우
					for(int k = 0; k < 4; k++) {
						if (!(y + direction[k] < n)) break;
						if (visited[x][y + direction[k]] == 0) visited[x][y + direction[k]] = 1;
						else {
							ans = i;
							break;
						}
					}
				}
			}
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
