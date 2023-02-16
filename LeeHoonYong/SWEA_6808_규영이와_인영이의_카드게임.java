import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Solution {
	static int[] kyuCard;
	static boolean[] arr;
	static int[] inCard;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			String[] s = br.readLine().split(" ");
			arr= new boolean[19];
			kyuCard=new int[9];
			inCard=new int[9];
			for (int i = 0; i < s.length; i++) {
				kyuCard[i]= Integer.parseInt(s[i]);
				arr[kyuCard[i]]=true;
			}
			
			int k=0;
			for (int i = 1; i < 19; i++) {
				if(arr[i]==false) {
					inCard[k]=i;
					k++;
				}
			}
			//System.out.println(Arrays.toString(kyuCard));
			//System.out.println(Arrays.toString(inCard));
			
			Arrays.sort(inCard);
			
			int kyuWin=0;
			int inWin=0;
			do {
				int kyuScore=0;
				int inScore=0;
				
				//System.out.println(Arrays.toString(inCard));
				for (int i = 0; i < 9; i++) {
					if(kyuCard[i]>inCard[i]) {
						kyuScore+=(kyuCard[i] + inCard[i]);
					}else {
						inScore+=(kyuCard[i] + inCard[i]);
					}
				}
				if(kyuScore>inScore) {
					kyuWin++;
				}else {
					inWin++;
				}
				
			}while(solve(inCard));
					
			System.out.println("#"+t+" "+kyuWin+" "+inWin);
		}	
	}
	
	private static boolean solve(int[] inCard) {
		int n = inCard.length;
		int i = n-1;
		while(i>0 && inCard[i-1] >= inCard[i]) --i;
		if(i==0) return false;
		
		
		int j= n-1;
		while(inCard[i-1] >= inCard[j]) --j;
		
		swap(inCard, i-1, j);
		
		int k = n-1;
		while(i<k) {
			swap(inCard, i++, k--);
		}
		
		return true;
	}
	
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	
}