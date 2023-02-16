import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	static int[][] realmap;
	static int[][] rot;
	static int[] rotorder;
	static int minsum;
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		int[][] map = new int[N+1][M+1];
		realmap=new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			s = br.readLine().split(" ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
				realmap[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		rot= new int[K][3];
		for (int i = 0; i < K; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				rot[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		rotorder = new int[K];
		for(int i=0;i<K;i++) {
			rotorder[i]=i;
		}
		minsum=Integer.MAX_VALUE;
		do {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = realmap[i][j];
				}
			}
			for (int i = 0; i < rotorder.length; i++) {
				rotate(rot[rotorder[i]][0],rot[rotorder[i]][1],rot[rotorder[i]][2],map);
			}

			
			for (int i = 1; i < map.length; i++) {
				int sum=0;
				for (int j = 1; j < map[i].length; j++) {
					sum+=map[i][j];
				}
				minsum=Math.min(minsum, sum);
				
			}
			
		}while(np(rotorder));
		
		System.out.println(minsum);
	}
	
	private static void rotate(int r, int c, int s, int[][]map) {
		//System.out.println("r c s : "+r+" "+c+" "+s);
		int str = r-s-1; //배열 시작 circle 
		int enr = r+s+1; // 배열 끝 circle
		int stc = c-s-1;
		int enc = c+s+1;
		
		for(int N = 1; N <= s; N++) {
			rotate2(str+N,enr-N,stc+N,enc-N,map);
		}
	}
	
	private static void rotate2(int str, int enr, int stc, int enc,int[][] map) {
		//N행 돌리기
		int temp=map[str][stc];
		//System.out.println(tempr);
		for (int i = str+1; i <=enr; i++) { //2~5
			map[i-1][stc]=map[i][stc];
		}
		
		for (int i = stc+1; i <=enc; i++) {
			map[enr][i-1]=map[enr][i];
		}
		for (int i = enr-1; i >=str; i--) {
			map[i+1][enc]=map[i][enc];
		}
		
		for (int i = enc-1; i >=stc; i--) {
			map[str][i+1]=map[str][i];
		}
		
		map[str][stc+1]=temp;
				
	}
	
	private static boolean np(int[] inCard) {
		int n = inCard.length;
		int i = n-1;
		while(i>0 && inCard[i-1] >= inCard[i]) --i;
		if(i==0) return false;


		int j= n-1;
		while(inCard[i-1] >= inCard[j]) --j;

		swap(inCard, i-1, j);

		int k = n-1;
		while(i<k) {
			swap(inCard, i++, k--);
		}

		return true;
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
