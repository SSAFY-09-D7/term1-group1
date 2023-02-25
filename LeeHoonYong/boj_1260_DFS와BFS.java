import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;


public class Main {
	static int map[][];
	static boolean bfsv[];
	static boolean dfsv[];
	static int N;
	static int M;
	static int V;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s =br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		V = Integer.parseInt(s[2]);

		map = new int[N+1][N+1];
		
		bfsv = new boolean[N+1];
		dfsv = new boolean[N+1];

		
		for (int i = 0; i < M; i++) {
			s= br.readLine().split(" ");
			int r = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);
			map[r][c]=1;
			map[c][r]=1;
		}
		
		System.out.print(V+" ");
		dfs(V);
		
		System.out.println();
		
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(V);
		bfsv[V]=true;
		
		while(! q.isEmpty()) {
			int num = q.poll();
			System.out.print(num+" ");
			for(int i=1;i<N+1;i++) {
				if(map[num][i]==1 && !bfsv[i]) {
					q.offer(i);
					bfsv[i]=true;
				}
			}
		}
		


	}
	private static void dfs(int v) {
		dfsv[v]=true;
		for (int i = 1; i < N+1; i++) {
			if(map[v][i]==1 && !dfsv[i]) {
				System.out.print(i+" ");
				dfs(i);
			}
		}
		
	}


}

