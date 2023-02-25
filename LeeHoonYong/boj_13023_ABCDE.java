import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	
//	static class Point{
//		int node;
//		int level;
//		Point(int node, int level){
//			this.node=node;
//			this.level=level;
//		}
//	}
	static int flag=0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		ArrayList<Integer>[] list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			s= br.readLine().split(" ");
			int node1 =Integer.parseInt(s[0]);
			int node2= Integer.parseInt(s[1]);
			
			list[node1].add(node2);
			list[node2].add(node1);
		}
		
		//새로운 방문배열을 생성해서 초기값을 바꿔주거나,
		//재귀 체크할때 되돌아오면서 false해주거나 
		boolean[] v = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			v = new boolean[N];
			v[i]=true;
			dfs(i,1,v,list);
			if(flag==1) {
				break;
			}
		}
		if(flag==0) {
			System.out.println(0);
		}
	}
	private static void dfs(int node, int level, boolean[] v, ArrayList<Integer>[] list) {
		if(flag==1) {
			return;
		}
		if(level==5) { //5이상도 체크해야하나? 필요없다.
			System.out.println(1);
			flag=1;
			return;
			//System.exit(0);			
		}
		//v[node] = true;
		
		for (int i = 0; i < list[node].size(); i++) {
			
			if(v[list[node].get(i)]) continue;
			
			v[list[node].get(i)]=true;
			
			dfs(list[node].get(i),level+1,v,list);
			
			v[list[node].get(i)]=false;
		}
	}

	
	


}

