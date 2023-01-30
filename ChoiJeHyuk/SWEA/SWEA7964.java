package git;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA7964 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int cnt = 1;
			int door = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 0 && cnt >= d) {
					door++;
					cnt = 0;
				}
				else if(arr[i] == 1){
					cnt = 0;
				}
				cnt++;
			}
			bw.write("#" + tc + " " + door);
			bw.newLine();
			bw.flush();			
			
			
		}
	}

}
