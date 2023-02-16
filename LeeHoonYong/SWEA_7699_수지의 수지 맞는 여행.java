import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Solution {
	static char[][] map;
	static int[] alpabet;
	static int R,C;
	//static int[][] v;
	static int result=0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result=0;
			alpabet=new int[26];
			String[] s = br.readLine().split(" ");
			R = Integer.parseInt(s[0]);
			C = Integer.parseInt(s[1]);
			map = new char[R][C];
			//v=new int[R][C];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j]=str.charAt(j);
				}
			}

//			for (int i = 0; i < R; i++) {
//				
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			dfs(0,0,0);
			System.out.println("#"+t+" "+result);
		}
		
			
	}
	
	static int[] dr= {1,0,-1,0}; //아래 오른쪽 위 왼쪽
	static int[] dc= {0,1,0,-1};
	
	private static void dfs(int r, int c,int num) {
		if(r<0 || r>=R || c<0 || c>=C) {
			result=Math.max(result, num);
			return;
		}
//		if(v[r][c]==1) {
//			result=Math.max(result, num);	
//			return;
//		}
		if(alpabet[map[r][c]-'A'] > 0) {
			result=Math.max(result, num);	
			return;
		}
			
		
		for (int i = 0; i < 4; i++) {

			//v[r][c]=1;
			alpabet[map[r][c]-'A']++;
			dfs(r+dr[i],c+dc[i],num+1);
			//v[r][c]=0;
			alpabet[map[r][c]-'A']--;

		}	
		return;
	}
	
}