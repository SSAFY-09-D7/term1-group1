import java.util.*;
import java.io.*;
public class Main {

	static char[][] arr;
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr=new char[N][3];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0] =s[0].charAt(0);
			arr[i][1] =s[1].charAt(0);
			arr[i][2] =s[2].charAt(0);
		}
		Arrays.sort(arr, new Comparator<char[]>() {

			@Override
			public int compare(char[] o1, char[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
		
		solve(0);
		System.out.println();
		solve1(0);
		System.out.println();
		solve2(0);
		

	}


	private static void solve2(int idx) {
		if(idx==(int)('.'-'A')) {
			return;
		}


		solve2((int)(arr[idx][1]-'A'));
		solve2((int)(arr[idx][2]-'A'));
		System.out.print(arr[idx][0]);
		
	}


	private static void solve1(int idx) {
		if(idx==(int)('.'-'A')) {
			return;
		}

		solve1((int)(arr[idx][1]-'A'));
		System.out.print(arr[idx][0]);		
		solve1((int)(arr[idx][2]-'A'));
	}


	private static void solve(int idx) {
		if(idx==(int)('.'-'A')) {
			return;
		}
		
		System.out.print(arr[idx][0]);

		solve((int)(arr[idx][1]-'A'));
		solve((int)(arr[idx][2]-'A'));

	}





}
