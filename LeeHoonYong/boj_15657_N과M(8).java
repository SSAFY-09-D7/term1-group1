import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class Main {
	static int n;
	static int m;
	static int num=0;
	static int[] arr;
	static int[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		arr = new int[n];
		selected= new int[n];
		for (int i = 0; i < s.length; i++) {
			arr[i]=Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		solve(0,0);
		
	}
	private static void solve(int idx,int num) {
		
		if(num==m) {
			//System.out.println(Arrays.toString(selected));
			for (int i = 0; i < selected.length; i++) {
				if(selected[i]>0) {
					for (int j = 0; j < selected[i]; j++) {						
						System.out.print(arr[i]+" ");
					}
				}
			}
			System.out.println();
			return;
		}
		
		for (int i = idx; i < n; i++) {			
			selected[i]++;
			solve(i,num+1);
			selected[i]--;
			
		}
	}	
}
