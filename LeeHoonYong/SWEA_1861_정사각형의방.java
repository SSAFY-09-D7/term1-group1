import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Solution  {
	static int result;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int resStart;
	static int resend;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			map=new int[N][N];
			
			//입력
			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j]=Integer.parseInt(s[j]);
				}
			}
			result=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited=new boolean[N][N];
					int start = map[i][j];
					int roomNum=0;
					dfs(i,j,-1,0,start,start,0);
				}
			}
			
			
			System.out.println("#"+t+" "+resStart+" "+result);
		}
		
	}
	static int[] dr = {1,-1,0,0};//
    static int[] dc = {0,0,1,-1};
    
	private static void dfs(int r, int c,int inum,int roomNum,int start,int end, int stage) {
		if(r<0 || r>=N || c<0 || c>=N) {
			if(result<=roomNum) {
				if(result==roomNum) {// 방 개수가 작을때
					if(resend>=end) {
						result =roomNum;
						resStart=start;
						resend=end;
					}else {
						return;
					}
				}else { //방개수가 클때
					result =roomNum;
					resStart=start;
					resend=end;
				}			
			}
			return;
		}
		if(visited[r][c]==true) {
			if(result<=roomNum) {
				if(result==roomNum) {
					if(resend>=end) {
						result =roomNum;
						resStart=start;
						resend=end;
					}else {
						return;
					}
				}else { //
					result =roomNum;
					resStart=start;
					resend=end;
				}
				
				
			}
			return;
		}
		if(stage!=0&& map[r][c] != map[r-dr[inum]][c-dc[inum]]+1) {
			if(result<=roomNum) {
				if(result==roomNum) {
					if(resend>=end) {
						result =roomNum;
						resStart=start;
						resend=end;
					}else {
						return;
					}
				}else { //
					result =roomNum;
					resStart=start;
					resend=end;
				}
				
				
			}
			return;
		}

		
		for (int i = 0; i < 4; i++) {
				
			visited[r][c]=true;
			dfs(r+dr[i],c+dc[i],i,roomNum+1,start,map[r][c],stage+1);
			visited[r][c]=false;
		}
		
	}

}
