package homeStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class SWEA_7964_부먹왕국의_차원_관문 {
	
	//tip 처음에 0번위치와 N+1번 위치에 차원관문이 없다고 생각해서 오래걸렸다. 문제 잘읽기

	//이동 제한 거리가 1이면 0이 1개 이상 있으면 안된다.
	//이동 제한 거리가 2이면 0이 2개 이상 있으면 안된다.
	//이동 제한 거리가 3이면 0이 3개 이상 있으면 안된다.
	//이동 제한 거리가 3 일때
	//0이 5개 연속 =1개
	//0이 6개 연속 =2개 001001
	//0이 7개 연속 =  0010010
	//0이 9개 연속 = 001001001
	//0이 14개 연속, 이동제한거리4 00010001000100
	//점화식 = 0의개수/이동 제한거리 (내림)
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			result=0;
			String[] s=br.readLine().split(" ");
			int city=Integer.parseInt(s[0]+2);
			int dis=Integer.parseInt(s[1]);
			String[] s1=br.readLine().split(" ");
			int[] map = new int[s1.length+2];
			map[0]=1;
			map[map.length-1]=1;
			for(int i=0;i<s1.length;i++) {
				map[i+1]=Integer.parseInt(s1[i]);
			}//입력 완료
			int count=0;
			for(int i=0;i<map.length;i++) {
				if(map[i]==0 ) {
					count+=1;
				}else {				
					result+=(count/dis);
					count=0;
				}

			}

			bw.write("#"+String.valueOf(t)+" "+String.valueOf(result));
			bw.newLine();

		}
		br.close();
		bw.flush();
		bw.close();
	}

}

