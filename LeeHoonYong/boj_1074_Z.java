import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class Main {
	static int flag=0;
	static int x;
	static int y;
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int k = Integer.parseInt(s[0]);
		x = Integer.parseInt(s[1]);
		y = Integer.parseInt(s[2]);
		int N=1;
		for(int i=0;i<k;i++) {
			N*=2;
		}
		int count=0;
		search(0,0,N,0);

	}
	private static void search(int r, int c, int size,int count) {
		if(flag==1) {
			return;
		}
		if(x>r+size || y>c+size) {
			return;
		}
		if(size==2) {
			for(int i=r;i<r+size;i++) {
				for(int j=c;j<c+size;j++) {
					if(i==x && j==y) {
						System.out.println(count);
						flag++;
						return;
					}
					count++;
				}
			}
			return;
		}
		
		int half=size/2;
		search(r, c, half,count);
		search(r, c+half, half,count+half*half);
		search(r+half, c, half,count+(half*half)*2);
		search(r+half, c+half, half, count+(half*half)*3);

	}
}
