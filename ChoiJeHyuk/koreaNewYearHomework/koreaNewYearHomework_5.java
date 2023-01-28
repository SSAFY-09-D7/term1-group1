package algo32;

import java.util.Scanner;

public class koreaNewYearHomework_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int n = sc.nextInt();

			int[][] arr = new int[y + 1][x + 1];
			int[][] player = new int[n][3];
			int money = 0;
			int cnt = 0;
			int row, col;
			int start;
			int direction;
			int jump;

			for (int i = 0; i < y; i++) {
				for (int j = 0; j < x; j++) {
					arr[i + 1][j + 1] = sc.nextInt();

				}
			}

			for (int i = 0; i < n; i++) {
				player[i][0] = sc.nextInt(); // 출발x좌표
				player[i][1] = sc.nextInt(); // 출발y좌표
				player[i][2] = sc.nextInt(); // 횟수
			}

			int trapcnt = sc.nextInt();
			int[][] trap = new int[trapcnt][2];

			for (int i = 0; i < trapcnt; i++) {
				trap[i][0] = sc.nextInt();
				trap[i][1] = sc.nextInt();

				arr[trap[i][0]][trap[i][1]] = 0;
			}
			money = n * -1000;

			for (int i = 0; i < n; i++) {
				cnt = player[i][2];

				row = player[i][0];
				col = player[i][1];

				start = arr[row][col];

				if (start == 0) {
					money += 0;
					continue;
				}

				for (int j = 0; j < cnt; j++) {
					direction = start / 10;
					jump = start % 10;

					if (direction == 1) {
						if (col + jump > x) {
							break;
						} else {
							col += jump;
							start = arr[row][col];
						}
					}

					else if (direction == 2) {
						if (row + jump > y) {
							break;
						} else {
							row += jump;
							start = arr[row][col];
						}
					}

					else if (direction == 3) {
						if (col - jump <= 0) {
							break;
						} else {
							col -= jump;
							start = arr[row][col];
						}
					}

					else if (direction == 4) {
						if (row - jump <= 0) {
							break;
						} else {
							row -= jump;
							start = arr[row][col];
						}
					}

					if (j == (cnt - 1)) {
						money += start * 100;
					}
				}
			}
			System.out.println("#" + tc + " " + money);
		}

	}

}
