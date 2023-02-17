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
		int[] arr =new int[N+1];
		
		for (int i = 0; i < arr.length; i++) {
			if(i==0||i==1 ||i==2 ||i==4) {
				arr[i]=-1;
				continue;
			}
			if(i==3 ||i==5) {
				arr[i]=1;
				continue;
			}
			if(arr[i-3]==-1 && arr[i-5]==-1) {
				arr[i]=-1;
				continue;
			}			
			if(arr[i-3]!=-1 && arr[i-5]==-1) {
				arr[i]=arr[i-3]+1;
			}else if(arr[i-3]==-1 && arr[i-5]!=-1) {
				arr[i]=arr[i-5]+1;
			}else {
				arr[i]=Math.min(arr[i-3]+1, arr[i-5]+1);
			}
		}
		System.out.println(arr[N]);
	}
}
