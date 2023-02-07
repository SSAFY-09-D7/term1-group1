package boj1244;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] state = new int[num+1];
		for (int i = 1; i < state.length; i++) {
			state[i] = sc.nextInt();
		}
		int student = sc.nextInt();
		int[] gen = new int[student+1];
		int[] getswitch = new int[student+1];			
		int temp = 0;
		int add = 1;
		
		for (int i = 1; i < gen.length; i++) {
			gen[i] = sc.nextInt();
			getswitch[i] = sc.nextInt();
		}
		
		for (int i = 1; i < gen.length; i++) {
			if(gen[i] == 1) {
				temp = getswitch[i];
				while(temp <= num) {
					if(state[temp] == 0) {
						state[temp] = 1;
					}
					else if(state[temp] == 1) {
						state[temp] = 0;
					}
					temp += getswitch[i] ;
				}
			}
			else if(gen[i] == 2) {
				temp = getswitch[i];
					if(state[temp] == 0) {
						state[temp] = 1;
					}
					else if(state[temp] == 1) {
						state[temp] = 0;
					}
				
				while(temp+add <= num && temp-add >0) {	
					if(state[temp+add] == state[temp-add]) {
						if(state[temp+add] == 0) {
							state[temp+add] = 1;
							state[temp-add] = 1;
						}
						else if(state[temp+add] == 1) {
							state[temp+add] = 0;
							state[temp-add] = 0;
						}
						add++;
					}
					else {
						break;
					}
				}
			}
			
		}
		
		for (int i = 1; i < state.length; i++) {
			System.out.print(state[i] + " ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}

	}

}
