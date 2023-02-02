package solution;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;



public class boj_16401_과자나눠주기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		//Set<Integer> set =new TreeSet<>();
		ArrayList<Integer> array = new ArrayList<>();
		s=br.readLine().split(" ");
		for(int i=0;i<s.length;i++) {
			array.add(Integer.parseInt(s[i]));
		}
		Collections.sort(array);
		int result=0;
		int st=1;
		int en=array.get(array.size()-1);
		
		int mid =0;
		while(st<=en) {
			mid=(st+en)/2;
			int cnt=0;
			for(int i=0;i<N;i++) {
				cnt+=(array.get(i)/mid); 
			}
			if(cnt>=M) {
				if(result < mid) result = mid;
				st=mid+1;
			}else {
				en=mid-1;
			}
		}
		System.out.println(result);
	}
}
