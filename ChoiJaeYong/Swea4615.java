import java.io.*;
import java.util.StringTokenizer;
 
public class Swea4615 {
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
    static int N, M;
    static int[][] arr;
     
    static void initialize(int[][] arr) {
        int N = arr.length;
        arr[N / 2][N / 2] = arr[N / 2 - 1][N / 2 - 1] = 2;
        arr[N / 2 - 1][N / 2] = arr[N / 2][N / 2 - 1] = 1;
        return;
    }
     
    static void eat(int sx, int sy, int color) {
        for(int k = 0; k < 8; k++) {
            int x = sx + dx[k], y = sy + dy[k];
             
            while(!(x < 0 || x >= N || y < 0 || y >= N || arr[x][y] == 0)) {
                if (arr[x][y] == color) {
                    for(int i = 1; i < Math.max(Math.abs(sx - x), Math.abs(sy - y)); i++) {
                        arr[sx + dx[k] * i][sy + dy[k] * i] = color;
                    }
                    break;
                }else {
                    x += dx[k]; y += dy[k];
                }
            }
        }
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
            sb.append("#"+tc+" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());M = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            initialize(arr);
             
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int ty = Integer.parseInt(st.nextToken()) - 1, tx = Integer.parseInt(st.nextToken()) - 1, color = Integer.parseInt(st.nextToken());
 
                arr[tx][ty] = color;
 
                eat(tx, ty, color);
            }
             
            int black = 0, white = 0;
             
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] == 1) black++;
                    else if (arr[i][j] == 2) white++;
                }
            }
            sb.append(black+" "+white+"\n");
        }
         
        System.out.println(sb);
    }
}
