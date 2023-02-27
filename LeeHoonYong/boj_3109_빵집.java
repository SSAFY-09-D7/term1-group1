import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
class Point{
	int r;
	int c;
	Point(int r, int c){
		this.r =r;
		this.c =c;
	}
}

public class Solution {
	static char[][] map;
	static boolean flag;
	static int R;
	static int C;
	static int Ans=0;
	static ArrayList<Point> list = new ArrayList<>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] =str.charAt(j);

			}
		}
		for (int r = 0; r < R; r++) {
			flag=false;
			solve(r,0);
		}
		System.out.println(Ans);
	}
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	private static void solve(int r,int c) {
		if(flag) {
			return;
		}
		if(c==C-1) {
			Ans++;
			flag=true;
			return;
		}
		
		for (int d = 0; d < 3; d++) {
			int nr = r +dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nr<R && nc>=0 && nc<C 
					&& map[nr][nc]=='.'&& !flag) {
				map[nr][nc]='x';
				solve(nr,nc);
			}
		}
		
	}



}