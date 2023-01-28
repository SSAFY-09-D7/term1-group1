package algo22;

import java.io.FileInputStream;
import java.util.Scanner;

public class koreaNewYearHomework_4 {
	static long Answer;
	static int N, S;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int[][] lake = new int[N][N];

			S = sc.nextInt();
			int[][] strider = new int[S][3];
			for (int k = 0; k < S; k++) {
				strider[k][0] = sc.nextInt();// 행위치
				strider[k][1] = sc.nextInt();// 열위치
				strider[k][2] = sc.nextInt();// 방향(1:하,2:우)
			}

			for (int ss = 0; ss < S; ss++) {

				int cnt = 3;
				int len = lake.length;
				Answer = 0;
				int row, col;

				// 위
				if (strider[ss][2] == 1) {
					row = strider[ss][0];
					col = strider[ss][1];

					lake[row][col] = 1;

					// 점프 시작
					for (int i = 0; i < 3; i++) {
						row -= cnt;
						if (row < 0) {
							lake[row + cnt][col] = 0;

							break;
						} else {
							lake[row + cnt][col] = 0;
							lake[row][col] = 1;
							cnt--;
						}
					}
				}

				// 아래
				else if (strider[ss][2] == 2) {
					row = strider[ss][0];
					col = strider[ss][1];

					lake[row][col] = 1;

					// 점프 시작
					for (int i = 0; i < 3; i++) {
						row += cnt;
						if (row >= len) {
							lake[row - cnt][col] = 0;

							break;
						} else {
							lake[row - cnt][col] = 0;
							lake[row][col] = 1;
							cnt--;
						}
					}
				}

				// 왼쪽
				else if (strider[ss][2] == 3) {
					row = strider[ss][0];
					col = strider[ss][1];

					lake[row][col] = 1;

					// 점프 시작
					for (int i = 0; i < 3; i++) {
						col -= cnt;
						if (col < 0) {
							lake[row][col + cnt] = 0;

							break;
						} else {
							lake[row][col + cnt] = 0;
							lake[row][col] = 1;
							cnt--;
						}
					}
				}
				// 오른쪽
				else if (strider[ss][2] == 4) {
					row = strider[ss][0];
					col = strider[ss][1];

					lake[row][col] = 1;

					for (int i = 0; i < 3; i++) {
						col += cnt;
						if (col >= len) {
							lake[row][col - cnt] = 0;

							break;
						} else {
							lake[row][col - cnt] = 0;
							lake[row][col] = 1;
							cnt--;
						}
					}
				}
			}

			for (int i = 0; i < lake.length; i++) {
				for (int j = 0; j < lake.length; j++) {
					if (lake[i][j] == 1)
						Answer++;
				}
			}

			System.out.println("#" + test_case + " " + Answer);
		}
	}
}