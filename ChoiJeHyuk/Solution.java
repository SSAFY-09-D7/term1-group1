package algo11;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			String[][] str = new String[n][n];
			int cnt = 0;
			
			for (int i = 0; i < str.length; i++) {
				for (int j = 0; j < str.length; j++) {
					str[i][j] = sc.next();
				}
			}
			
			
			for (int i = 0; i < str.length; i++) {
				for (int j = 0; j < str.length; j++) {
					if(str[i][j].equals("A")) {
						for(int d = j+1; d<str.length; d++) {
							if(str[i][d].equals("S")) {
								cnt++;
							}
							else {
								break;
							}
						}
					}
					
					else if(str[i][j].equals("B")) {
						for(int d = j+1; d<str.length; d++) {
							if(str[i][d].equals("S")) {
								cnt++;
							}
							else {
								break;
							}
						}
						for(int e = j-1; e >= 0; e--) {
							if(str[i][e].equals("S")) {
								cnt++;
							}
							else {
								break;
							}
						}
					}
					
					else if(str[i][j].equals("C")) {
						for(int d = j+1; d<str.length; d++) {
							if(str[i][d].equals("S")) {
								cnt++;
							}
							else {
								break;
							}
						}
						for(int e = j-1; e >= 0; e--) {
							if(str[i][e].equals("S")) {
								cnt++;
							}
							else {
								break;
							}
						}
						
						for(int d = j+1; d<str.length; d++) {
							if(str[d][j].equals("S")) {
								cnt++;
							}
							else {
								break;
							}
						}
						for(int e = j-1; e >= 0; e--) {
							if(str[e][j].equals("S")) {
								cnt++;
							}
							else {
								break;
							}
						}
					}
					
				}
			}
			
			
			
			System.out.println("#" + (tc+1) + " " + cnt);
		}

	}

}
