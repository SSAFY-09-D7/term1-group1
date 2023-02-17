import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {

	static int[][] board;
 	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[1001][1001];
		
		int n = Integer.parseInt(br.readLine());
		for(int t=1;t<=n;t++) {
			String[] s =br.readLine().split(" ");
			int r =Integer.parseInt(s[0]);
			int c =Integer.parseInt(s[1]);
			int w =Integer.parseInt(s[2]);
			int h =Integer.parseInt(s[3]);
			
			for(int i=r;i<r+w;i++) {
				for (int j=c;j<c+h;j++) {
					board[i][j]=t;
				}
			}
			
		}
		int[] arr = new int[n+1];
		for (int i = 0; i < 1001; i++) {
			for (int j = 0; j < 1001; j++) {
				if(board[i][j]==0) {
					continue;
				}
				arr[board[i][j]]++;
			}
		}
		for (int i = 1; i < n+1; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
