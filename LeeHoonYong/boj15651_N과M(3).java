import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n=0;
	static int m=0;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m =Integer.parseInt(s[1]);
		int[] arr = new int [m];
		//boolean[] visit = new boolean[n+1];
		recursive(arr,0);
		System.out.println(sb);
	}

	private static void recursive(int[] arr,int idx) throws IOException {
		if(idx==m) {
			for(int i=0;i<m;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			arr[idx]=i;
			recursive(arr,idx+1);
		}
		
	}
	
	

}
