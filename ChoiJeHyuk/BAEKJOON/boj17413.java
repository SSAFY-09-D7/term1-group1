package boj17413;

import java.util.*;

public class boj17413 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack st = new Stack();
		int check = 0; // 뒤집을지 안뒤집을지 확인
		String input = sc.nextLine();
		StringBuilder result = new StringBuilder();
		
		for(char ch : input.toCharArray()) {
			if(ch == '<') {
				check+=1; 
				while(!st.isEmpty()) {
					result.append(st.pop());
				}
				result.append("<");
			} 
			
			else if(ch == '>') {
				check-=1; 
				result.append(">");
			} 
			
			else if(ch == ' ') {
				
				while(!st.isEmpty())
					result.append(st.pop());
				result.append(" ");
			} 
			
			else {
				if(check == 0) 
					st.push(ch);
				else 
					result.append(ch);
			}
		}
		
		
		while(!st.isEmpty())
			result.append(st.pop());
		
		System.out.println(result);
		return;
	}
}

