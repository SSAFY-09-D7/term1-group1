import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class koreaNewYearHomework_1 {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			String[][] arr = new String[n][n];
			int answer = 0;

			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = st.nextToken();
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					switch(arr[i][j]) {
					case "A"->{
						for(int k = j + 1; k < n; k++) {
							if (arr[i][k].equals("S")) answer++;
							else break;
						}
					}
					case "B"->{
						for(int k = j + 1; k < n; k++) {
							if (arr[i][k].equals("S")) answer++;
							else break;
						}
						for(int k = j - 1; k >= 0; k--) {
							if (arr[i][k].equals("S")) answer++;
							else break;
						}
					}
					case "C"->{
						for(int k = j + 1; k < n; k++) {
							if (arr[i][k].equals("S")) answer++;
							else break;
						}
						for(int k = j - 1; k >= 0; k--) {
							if (arr[i][k].equals("S")) answer++;
							else break;
						}
						for(int k = i + 1; k < n; k++) {
							if (arr[k][j].equals("S")) answer++;
							else break;
						}
						for(int k = i - 1; k >= 0; k--) {
							if (arr[k][j].equals("S")) answer++;
							else break;
						}
					}
					}
				}
			}
			sb.append("#"+tc+" "+answer+"\n");
		}
		System.out.println(sb);
	}
}
