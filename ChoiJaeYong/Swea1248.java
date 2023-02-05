import java.io.*;
import java.util.*;

public class Swea1248 {
	static int V, E, A, B;
	static List<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
	static int[] v = new int[10001];
	static int ans;
	static int[] parentV = new int[10001];
	static boolean foundA, foundB;
	
	static int elseMethod(Stack<Integer> pstack) {
		while(!pstack.isEmpty()) {
			int parentOfNode = pstack.pop();
			
			if (parentV[parentOfNode] == 1) {
				ans = parentOfNode;
				break;
			};
		}
		
		return 1;
	}
	
	static int traverse(int node, Stack<Integer> pstack) {
		if (node == A) {
			foundA = true;
			
			if(foundB == false) {
				for(int i = 0; i < pstack.size(); i++) {
					parentV[pstack.get(i)] = 1;
				}
				
				return 0;
			}else {
				return elseMethod(pstack);
			}
		}else if (node == B) {
			foundB = true;
			
			if(foundA == false) {
				for(int i = 0; i < pstack.size(); i++) {
					parentV[pstack.get(i)] = 1;
				}
				
				return 0;
			}else {
				return elseMethod(pstack);
			}
		}
		
		for(int i = 0; i < tree.get(node).size(); i++) {
			int neighbor = tree.get(node).get(i);
			
			if (v[neighbor] == 1) continue;
			
			v[neighbor] = 1;
			pstack.add(neighbor);
			if (traverse(neighbor, pstack) == 1) return 1;
			pstack.pop();
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			foundA = foundB = false;
			ans = 1;
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());E = Integer.parseInt(st.nextToken());A = Integer.parseInt(st.nextToken());B = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < V + 1; i++) {
				parentV[i] = v[i] = 0;
				tree.add(new ArrayList<Integer>());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int e = 0; e < E; e++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				tree.get(parent).add(child);
			}

			traverse(1, new Stack<Integer>());
			
			Queue<Integer> q = new LinkedList<>();
			q.add(ans);
			int cnt = 1;

			while(!q.isEmpty()) {
				int node = q.poll();

				for(int i = 0; i < tree.get(node).size(); i++) {
					q.add(tree.get(node).get(i));
					cnt++;
				}
			}
			
			sb.append(ans+" "+cnt+"\n");
			tree.clear();
		}
		
		System.out.println(sb);
	}
}
