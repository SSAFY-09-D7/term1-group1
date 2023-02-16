
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;



public class Main {
	static int[] arr;
	static int[] res;
	static int N;
	static int M;
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
	}

	private static void recursive(int idx, int num) {
		if(num ==M) {
			for (int i = 0; i < M; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
			return;
		}
		if(idx>=N) {
			return;
		}
		
		for(int i=idx;i<N;i++) {
			res[num]=arr[i];
			recursive(i+1,num+1);
		}
		
	}

}
