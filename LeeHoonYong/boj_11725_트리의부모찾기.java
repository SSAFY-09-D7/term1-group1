
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int N;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer>[] list = new LinkedList[N+1];
		for (int i = 0; i <N+1; i++) {
			list[i] = new LinkedList<>(); 
		}
		
		for (int i = 1; i < N; i++) {
			String[] s = br.readLine().split(" ");
			int node1 = Integer.parseInt(s[0]);
			int node2 = Integer.parseInt(s[1]);
			list[node1].add(node2);
			list[node2].add(node1);
		}
		ans = new int[N+1];
		boolean[] v = new boolean[N+1];
		
		
		dfs(1,v,list);
		
		for (int i = 2; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	
	}

	private static void dfs(int i, boolean[] v, LinkedList<Integer>[] list) {
		
		v[i]=true;
		
		for (int j = 0; j < list[i].size(); j++) {
			if(!v[list[i].get(j)]) {
				ans[list[i].get(j)]=i;
				dfs(list[i].get(j),v,list);				
			}
		}
		
	}
	


}

