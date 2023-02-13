import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;


public class Main {
	static int N;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		int[] arr = new int[N];
		int idx=K-1;
		int num=0;
		while(list.size()!=0) {
			arr[num]=list.get(idx);
			num++;
			list.remove(idx);
			if(list.size()==0) {
				break;
			}
			idx+=K-1;
			if(idx>=list.size()) {
				idx=idx%list.size();
			}
		}
		System.out.print("<");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i!=arr.length-1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
		arr= new int[N];
		
	}
	
}
