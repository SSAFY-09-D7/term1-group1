import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
 
class Point{
    int r;
    int c;
    Point(int r, int c) {
        this.r= r;
        this.c =c;
    }
}
 
public class Solution {
    static int result;
    static int N;
    static int[][] map;
    static int[][] submap;
    static boolean[][] visited;
     
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
             
            N = Integer.parseInt(br.readLine());
            map=new int[N][N];
            submap=new int[N][N];
            //입력
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j]=Integer.parseInt(s[j]);
                    submap[i][j]=map[i][j];
                }
            }
             
            int day=0;
            result=0;
            while(day!=100) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(map[i][j]<=day) {
                            map[i][j]=0;
                        }
                    }
                }
                 
                int num=0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(map[i][j]!=0) {
                            visited=new boolean[N][N];
                            num++;
                            bfs(i,j);
                        }
                    }
                }
                result = Math.max(result, num);
                day++;
                //배열 복사
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        map[i][j]=submap[i][j];
                    }
                }
            }
             
            System.out.println("#"+t+" "+result);
        }
         
    }
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
     
    private static void bfs(int r, int c) {
        Queue<Point> q = new LinkedList<>();
         
        q.offer(new Point(r,c));
        visited[r][c]=true;
        map[r][c]=0;
         
        while(!q.isEmpty()) {
             
            Point p = q.poll();
             
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                 
                if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc]==0)continue;
                 
                q.offer(new Point(nr,nc));
                visited[nr][nc]=true;
                map[nr][nc]=0;
            }
        }
         
         
         
    }
 
}