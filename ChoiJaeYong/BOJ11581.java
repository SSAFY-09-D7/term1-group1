import java.util.*;

public class BOJ11581 {
	static List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static int N;
	static boolean[] v;
	
	static void dfs(int x) {
		for(int neighbor : adj.get(x)) {
			if (v[neighbor]) {
				System.out.println("CYCLE");
				System.exit(0);
			}
			
			v[neighbor] = true;
			dfs(neighbor);
			v[neighbor] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		adj = new ArrayList<ArrayList<Integer>>();
		
		adj.add(new ArrayList<>());
		
		for(int i = 1; i <= N; i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i = 1; i < N; i++) {
			int cnt = sc.nextInt();
			
			for(int j = 0; j < cnt; j++) {
				adj.get(i).add(sc.nextInt());
			}
		}
		
		v = new boolean[N + 1];
		v[1] = true;
		dfs(1);
		v[1] = false;
		
		System.out.println("NO CYCLE");
	}
}
