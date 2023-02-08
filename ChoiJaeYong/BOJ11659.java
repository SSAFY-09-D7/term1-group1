import java.util.*;
import java.io.*;

public class BOJ11659 {
	static StringBuffer sb = new StringBuffer();
	static int N, M;
	static int[] arr;
	static int[] noo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());M = Integer.parseInt(st.nextToken());
		arr = new int[N];noo = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			noo[i + 1] += noo[i] + arr[i];
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			sb.append(noo[b] - noo[a - 1]+"\n");
		}
		
		System.out.println(sb);
	}
}
