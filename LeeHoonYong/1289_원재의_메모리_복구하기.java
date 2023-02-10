import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			String s = br.readLine();
			int[] arr = new int[s.length()];
			for(int i=0;i<arr.length;i++) {
				arr[i]=s.charAt(i)-'0';
			}
			int[] now = new int[arr.length];
			int num=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]!=now[i]) {
					num++;
					for(int j=i;j<arr.length;j++) {
						if(arr[i]==0) {
							now[j]=0;
						}else {
							now[j]=1;
						}
					}
				}
			}
			System.out.println("#"+t+" "+num);
		}
	}

}
