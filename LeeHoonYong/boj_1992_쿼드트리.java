import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class Main {

	static int[][] board;
 	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board= new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j]=(int)(s.charAt(j)-'0');
			}
		}
		
		search(0,0,N);
		
		
		
	}
	private static void search(int r, int c, int size) {
		int zeroSum=0;
		int oneSum=0;
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				if(board[i][j]==0) {
					zeroSum++;
				}else {					
					oneSum++;
				}
			}
		}
		if(zeroSum==size*size) {
			System.out.print(0);
		}else if(oneSum==size*size) {
			System.out.print(1);
		}else {
			System.out.print("(");
			int half=size/2;
			search(r, c, half);
			search(r, c+half, half);
			search(r+half, c, half);
			search(r+half, c+half, half);
			System.out.print(")");
		}
	}
}
