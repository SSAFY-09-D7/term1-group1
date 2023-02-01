package homeStudy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 1.사거나 2.아무것도 안사거나 3.팔거나

public class SWEA_1859_백만장자프로젝트 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n=Integer.parseInt(br.readLine());
			String[] s=br.readLine().split(" ");
			int[] arr= new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(s[i]);
			}
			ArrayList<Integer> cpidx = new ArrayList<>();
			int x=0;
			
			for(int i=n-1;i>=0;i--) {
				if(arr[i]>x) {
					cpidx.add(0,i);
					x=arr[i];
				}
			}
			
			int a=0;
			long store=0;//매매한 합계
			long storenum=0; //저장한 수의 개수
			long sell=0;//이득
			for(int i=0;i<n;i++) {
				if(a==cpidx.size()) {
					break;
				}
				if(i==cpidx.get(a)) {
					sell+=(arr[i]*storenum);
					sell-=store;
					store=0;
					storenum=0;
					a++;
				}else {
					store+=arr[i];
					storenum++;
				}
				
			}
			bw.write("#"+t+" "+String.valueOf(sell));
			bw.newLine();
			
		}
		bw.flush();
		bw.close();
	}

}
