import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
public class Main {

	static int[][] board;
 	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		String[] s = br.readLine().split(" ");
		
		for (int i = 1; i < N+1; i++) {
			arr[i]=Integer.parseInt(s[i-1]);
		}
		
		int stu = Integer.parseInt(br.readLine());
		int[][] student = new int[stu][2];
		for (int i = 0; i < stu; i++) {
			s = br.readLine().split(" ");
			student[i][0] = Integer.parseInt(s[0]);
			student[i][1] = Integer.parseInt(s[1]);
		}
		for (int i = 0; i < student.length; i++) {

			if(student[i][0]==1) { //남학생	
				int temp=student[i][1];
				
				while(true) {
					
					if(student[i][1]>N) {
						break;
					}
					if(arr[student[i][1]]==0) {
						arr[student[i][1]]=1;
					}else {
						arr[student[i][1]]=0;
					}
					student[i][1]+=temp;
				}
			}
			else {// 여학생
				int start=student[i][1];
				int left=student[i][1];
				int right=student[i][1];
				while(true) {
					if(left<1 || right>N) {
						break;
					}
					
					if(arr[left] == arr[right]) {
						if(arr[left]==0) {
							arr[left]=1;
						}else {
							arr[left]=0;
						}
						
						if(arr[right]==0) {
							arr[right]=1;
						}else {
							arr[right]=0;
						}
						left--;
						right++;
					}else {
						break;
					}
					
				}
				
				if(arr[start]==0) {
					arr[start]=1;
				}else {
					arr[start]=0;
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) {
				System.out.println();
			}
		}
		
		
	}
}
