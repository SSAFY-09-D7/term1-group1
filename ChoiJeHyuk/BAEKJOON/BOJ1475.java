package BOJ1475;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String n = br.readLine();
		int[] arr = new int[9];

		for (int i = 0; i < n.length(); i++) {
			switch (n.charAt(i)) {
			case '0':
				arr[0]++;
				break;
			case '1':
				arr[1]++;
				break;
			case '2':
				arr[2]++;
				break;
			case '3':
				arr[3]++;
				break;
			case '4':
				arr[4]++;
				break;
			case '5':
				arr[5]++;
				break;
			case '6':
				arr[6]++;
				break;
			case '7':
				arr[7]++;
				break;
			case '8':
				arr[8]++;
				break;
			case '9':
				arr[6]++;
				break;

			}
		}
		if(arr[6] % 2 != 0) {
			arr[6] = arr[6] /2 +1;
		}
		else {
			arr[6] /=2;
		}
		
		Arrays.sort(arr);
		bw.write(arr[8] + "");
		bw.flush();
		

	}

}
