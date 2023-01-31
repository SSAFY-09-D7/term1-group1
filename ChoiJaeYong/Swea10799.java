import java.util.*;

public class Swea10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(sc.nextLine());
		StringBuffer print = new StringBuffer();
		
		for(int tc = 1; tc <= T; tc++) {
			int ans = 0;
			String string = sc.nextLine();
			int line = 0;
			
			print.append("#"+tc+" ");
			
			for(int i = 0; i < string.length(); i++) {
				sb.append(string.charAt(i));
				
				if (sb.charAt(sb.length() - 1) == '(') {
					ans++;
					line++;
				}else {
					//레이저
					if (sb.charAt(sb.length() - 2) == '(') {
						ans--;
						line--;
						
						ans += line;
					}else {
						line--;
					}
				}

			}
			print.append(ans+"\n");
		}
		System.out.println(print);
	}
}
