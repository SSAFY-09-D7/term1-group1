package swea1873;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			char[][] map = new char[h][w];
			int x = 0;
			int y = 0;
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				String input = sc.next();
				for (int j = 0; j < w; j++) {
					map[i][j] = input.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}
			int startx = x;
			int starty = y;

			int n = sc.nextInt();
			String[] move = new String[n];
			String str = sc.next();

			for (int i = 0; i < n; i++) {
				move[i] = str.substring(i, i + 1);
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <h; j++) {
					for (int j2 = 0; j2 < w; j2++) {
						System.out.print(map[j][j2]);
					}
					System.out.println();
				}
				System.out.println("---------------------------------");
				if (cnt == 1) {
					map[startx][starty] = '.';
				}
				if (move[i].equals("S")) {
					// 처음에 슛일때
					if (i == 0) {
						if (map[x][y] == '^') {
							for (int j = x; j >= 0; j--) {
								if (map[j][y] == '#') {
									break;
								} else if (map[j][y] == '*') {
									map[j][y] = '.';
									break;
								}
							}
						} else if (map[x][y] == 'v') {
							for (int j = x; j < h; j++) {
								if (map[j][y] == '#') {
									break;
								} else if (map[j][y] == '*') {
									map[j][y] = '.';
									break;
								}
							}
						} else if (map[x][y] == '<') {
							for (int j = y; j >= 0; j--) {
								if (map[x][j] == '#') {
									break;
								} else if (map[x][j] == '*') {
									map[x][j] = '.';
									break;
								}
							}
						} else if (map[x][y] == '>') {
							for (int j = y; j < w; j++) {
								if (map[x][j] == '#') {
									break;
								} else if (map[x][j] == '*') {
									map[x][j] = '.';
									break;
								}
							}
						}
					}
					// 처음에 슛하는게 아닐때

					else {
						for (int j = 0; j <= i; j++) {
							if (move[i - j].equals("R")) {
								for (int k = 0; k < w - y; k++) {
									if (map[x][y + k] == '#') {
										break;
									} else if (map[x][y + k] == '*') {
										map[x][y + k] = '.';
										break;
									}
								}
								break;
							} else if (move[i - j].equals("L")) {
								for (int k = 0; k <= y; k++) {
									if (map[x][y - k] == '#') {
										break;
									} else if (map[x][y - k] == '*') {
										map[x][y - k] = '.';
										break;
									}
								}
								break;
							} else if (move[i - j].equals("U")) {
								for (int k = 0; k <= x; k++) {
									if (map[x - k][y] == '#') {
										break;
									} else if (map[x - k][y] == '*') {
										map[x - k][y] = '.';
										break;
									}
								}
								break;
							} else if (move[i - j].equals("D")) {
								for (int k = 0; k < h - x; k++) {

									if (map[x + k][y] == '#') {
										break;
									} else if (map[x + k][y] == '*') {
										map[x + k][y] = '.';
										break;
									}

								}
								break;
							}
							

						}

					}

				} else if (move[i].equals("U")) { // 위로갈때
					if (x >= 1) {
						if (map[x - 1][y] == '.') {
							x--;
						}
					}
					cnt++;
				} else if (move[i].equals("D")) {
					if (x < h - 1) {
						if (map[x + 1][y] == '.') {
							x++;
						}
					}
					cnt++;
				} else if (move[i].equals("L")) {
					if (y >= 1) {
						if (map[x][y - 1] == '.') {
							y--;
						}
					}
					cnt++;
				} else if (move[i].equals("R")) {
					if (y < w - 1) {
						if (map[x][y + 1] == '.') {
							y++;
						}
					}
					cnt++;
				}

			}
			// 마지막 바라보는 방향 설정
			for (int k = n - 1; k >= 0; k--) {
				if (move[k].equals("U")) {
					map[x][y] = '^';
					break;
				} else if (move[k].equals("D")) {
					map[x][y] = 'v';
					break;
				} else if (move[k].equals("L")) {
					map[x][y] = '<';
					break;
				} else if (move[k].equals("R")) {
					map[x][y] = '>';
					break;
				}
			}
			System.out.print("#" + tc + " ");
			for (int k = 0; k < h; k++) {
				for (int l = 0; l < w; l++) {
					System.out.print(map[k][l]);
				}
				System.out.println();
			}
		}

	}

}
