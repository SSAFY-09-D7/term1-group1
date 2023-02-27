package SWEA3289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int n,m;
	static int[] set;
	static int add,a,b;
	static int answer;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			set = new int[n+1];
			
			for (int i = 0; i < set.length; i++) {
				set[i] = i;
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				add = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				if(add == 0) { // 합
					union(a,b);
				}
				else { //확인
					check(a,b);
				}
			}
			System.out.println(sb);
			
			
			 
		}
		
	}
	private static void check(int a, int b) {
		a = find_rep(a);
		b = find_rep(b);
		if(a != b) {
			// 두 조직의 대표자가 다르면 다른 조직이므로 합친다
			// idx : 조직의 번호 
			//value : 조직의 대표자 번호
			sb.append("0");
		}
		else {
			sb.append("1");
		}
		
		
	}
	private static void union(int a, int b) {
		//각조직의 대표자 찾기
		a = find_rep(a);
		b = find_rep(b);
				
		if(a != b) {
			// 두 조직의 대표자가 다르면 다른 조직이므로 합친다
			// idx : 조직의 번호 
			//value : 조직의 대표자 번호
			set[a] = set[b];
		}
	}
	private static int find_rep(int org) {
		if (set[org] == org)
			return org;
		else
			return  set[org] = find_rep(set[org]);

	}

}
