package BOJ3040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] dwarf;
	static int[] answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarf = new int[9];
		answer = new int[7];
		for (int i = 0; i < dwarf.length; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		recursive(dwarf, new int[7], 0, 0);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		
	}
	private static void recursive(int[] arr, int[] sel, int idx, int k) {
		
		if(k==sel.length) {
			//System.out.println(Arrays.toString(sel));
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(sum == 100) {
				for (int i = 0; i < sel.length; i++) {
					answer[i] = sel[i];
				}
			}
			return;
		}
	
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			recursive(arr, sel, i + 1, k + 1);
		}
	}

}