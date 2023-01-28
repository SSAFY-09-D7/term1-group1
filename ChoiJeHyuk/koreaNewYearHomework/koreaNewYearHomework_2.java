package algo13;

import java.util.Scanner;

public class koreaNewYearHomework_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			String[][] str = new String[n][n];
			int max = 0;
			int temp = 0;
			int tempmax = 0;
			int cnt = 0;
			int[][] count = new int[n][n];
			int edge = 0;

			for (int i = 0; i < str.length; i++) {
				for (int j = 0; j < str.length; j++) {
					str[i][j] = sc.next();
				}
			}

			int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
			int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

			for (int i = 0; i < str.length; i++) {
				for (int j = 0; j < str.length; j++) {
					temp = 0;
					edge = 0;
					for (int d = 0; d < dy.length; d++) {
						int ni = i + dx[d];
						int nj = j + dy[d];

						if (ni >= 0 && nj < n && nj >= 0 && ni < n) {
							if (str[ni][nj].equals("B")) {
								temp++;
							}
						} else {
							edge++;
						}

					}
					// tempmax = Math.max(tempmax, temp);
					// count[i][j] = temp;
					// System.out.println(tempmax);
					// System.out.println(count[i][j]);
					if (temp + edge == 8) {

						count[i][j] = 8;
					}

				}
			}

			for (int i = 0; i < str.length; i++) {
				for (int j = 0; j < str.length; j++) {
					if (count[i][j] == 8) {
						for (int d = 0; d < n; d++) {
							if (str[i][d].equals("B")) {
								cnt++;
							}
							if(str[d][j].equals("B")){
								cnt++;
							}
							
						}
					}
					//System.out.println(cnt);
					max = Math.max(max, cnt);
					cnt = 0;
				}
				
			}
			System.out.println("#" + (tc + 1) + " " + (max - 1));
		}

	}

}
