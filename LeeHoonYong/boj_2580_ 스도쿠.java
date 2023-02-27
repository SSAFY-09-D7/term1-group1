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
	static int[][] map;
	static int flag = 0;
	static ArrayList<Point> list = new ArrayList<>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j]==0) list.add(new Point(i,j));
			}
		}
		
		
		solve(0);
		
	}


	private static void solve(int k) {
		if(flag==1) {
			return;
		}
		if(k == list.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			flag=1;
			return;
		}
		
		int r = list.get(k).r;
		int c = list.get(k).c;
		
		boolean[] row = new boolean[10]; //행검사
		boolean[] col = new boolean[10]; //열검사
		boolean[] rect = new boolean[10]; //3 X 3 검사
		for (int i = 0; i < 9; i++) {
			col[map[i][c]] = true;
			row[map[r][i]] = true;
		}

		int sr = (r/3)*3;
		int sc = (c/3)*3;

		for (int i = sr; i < sr+3; i++) {
			for (int j = sc; j < sc+3; j++) {
				rect[map[i][j]] = true;
			}
		}
		

		for (int t = 1; t <= 9; t++) {	
			if(col[t]== false && row[t]== false && rect[t]== false ) {
				map[r][c]=t;
				solve(k+1);
				map[r][c]=0;
			}
		}
	}



}