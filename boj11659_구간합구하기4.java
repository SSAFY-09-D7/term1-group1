import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int n=0;
	static int m=0;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s= br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] arr = new int[N+1];
		s=br.readLine().split(" ");
		for(int i=1;i<=N;i++) {
			if(i==1) {
				arr[i]=Integer.parseInt(s[i-1]);
			}else {
				arr[i]=Integer.parseInt(s[i-1])+arr[i-1];	
			}
		}
		//System.out.println(Arrays.toString(arr));
		for(int i=0;i<M;i++) {
			s=br.readLine().split(" ");
			int a=Integer.parseInt(s[0]);
			int b=Integer.parseInt(s[1]);
			System.out.println(arr[b]-arr[a-1]);
		}
		
	}
}
