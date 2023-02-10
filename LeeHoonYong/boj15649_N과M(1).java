import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n=0;
	static int m=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m =Integer.parseInt(s[1]);
		int[] arr = new int [m];
		boolean[] visit = new boolean[n+1];
		recursive(arr,0,visit);
	}

	private static void recursive(int[] arr,int idx,boolean[] visit) {
		if(idx==m) {
			for(int i=0;i<m;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=n;i++) {
			if(visit[i]==false) {
				visit[i]=true;
				arr[idx]=i;
				recursive(arr,idx+1,visit);
				visit[i]=false;
			}
			
		}
	}

}
