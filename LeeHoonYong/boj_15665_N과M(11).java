import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static int num=0;
	static int[] arr;

	static StringBuilder sb=new StringBuilder();
	//static int[] selected;
	static ArrayList<Integer> array;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		arr = new int[n];
		//selected= new int[n];

		array=new ArrayList<>();
		for (int i = 0; i < s.length; i++) {
			arr[i]=Integer.parseInt(s[i]);
		}

		Arrays.sort(arr);
		solve(0);
		bw.flush();
		bw.close();
	}
	private static void solve(int num) throws IOException {

		if(num==m) {
			for (int i = 0; i < array.size(); i++) {	
				//System.out.print(array.get(i)+" ");
				bw.write(array.get(i)+" ");
			}
			bw.newLine();
			return;
		}
		int temp=-1;
		for (int i = 0; i < n; i++) {			
			//if(selected[i]==1) continue;
			if(temp!=-1 &&arr[temp]==arr[i]) continue;
			//selected[i]=1;
			temp=i;
			array.add(arr[i]);	
			solve(num+1);
			//selected[i]=0;
			array.remove(array.size()-1);
		}
	}	
	
}
