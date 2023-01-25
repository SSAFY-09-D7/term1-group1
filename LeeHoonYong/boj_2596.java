package homeStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_2596 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		char[][] c=new char[n][6];
		String[] alpa=new String[8];
		alpa[0]= "000000";//A
		alpa[1]= "001111";//B
		alpa[2]= "010011";//C
		alpa[3]= "011100";//D
		alpa[4]= "100110";//E
		alpa[5]= "101001";//F
		alpa[6]= "110101";//G
		alpa[7]= "111010";//H
		
		String ss=sc.next();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<6;j++) {
				c[i][j]=ss.charAt((i*6)+j);
			}
		}
		ArrayList<Character> array=new ArrayList<Character>();
		int check=0;
		for(int i=0;i<n;i++) {
			check=0;
			for(int k=0;k<8;k++) {
				int num=0;
				for(int j=0;j<6;j++) {
					if(alpa[k].charAt(j)==c[i][j]) {
						num++;
					}
				}
				if(num==6 || num==5) {
					int a=k+'A';
					array.add((char)a);
					check=1;
				}
			}
			if(check==0) { //문자를 알아볼수 없음
				System.out.println(i+1);
				return;
			}
		}
		for(int i=0;i<array.size();i++) {
			System.out.print(array.get(i));
		}
		
	}
	
}