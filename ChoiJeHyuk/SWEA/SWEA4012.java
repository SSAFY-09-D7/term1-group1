package SWEA4012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] p = { 1, 2, 3, 4, 5, 6 };
	static int N;
	static int[][] dish;
	static int[] arr;
	static int A, B;
	static int[] acombi;
	static boolean[] visited;
	static int cnt;
	static int[] bcombi;
	static int idx;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			dish = new int[N][N];  // 시너지 배열
			arr = new int[N]; // 1~N값 저장 배열
			visited = new boolean[N];
			acombi = new int[N / 2]; // A의 음식재료
			cnt = 0;
			bcombi = new int[N / 2]; // B의 음식재료
			min = Integer.MAX_VALUE;
			// bcnt = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					dish[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;

			}

			combi(0, 0); // 조합
			System.out.println("#" + tc + " " + min);
		}

	}

	// B배열에 넣을 값 찾기 
	private static boolean contains(int value, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value)
				return true;
		}

		return false;
	}

	private static void combi(int cnt, int start) {
		if (cnt == N / 2) {
			// logic
			idx = 0;
			int ascore = 0, bscore = 0;

			for (int i = 0; i < N; i++) {
				if (contains(i, acombi) == false) {
					//System.out.println(i + " " + Arrays.toString(nums));
					//System.out.println(bcnt);
					bcombi[idx++] = i;
				}
			}
			//System.out.println(Arrays.toString(nums));
			//System.out.println("----");
			//System.out.println(Arrays.toString(bnums));

			// System.out.println(Arrays.toString(bnums));

			// nums => A, bnums => B
			// (i, j), (i + 1, j), (i, j+1)
			// 함수 추가, 재귀 호출 과정이 필요
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// i랑 j 같은 재료 그룹에 속해야 점수 계산을 할 수 있다.
					if (contains(i, acombi) && contains(j, acombi)) {
						// 두 재료가 A 음식 재료에 속함
						ascore += dish[i][j] ;
						//System.out.println(dish[i][j] + " " + dish[j][i]);
					} else if (contains(i, bcombi) && contains(j, bcombi)) {
						bscore += dish[i][j] ;
					}
					
				}
			}
			//System.out.println("asocre : " + ascore + " bscore : " + bscore );
			// ascore, bscore의 계산이 끝남
			min = Math.min(min, Math.abs(ascore - bscore));
			
			return;
		}

		for (int i = start; i < N; i++) {
			visited[i] = true;
			acombi[cnt] = i;
			combi(cnt + 1, i + 1);
			acombi[cnt] = 0;
			visited[i] = false;
		}

	}
}