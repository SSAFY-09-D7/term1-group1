import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int minus = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] sour = new int[n]; // 신맛
		int[] bitter = new int[n]; // 쓴맛
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());			
		}
		
		for (int i = 0; i < n+1; i++) {
			recursive(sour, bitter,new int[i], new int[i],0,0);
			
		}
		System.out.println(minus);
		

	}

	private static void recursive(int[] sour, int[] bitter,int[]staste, int[]btaste, int idx, int k) {
		
		if(k == btaste.length) {
			int bsum = 0;
			int ssum = 1;
			
			for (int i = 0; i < btaste.length; i++) {
				bsum += btaste[i];
				ssum *= staste[i];
				if(minus > Math.abs(ssum - bsum)) {
					minus = Math.abs(ssum - bsum);
				}
				
			}	

			return;
		}
			
		for (int i = idx; i < bitter.length; i++) {
			btaste[k] = bitter[i];
			staste[k] = sour[i];
			recursive(sour,bitter,staste, btaste,i+1,k+1);
			
		}
		
	}

}
