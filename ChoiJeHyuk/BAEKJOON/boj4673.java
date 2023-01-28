package boj4673;

import java.util.*;

public class boj4673 {

	public static void main(String[] args) {
		int[] num = new int[10000];
		int[] self = new int[10000];
		int one;
		int ten;
		int hun;
		int tho;
		int check;
		int add = 0;
		boolean state = true;
		int end = 0;

		for (int i = 0; i < 10; i++) {
			check = i * 2;

			num[add] = check;
			add++;
		}

		for (int i = 10; i < 100; i++) {
			ten = i / 10;
			one = i - ten * 10;

			check = i + ten + one;
			num[add] = check;
			add++;

		}

		for (int i = 100; i < 1000; i++) {
			hun = i / 100;
			ten = (i - hun * 100) / 10;
			one = i - hun * 100 - ten * 10;

			check = i + hun + ten + one;
			num[add] = check;
			add++;
		}

		for (int i = 1000; i < 10000; i++) {
			tho = i / 1000;
			hun = (i - tho * 1000) / 100;
			ten = (i - tho * 1000 - hun * 100) / 10;
			one = i - tho * 1000 - hun * 100 - ten * 10;

			check = i + tho + hun + ten + one;
			num[add] = check;
			add++;

		}
		Arrays.sort(num);
		
		for (int i = 0; i < 10000; i++) {
			// System.out.println(num[i]);
		}
		
		while(end < 10000) {
			for(int i = 0; i<10000; i++) {
				if(num[i] == end) {
					state = false;
				}
			}
			if(state == true) {
				System.out.println(end);
			}
			state = true;
			end ++;
		}
		
		
		
		
		
	}

}
