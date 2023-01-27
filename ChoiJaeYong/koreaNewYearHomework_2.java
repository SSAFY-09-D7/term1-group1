import java.util.*;

public class koreaNewYearHomework_2 {
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};//상하좌우
	static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		
		for(int tc = 1; tc <= t; tc++) {
			int ans = 0;
			int n = sc.nextInt();
			String[][] arr = new String[n][n];
			
			for(int i = 0;i < n;i++) {
				for(int j = 0;j < n;j++) {
					arr[i][j] = sc.next();
				}
			}
			
			int[] row = new int[n];
			int[] col = new int[n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if (arr[i][j].equals("B")) row[i]++;
					if (arr[j][i].equals("B")) col[i]++;
				}
			}
			
			for(int x = 0; x < n; x++) {
				for(int y = 0; y < n; y++) {
					if (arr[x][y].equals("B")) {
						boolean park = false;
						
						for(int k = 0; k < 8; k++) {
							int nx = x + dx[k], ny = y + dy[k];
							
							if (!(0 <= nx && nx < n && 0 <= ny && ny < n)) continue;
							if (arr[nx][ny].equals("G")) {
								park = true;
								break;
							}
						}
						
						if (park == false) ans = Math.max(ans, row[x] + col[y] - 1);
					}
				}
			}
			
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}
}
