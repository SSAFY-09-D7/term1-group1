package solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class boj_1822_차집합 {
	static int[] a;
	static int[] b;	
	static int p;
	static boolean check=false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


		int result =0;
		String[] s = br.readLine().split(" ");
		int na = Integer.parseInt(s[0]);
		int nb = Integer.parseInt(s[1]);
		a =new int[na];
		b = new int [nb];
		s=br.readLine().split(" ");
		for(int i=0;i<na;i++) {
			a[i]=Integer.parseInt(s[i]);
		}
		s=br.readLine().split(" ");
		for(int i=0;i<nb;i++) {
			b[i]=Integer.parseInt(s[i]);
		}
		//입력완료
		
		//sort
		Arrays.sort(a);
		Arrays.sort(b);

		ArrayList<Integer> array = new ArrayList<>(); 
		int num=0;
		for(int i=0;i<a.length;i++) {
			binary_search(a[i],0,nb-1);
			if(check==true) {
				check=false;
			}else {
				array.add(a[i]);
				num++;
			}
		}

		System.out.println(num);
	

		for(int i=0;i<array.size();i++) {
			System.out.print(array.get(i)+" ");
		}

		br.close();
	}
	static void binary_search(int k,int st, int en) {
		p=st+(en-st)/2;
		if(st>en) {
			return;
		}
		if(b[p]==k) {
			check=true;
			return;
		}else if(b[p]>k) {
			binary_search(k,st,p-1);

		}else if(b[p]<k) {
			binary_search(k,p+1,en);

		}
	}

}
