package BOJ10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		
		recursive(arr, new int[N],0,new boolean[N]);
		
	}

	private static void recursive(int[] arr, int[] sel, int k, boolean[] v) {
		if(k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[k] = arr[i];
				recursive(arr,sel,k+1,v);
				v[i] = false;
			}
		}
	}

}
