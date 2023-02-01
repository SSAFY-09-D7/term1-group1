package swea7272;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			String before = st.nextToken();
			String after = st.nextToken();
			String[] input1 = new String[before.length()];
			String[] input2 = new String[after.length()];
			int[] arr1 = new int[input1.length];
			int[] arr2 = new int[input2.length];
			
			for(int i = 0; i< before.length(); i++) {
				input1 = before.split("");
			}
			for(int i = 0; i< after.length(); i++) {
				input2 = after.split("");
 			}
			
			if(input1.length != input2.length) {
				bw.write("#" + tc + " " + "DIFF");
				bw.flush();
				bw.newLine();
			}
			else {
				for (int i = 0; i < input1.length; i++) {
					if(input1[i].equals("B")) {
						arr1[i] = 2;
					}
					else if(input1[i].equals("A") ||input1[i].equals("D") ||input1[i].equals("O") ||input1[i].equals("P") ||input1[i].equals("Q") ||input1[i].equals("R") ) {
						arr1[i] = 1;
					}
					else {
						arr1[i] = 0;
					}
				}
				
				for (int i = 0; i < input2.length; i++) {
					if(input2[i].equals("B")) {
						arr2[i] = 2;
					}
					else if(input2[i].equals("A") ||input2[i].equals("D") ||input2[i].equals("O") ||input2[i].equals("P") ||input2[i].equals("Q") ||input2[i].equals("R") ) {
						arr2[i] = 1;
					}
					else {
						arr2[i] = 0;
					}
				}
				
				if(Arrays.equals(arr1, arr2)) {
					bw.write("#" + tc + " " + "SAME");
					bw.newLine();
					bw.flush();
					
				}
				else {
					bw.write("#" + tc + " " + "DIFF");
					bw.newLine();
					bw.flush();
					
				}
			}
			
		}

	}

}
