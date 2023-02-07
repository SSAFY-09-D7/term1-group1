package boj17478;

import java.util.Scanner;

public class Main {
	static int n;
	static int ncnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 재귀 횟수 입력
		n = sc.nextInt();
		// 첫줄 출력
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursive(0);

	}
	/*
	 * 첫줄 출력 4줄 문장 출력을 n번하는데 ____ * n-1번까지 앞에 출력 ( ____ * 0~n-1 ) ____ * n번 출력이후
	 * 재귀함수가 뭔가요 ( 4줄중 첫줄 ) 출력 ____ * n번 출력이후 재귀함수는 ~ 라네 출력 ____ * (n ~ 0 ) + 라고
	 * 답변하였지. 출력
	 */

	private static void recursive(int i) {
		// basis part
		// 한번만 나오는 문장 출력
		if (i == n) {
			for (int j = 0; j < n; j++) {
				System.out.print("____");			
			}
			System.out.println("\"재귀함수가 뭔가요?\"");
			for (int j = 0; j < n; j++) {
				System.out.print("____");
			}
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			for (int j = 0; j < n; j++) {
				System.out.print("____");
			}
			System.out.println("라고 답변하였지.");
			return;
		}

		// 문장 n번 출력
		for (int j = 0; j < i; j++) {
			System.out.print("____");
		}
		System.out.println("\"재귀함수가 뭔가요?\"");
		for (int j = 0; j < i; j++) {
			System.out.print("____");
		}
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		for (int j = 0; j < i; j++) {
			System.out.print("____");
		}
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		for (int j = 0; j < i; j++) {
			System.out.print("____");
		}
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

		// inductive part
		recursive(i + 1);
		
		// 줄어드니까 "라고 답변" 출력
		for (int j = i; j > 0; j--) {
			System.out.print("____");
		}
		System.out.println("라고 답변하였지.");

	}

}
