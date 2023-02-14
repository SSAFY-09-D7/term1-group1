import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int num=0;
	static int[] arr;

	static StringBuilder sb=new StringBuilder();
	static int[] selected;
	static ArrayList<Integer> array;
	static ArrayList<String> dual;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		arr = new int[n];
		dual = new ArrayList<>();
		selected= new int[n];

		array=new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			arr[i]=Integer.parseInt(s[i]);
		}

		Arrays.sort(arr);
		solve(0);

	}
	private static void solve(int num) {

		if(num==m) {
			for (int i = 0; i < array.size(); i++) {	
				System.out.print(array.get(i)+" ");
			}
			System.out.println();
			return;
		}
		int temp=-1;
		for (int i = 0; i < n; i++) {			
			if(selected[i]==1) continue;
			if(temp!=-1 &&arr[temp]==arr[i]) continue;
			selected[i]=1;
			temp=i;
			array.add(arr[i]);			
			solve(num+1);
			selected[i]=0;
			array.remove(array.size()-1);
		}
	}	
}
