import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int x;
	int y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Swea1227 {
	static int[][] arr = new int[100][100];
	static int[][] v = new int[100][100];
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Queue<Node> q = new LinkedList<>();
		
		for(int tc = 1; tc <= 10; tc++) {
			sb.append("#"+Integer.parseInt(br.readLine())+" ");
			int ans = 0;
			
			for(int i = 0; i < 100; i++) {
				String[] input = br.readLine().split("");
				
				for(int j = 0; j < 100; j++) {
					v[i][j] = 0;
					arr[i][j] = Integer.parseInt(input[j]);
					if(arr[i][j] == 2) {
						q.add(new Node(i, j));
						v[i][j] = 1;
					}
				}
			}
			
			Outter: while(!q.isEmpty()) {
				Node node = q.poll();
				
				for(int k = 0; k < 4; k++) {
					int nx = node.x + dx[k], ny = node.y + dy[k];
					
					if (!(nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || arr[nx][ny] == 1 || v[nx][ny] == 1)) {
						if (arr[nx][ny] == 3) {
							ans = 1;
							break Outter;
						}
						v[nx][ny] = 1;
						q.add(new Node(nx, ny));
					}
				}
			}

			sb.append(ans+"\n");
			q.clear();
		}
		System.out.println(sb);
	}
}
