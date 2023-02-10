import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	static String str;
	static StringBuilder sb;
	static int[] acgt ;
	
	static int S;
	static int P;
	static int num=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		// DNA 문자열 A C G T 로만 이루어진 문자열
		String[] s = br.readLine().split(" ");
		S =Integer.parseInt(s[0]);
		P=Integer.parseInt(s[1]);
		str = br.readLine();
		s=br.readLine().split(" ");
		acgt =new int[4];

		for (int i = 0; i < 4; i++) {
			acgt[i]=Integer.parseInt(s[i]);
		}
		int[] check =new int[4];
		solve(0,check); //idx
		System.out.println(num);
	}
	private static void solve(int idx,int[] check) {
		if(idx+P>str.length()) {
			return;
		}
		
		//sb=new StringBuilder();
		//System.out.println(str);
		if(idx==0) {
			for(int i=idx;i<idx+P;i++) {	
				if(str.charAt(i)=='A') {
					check[0]++;
				}
				if(str.charAt(i)=='C') {
					check[1]++;
				}
				if(str.charAt(i)=='G') {
					check[2]++;
				}
				if(str.charAt(i)=='T') {
					check[3]++;
				}
			}
		}
		int flag=0;
		for (int k = 0; k < 4; k++) {
			if(check[k]<acgt[k]) {
				flag=1;
				break;
			}
		}
		if(flag==0) {
			num++;
		}
		if(idx+P>=str.length()) {
			return;
		}
		
		if(str.charAt(idx)=='A') {
			check[0]--;
		}
		if(str.charAt(idx)=='C') {
			check[1]--;
		}
		if(str.charAt(idx)=='G') {
			check[2]--;
		}
		if(str.charAt(idx)=='T') {
			check[3]--;
		}
		
		if(str.charAt(idx+P)=='A') {
			check[0]++;
		}
		if(str.charAt(idx+P)=='C') {
			check[1]++;
		}
		if(str.charAt(idx+P)=='G') {
			check[2]++;
		}
		if(str.charAt(idx+P)=='T') {
			check[3]++;
		}
		
		//System.out.println(Arrays.toString(check));
		
		solve(idx+1,check);

	}
}
