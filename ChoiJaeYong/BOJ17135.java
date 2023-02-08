import java.util.*;
import java.io.*;

class Node {
	int x, y;
	
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ17135 {
	static int[] sel = new int[3];
	static int[][] arr;
	static int N, M, D;
	static int ans;
	
	static void shoot() {
		int[][] v = new int[N][M];
		int cnt = 0;
		Stack<Node> stack = new Stack<>();
		
		for(int i = N - 1; i >= 0; i--) {//쏘는 첫 줄
			for(int archer = 0; archer < 3; archer++) {//궁수 최근접 적 탐색
				int d = Integer.MAX_VALUE;
				int x = -1, y = -1;//적을 찾지 못함
				
				for(int r = i; r >= i - D + 1; r--) {
					if (r < 0) break;
					
					for(int c = 0; c < M; c++) {
						if (arr[r][c] == 0) continue;
						int distance = Math.abs(sel[archer] - c) + Math.abs(i + 1 - r);
						if (distance > D) continue;//궁수 사거리 밖이라면
						if (distance > d || (distance == d && y <= c)) continue;//기존에 더 가까운 적이 있다면
						
						d = distance;x = r;y = c;
					}
				}
				
				if (x == -1 && y == -1) continue;
				
				//현 시뮬에서 이미 맞은 적이 아니라면 방문 처리 및 stack에 추가
				if (v[x][y] == 0) {
					v[x][y] = 1;
					stack.add(new Node(x, y));
					cnt++;
				}
			}
			
			for(int ss = 0; ss < stack.size(); ss++) {
				Node node = stack.get(ss);
				arr[node.x][node.y] = 0;
			}
		}
		
		//시뮬레이션 종료 후 arr 원상 복구
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			arr[node.x][node.y] = 1;
		}
		
		ans = Math.max(ans, cnt);
	}
	
	static void archer_pos(int idx, int k) {
		if (k == 3) {
			shoot();
			return;
		}

		if (idx >= M) return;//이 한 줄로 2시간 탕진
		
		sel[k] = idx;
		archer_pos(idx + 1, k + 1); //선택
		sel[k] = 0;
		archer_pos(idx + 1, k); //미선택
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());M = Integer.parseInt(st.nextToken());D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		archer_pos(0, 0);
		
		System.out.println(ans);
	}
}
