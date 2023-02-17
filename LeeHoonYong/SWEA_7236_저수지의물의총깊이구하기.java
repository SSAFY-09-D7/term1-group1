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
	static int res;
	static int N;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N =Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = s[j].charAt(0);
				}
			}
			res=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int k =search(i,j);
					res = Math.max(res, k);
				}
			}
			System.out.println("#"+t+" "+res);
		}
		
	}
	static int[] dx = {0,1,0,-1,1,1,-1,-1};
	static int[] dy = {1,0,-1,0,1,-1,-1,1};

	private static int search(int x, int y) {
		int num=0;
		for(int i=0;i<8;i++) {
			int nx = x +dx[i];
			int ny = y +dy[i];
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(map[nx][ny]=='W') {
				num++;
			}
		}
		return num;
	}	
}