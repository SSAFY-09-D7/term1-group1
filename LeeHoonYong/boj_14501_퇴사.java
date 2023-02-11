
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int N;
	static int num;
	static int result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][2];
		for(int i=1;i<=N;i++) {
			String[] s = br.readLine().split(" ");
			arr[i][0]=Integer.parseInt(s[0]);
			arr[i][1]=Integer.parseInt(s[1]);
		}

		int[] sel = new int[N+1];

		solve(arr,sel,1);//idx 편의상 1번부터 했음
		System.out.println(result);

	}

	private static void solve(int[][] arr,int[] sel,int idx) {
		if(idx==N+1) {
			//조합 한거 중에 날짜 안되는 조합 다 삭제
			for (int i = 0; i < sel.length; i++) {
				if(sel[i]==1) {
					if(i+arr[i][0]>sel.length) {
						return;
					}else {
						for(int j=i+1;j<i+arr[i][0];j++) {
							if(sel[j]==1) {
								return;
							}
						}
					}
				}
			}
//			num++; //개수출력
//			for (int i = 1; i < sel.length; i++) {
//				System.out.print(sel[i]+" ");
//			}
//			System.out.println();
			
			//종료
			int sum=0;
			for (int i = 1; i < sel.length; i++) {
				if(sel[i]==1) {
					sum+=arr[i][1];
				}
			}
			result=Math.max(result, sum);
			return;
		}
		//조합 재귀 돌려줌 선택한거와 안한거 두개로 N번째 idx 까지
		sel[idx]=1;
		solve(arr,sel,idx+1);
		sel[idx]=0;
		solve(arr,sel,idx+1);


	}

}
