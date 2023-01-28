import java.util.*;
import java.io.*;

public class Swea1208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		
		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] box = new int[100];
			st = new StringTokenizer(br.readLine());
			sb.append("#"+tc+" ");
			
			for(int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0, min = 0;
			
			for(int i = 0; i < n; i++) {
				max = min = 0;
				
				for(int j = 1; j < 100; j++) {
					if (box[j] > box[max]) max = j;
					if (box[j] < box[min]) min = j;
				}
				
				if (box[max] - box[min] <= 1) break;
				box[max] -= 1;box[min] += 1;
			}
			
			max = min = 0;
			
			for(int j = 1; j < 100; j++) {
				if (box[j] > box[max]) max = j;
				if (box[j] < box[min]) min = j;
			}
			
			sb.append((box[max] - box[min])+"\n");
		}
		System.out.println(sb);
	}
}
