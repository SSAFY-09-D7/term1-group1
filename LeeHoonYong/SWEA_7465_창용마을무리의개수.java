import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			parents = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parents[i]=i;
			}
			for (int i = 0; i < M; i++) {
				s=br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				union(a,b);
			}
			int cnt=0;
			
			for (int i = 1; i < parents.length; i++) {
				if(parents[i]==i) {
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}

	}

	private static void union(int a, int b) {
		int pa =find(a);
		int pb = find(b);
		
		if(pa!=pb) {
			parents[pa]= pb;
		}
	}

	private static int find(int b) {
		if(parents[b]==b) return b;
		else {
			return parents[b]=find(parents[b]);
		}		
	}
}

