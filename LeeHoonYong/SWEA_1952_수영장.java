package homeStudy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Solution {
	
	//public static int[] checkboard;
	public static int[] dayarr;
	public static int[] trdmontharr;
	
	public static int year=0;
	public static int trdmonth=0;
	public static int day=0;
	public static int month=0;
	public static int result=0;
	public static void main(String[] args) throws Exception, IOException {
		
		//checkboard= new int[12];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			day = Integer.parseInt(s[0]);
			month = Integer.parseInt(s[1]);
			trdmonth = Integer.parseInt(s[2]);
			year = Integer.parseInt(s[3]);
			result=year;
			s = br.readLine().split(" ");
			dayarr = new int[s.length];
			for (int i = 0; i < s.length; i++) {
				dayarr[i]=Integer.parseInt(s[i]); //arr은 달력 배열
			}
			
			
			solve(0,0);
			System.out.println("#"+t+" "+result);
		}
	}
	public static void solve(int idx,int cost) {
		if(idx>=12) {
			result=Math.min(result, cost);
			//System.out.println(Arrays.toString(checkboard));
			return;
		}
		if(dayarr[idx]!=0) {
			//checkboard[idx]=dayarr[idx]*day;
			solve(idx+1,cost+dayarr[idx]*day);
			//checkboard[idx]=month;
			solve(idx+1 ,cost+month);
			
			//checkboard[idx]=trdmonth;
			solve(idx+3, cost+trdmonth);
		}else {
			solve(idx+1,cost);
		}
		
		return;
	}
}