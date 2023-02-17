import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
public class Main {

	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int[] fruit = new int[N];
		for (int i = 0; i < N; i++) {
			fruit[i] = Integer.parseInt(s[i]);
		}
		
		Arrays.sort(fruit);
		
		for (int i = 0; i < fruit.length; i++) {
			if(fruit[i]<=L) {
				L++;
			}else {
				System.out.println(L);
				return;
			}
		}
		System.out.println(L);
	}
}
