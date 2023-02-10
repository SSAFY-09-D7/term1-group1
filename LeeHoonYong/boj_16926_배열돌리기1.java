import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min;
	static int[][] map;
	
	public static void rotate() {

		int lenW=M;
		int lenH=N;
		for (int i = 1; i <= min; i++) { //min
			int temp = map[i][i];
			for (int j =i+1; j < i+lenW; j++) { //1
				map[i][j-1]=map[i][j];
			}
			for (int j = i+1; j < i+lenH; j++) {//2
				map[j-1][lenW+i-1]=map[j][lenW+i-1];
			}
			for (int j =i+lenW-2; j >=i; j--) {//3
				map[i+lenH-1][j+1]=map[i+lenH-1][j];
			}		
			for (int j = i+lenH-2; j >=i; j--) {//4
				//map[i+lenH-1][j+1]=map[i+lenH-1][j];
				map[j+1][i]=map[j][i];
			}
			map[i+1][i]=temp;
			lenW -= 2;
			lenH -=2;
		}
		
//		for (int i = 1; i <N+1; i++) {
//			for (int j = 1; j < M+1; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}



	}




	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		min = Math.min(N/2, M/2);

		int K = Integer.parseInt(st.nextToken());

		map = new int[N+1][M+1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}

		for (int i = 0; i < K; i++) {
			rotate();
		}


		for (int i = 1; i <N+1; i++) {
			for (int j = 1; j < M+1; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}



	}
}
