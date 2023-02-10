import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s= br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		int[][] board = new int[N+1][N+1];
		int[][] board2 = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			s= br.readLine().split(" ");
			for(int j=1;j<=N;j++) {
				board[i][j]=Integer.parseInt(s[j-1]);
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				board2[i][j]=board2[i-1][j];
				for(int k=1;k<=j;k++) {
					board2[i][j]+=board[i][k];
				}
			}
		}
		//print(board2);
		//print(board);
		for(int i=0;i<M;i++) {
			s= br.readLine().split(" ");
			int x1=Integer.parseInt(s[0]);
			int y1=Integer.parseInt(s[1]);
			int x2=Integer.parseInt(s[2]);
			int y2=Integer.parseInt(s[3]);
			int result= board2[x2][y2]-board2[x2][y1-1]-board2[x1-1][y2]+board2[x1-1][y1-1];
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
	private static void print(int[][] board) {
		for(int i=1;i<=N;i++) {
			for (int j = 1; j <=N; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
