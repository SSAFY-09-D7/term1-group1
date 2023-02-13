import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Pair{
	int x;
	int y;

	public Pair(int x, int y) {
		this.x=x;
		this.y=y;
		
	}
}
public class Main {
	
	private static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		Stack<Pair> st = new Stack<>();
		arr= new int[s.length];
		for (int i = s.length-1; i >=0; i--) {
			if(st.isEmpty()) {
				st.push(new Pair(i,Integer.parseInt(s[i])));
			}else {
				while(!st.isEmpty()) {
					if(st.peek().y<Integer.parseInt(s[i])) {	
						arr[st.peek().x]=i+1;
						st.pop();
					}else {
						break;
					}
				}
				st.push(new Pair(i,Integer.parseInt(s[i])));
			}
		}
		while(!st.empty()) {
			arr[st.peek().x]=0;
			st.pop();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
}
