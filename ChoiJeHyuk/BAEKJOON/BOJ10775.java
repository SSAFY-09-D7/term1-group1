package BOJ10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int G, P;
	static int[] set;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		set = new int[G + 1];

		for (int i = 1; i < set.length; i++) {
			set[i] = i;
		}

		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			int pg = find_rep(g);
			if (pg != 0) {
				union_set(pg, pg - 1);
				answer += 1;
			} else
				break;

		}
		System.out.println(answer);
	}

	private static void union_set(int a, int b) {
		//각조직의 대표자 찾기
		a = find_rep(a);
		b = find_rep(b);
		
		if(a != b) {
			// 두 조직의 대표자가 다르면 다른 조직이므로 합친다
			// idx : 조직의 번호 
			//value : 조직의 대표자 번호
			set[a] = b;
		}
	}		


	private static int find_rep(int org) {
		if (set[org] == org)
			return org;
		else
			return set[org] = find_rep(set[org]);

	}

}
