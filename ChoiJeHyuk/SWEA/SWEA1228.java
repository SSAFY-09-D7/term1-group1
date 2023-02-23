package swea1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			int order;
			String dummy;
			int cnt;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			order = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < order; i++) {
				dummy = st.nextToken();
				int location = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());
				cnt = 0;
				for (int j = 0; j < num; j++) {
					int input = Integer.parseInt(st.nextToken());
					list.add(location+cnt, input);
					cnt++;
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i)+ " ");
			}
			System.out.println();
			
			
			
		}
	}

}
