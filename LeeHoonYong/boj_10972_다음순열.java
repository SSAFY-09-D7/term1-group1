import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {


	static int[] arr;	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		String[] s = br.readLine().split(" ");
		arr= new int[N];
		for (int i = 0; i < N; i++) {
			arr[i]= Integer.parseInt(s[i]);
		}

		if(solve(arr)) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+" ");
			}
		}else {
			System.out.print(-1);
		}


	}
	private static boolean solve(int[] inCard) {
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
