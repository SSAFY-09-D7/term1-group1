import java.util.*;
import java.io.*;

public class BOJ17471 {
	static int N;
	static int[] population;
	static List<List<Integer>> adj = new ArrayList<List<Integer>>();
	static int[] sel;
	static int ans = Integer.MAX_VALUE;
	
	static boolean bfs() {
		int zero = -1, one = -1;
		
		for(int i = 0; i < N; i++) {
			if (zero == -1 && sel[i] == 0) zero = i;
			if (one == -1 && sel[i] == 1) one = i;
		}
		
		if (zero == -1 || one == -1) return false;
		
		int[] v = new int[N];
		Queue<Integer> q = new LinkedList<>();
		
		//zero land
		q.add(zero);
		v[zero] = 1;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int neighbor : adj.get(node)) {
				if (v[neighbor] == 1 || sel[node] != sel[neighbor]) continue;
				v[neighbor] = 1;
				q.add(neighbor);
			}
		}
		
		//one land
		q.add(one);
		v[one] = 1;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			
			for(int neighbor : adj.get(node)) {
				if (v[neighbor] == 1 || sel[node] != sel[neighbor]) continue;
				v[neighbor] = 1;
				q.add(neighbor);
			}
		}
		
		for(int i = 0; i < N; i++) if (v[i] == 0) return false;
		return true;
	}
	
	static void solve(int k) {
		if (k == N) {
			if (bfs() == false) return; 
			int zero = 0, one = 0;
			
			for(int i = 0; i < N; i++) {
				if (sel[i] == 0) zero += population[i];
				else one += population[i];
			}
			
			ans = Math.min(ans, Math.abs(zero - one));
			
			return;
		}
		
		solve(k + 1);
		sel[k] = 1;
		solve(k + 1);
		sel[k] = 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		sel = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			adj.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < M; j++) {
				adj.get(i).add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		
		solve(0);
		
		if (ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
}
