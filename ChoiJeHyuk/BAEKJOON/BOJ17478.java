package boj17478;

import java.util.Scanner;

public class Main {
	static int n;
	static int ncnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// ��� Ƚ�� �Է�
		n = sc.nextInt();
		// ù�� ���
		System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
		recursive(0);

	}
	/*
	 * ù�� ��� 4�� ���� ����� n���ϴµ� ____ * n-1������ �տ� ��� ( ____ * 0~n-1 ) ____ * n�� �������
	 * ����Լ��� ������ ( 4���� ù�� ) ��� ____ * n�� ������� ����Լ��� ~ ��� ��� ____ * (n ~ 0 ) + ���
	 * �亯�Ͽ���. ���
	 */

	private static void recursive(int i) {
		// basis part
		// �ѹ��� ������ ���� ���
		if (i == n) {
			for (int j = 0; j < n; j++) {
				System.out.print("____");			
			}
			System.out.println("\"����Լ��� ������?\"");
			for (int j = 0; j < n; j++) {
				System.out.print("____");
			}
			System.out.println("\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
			for (int j = 0; j < n; j++) {
				System.out.print("____");
			}
			System.out.println("��� �亯�Ͽ���.");
			return;
		}

		// ���� n�� ���
		for (int j = 0; j < i; j++) {
			System.out.print("____");
		}
		System.out.println("\"����Լ��� ������?\"");
		for (int j = 0; j < i; j++) {
			System.out.print("____");
		}
		System.out.println("\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
		for (int j = 0; j < i; j++) {
			System.out.print("____");
		}
		System.out.println("���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
		for (int j = 0; j < i; j++) {
			System.out.print("____");
		}
		System.out.println("���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");

		// inductive part
		recursive(i + 1);
		
		// �پ��ϱ� "��� �亯" ���
		for (int j = i; j > 0; j--) {
			System.out.print("____");
		}
		System.out.println("��� �亯�Ͽ���.");

	}

}
