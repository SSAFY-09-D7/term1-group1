package algo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class Main {
	static int[] arr;
	static int[] res;
	static int N;
	static int M;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s =br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = new int[N];
		res = new int[M];
		s =br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] =  Integer.parseInt(s[i]);
		}
		Arrays.sort(arr);
		recursive(0,0);
		bw.flush();
		bw.close();
	}
	private static void recursive(int idx, int num) throws IOException {
		if(num ==M) {
			for (int i = 0; i < M; i++) {
				bw.write(res[i]+" ");
				//System.out.print(res[i]+" ");
			}
			bw.newLine();
			//System.out.println();
			return;
		}

		
		for(int i=0;i<N;i++) {
			res[num]=arr[i];
			recursive(i,num+1);
		}
		
	}
}
