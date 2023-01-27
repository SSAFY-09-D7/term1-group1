import java.util.*;
import java.io.*;
 
public class Swea1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
         
        int t = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= t; tc++) {
            sb.append("#"+tc+" ");
            int n = Integer.parseInt(br.readLine());
            long[] stock = new long[n];
            st = new StringTokenizer(br.readLine());
            long ans = 0;
             
            for(int i = 0; i < n; i++) {
                stock[i] = Long.parseLong(st.nextToken());
            }
             
            long max = 0L;
             
            for(int i = n - 1; i >= 0; i--) {
                if (stock[i] > max) max = stock[i];
                else if (stock[i] < max) ans += max - stock[i];
            }
             
            sb.append(ans+"\n");
        }
         
        System.out.println(sb);
    }
}
