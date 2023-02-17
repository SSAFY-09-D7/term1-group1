import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
public class Main {

	static int[] arr;
	static int[] map;
	static int[] res;
	static int[] mask;
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		map = new int[9];
		res = new int[9];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			map[i] = arr[i];
		}
		
		Arrays.sort(arr);
		
		
		mask= new int[9];
		for (int i = mask.length-1; i >= mask.length - 7; i--) {
			mask[i] = 1;
		}
	
		do {
			//System.out.println(Arrays.toString(mask));
			int sum=0;
			for (int i = 0; i < mask.length; i++) {
				if(mask[i]==1) {
					sum+=arr[i];
				}
			}
			if(sum==100) {
				for (int i = 0; i < mask.length; i++) {
					if(mask[i]==1) {
						//System.out.println(arr[i]);
						for (int j = 0; j < map.length; j++) {
							if(arr[i]==map[j]) {
								res[j]=arr[i];
							}
						}
					}
				}
				for (int i = 0; i < res.length; i++) {
					if(res[i]==0) {
						continue;
					}
					System.out.println(res[i]);
				}
			}
		}while(np(mask));
		
	}
	private static boolean np(int[] input) {
		
		int n = input.length;
		
		int i = n-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		if(i==0) return false;
		
		int j = n-1;
		while(input[i-1]>=input[j]) --j;
		
		swap(input, i-1, j);
		
		int k =n-1;
		while(i<k) swap(input, i++,k--);
		return true;
	}
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
		
	}
}
