import java.util.*;
import java.io.*;

//상하좌우
public class Swea1873 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			int x = -1, y = -1, d = -1;//d = [상, 하, 좌, 우]; 
			//h 가로 w 세로
			int h = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
			
			String[][] arr = new String[h][w];
			
			for(int i = 0; i < h; i++) {
				arr[i] = br.readLine().split("");
			}
			
			int N = Integer.parseInt(br.readLine());
			String order = br.readLine();
			
			//전차 찾기
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if (arr[i][j].equals(">")) {x = i;y = j;d = 3;break;}
					else if (arr[i][j].equals("<")) {x = i; y = j;d = 2;break;}
					else if (arr[i][j].equals("^")) {x = i; y = j;d = 0;break;}
					else if (arr[i][j].equals("v")) {x = i; y = j; d = 1;break;}
				}
			}
			
			arr[x][y] = ".";//remove tank from the field
			
			for(int i = 0; i < N; i++) {
				char type = order.charAt(i);
				
				if (type == 'S') {//Shoot
					int tx = x, ty = y;
					
					while(true) {
						tx += dx[d];ty += dy[d];
						
						if (!(tx >= 0 && tx < h && ty >= 0 && ty < w)) break;
						if (arr[tx][ty].equals("#")) break;
						else if (arr[tx][ty].equals("*")) {
							arr[tx][ty] = ".";
							break;
						}
					}
					
					continue;
				}
				else if (type == 'U') {d = 0;}
				else if (type == 'D') {d = 1;}
				else if (type == 'L') {d = 2;}
				else if (type == 'R') {d = 3;}
				
				int nx = x + dx[d], ny = y + dy[d];
				
				if (nx >= 0 && nx < h && ny >= 0 && ny < w && arr[nx][ny].equals(".")) {
					x = nx; y = ny;
				}
			}
			
			if (d == 0) {arr[x][y] = "^";}
			else if (d == 1) {arr[x][y] = "v";}
			else if (d == 2) {arr[x][y] = "<";}
			else if (d == 3) {arr[x][y] = ">";}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
