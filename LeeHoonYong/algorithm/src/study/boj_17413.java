package study;


import java.util.ArrayList;
import java.util.Scanner;

public class boj_17413 {
	static ArrayList<Character> arr = new ArrayList<Character>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;
		
		s=sc.nextLine(); //공백을 포함한 전체문자열을 받기 위해 nextLine()으로 받음.
		/**
		 * 1. 태그까지 뒤집으면 안된다.
		 * 2. 공백도 뒤집으면 안된다.
		 * 3. 문자만 뒤집기 위한 처리가 필요
		 * 총 4가지를 처리해줘야 함
		 * 1-1 처음에 나오는 태그
		 * 1-2 문자가 끝난 후 나오는 태그(while문 도중에 발견)
		 * 2-1 먼저 공백이 나옴 " good"
		 * 2-2 공백이 뒤에 나옴 "good "
		 * 3 while 문 도중에 string이 끝난경우 
		 */
		for(int i=0;i<s.length();i++) {//뒤집지 않는 문자열
			if(s.charAt(i)=='<') {//1-1
				arr.add(s.charAt(i));
				i++;
				while(i!=s.length()) {//3
					arr.add(s.charAt(i));
					if(s.charAt(i)== '>') break;
					i++;
				}
				
			}else{//뒤집음.
				if(s.charAt(i)==' ') {//2-1 처음부터 나오는 공백
									//공백이 나오면 array에 추가하고 for문 1회 더 돌림.
					arr.add(s.charAt(i));
					continue;
				}
				ArrayList<Character> reverse = new ArrayList<Character>();
				while(i!=s.length()) { //3 뒤집을 문자
					if(s.charAt(i)==' ') {//2-2 문자가 끝나고 나오는 공백
						i--;//for문 인덱스 처리
						break;
					}
					if(s.charAt(i)=='<') {//1-2 태그가 나오면 뒤집지않기위해 for루프를 1회 더 돌림
						i--;
						break;
					}
					reverse.add(s.charAt(i)); //뒤집을값 array에 추가
					i++;
				}
				if(reverse.size()!=0) { //뒤집을 문자 존재
					for(int j=reverse.size()-1;j>=0;j--) { //reverse Array를 arr Array에 추가
						arr.add(reverse.get(j));
					}
				}
			}
		}
		for(int i=0;i<arr.size();i++) {
			System.out.print(arr.get(i));
		}
	}

}
