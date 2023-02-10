import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		L:for(int t=1;t<=T;t++) {
			int N= Integer.parseInt(br.readLine());
			String s= br.readLine();
			Stack<Character> st = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='(' || s.charAt(i)=='['
						|| s.charAt(i)=='{' || s.charAt(i)=='<') {
					st.push(s.charAt(i));
				}else { //닫는 괄호 이면
					if(!st.isEmpty()) {
						if(s.charAt(i)==')') {
							if(st.peek()!='(') {
								
								System.out.println("#"+t+" "+0);
								continue L;
							}else {
								st.pop();
							}
						}else if(s.charAt(i)==']') {
							if(st.peek()!='[') {
								System.out.println("#"+t+" "+0);
								continue L;
							}else {
								st.pop();
							}
						}else if(s.charAt(i)=='}') {
							if(st.peek()!='{') {
								System.out.println("#"+t+" "+0);
								continue L;
							}else {
								st.pop();
							}
						}else if(s.charAt(i)=='>') {
							if(st.peek()!='<') {
								System.out.println("#"+t+" "+0);
								continue L;
							}else {
								st.pop();
							}
						}
					}else {
						System.out.println("#"+t+" "+0);
						continue L;
					}
				}
			}
			if(!st.isEmpty()) {
				System.out.println("#"+t+" "+0);
			}else {
				System.out.println("#"+t+" "+1);
			}
		}
	}
}
