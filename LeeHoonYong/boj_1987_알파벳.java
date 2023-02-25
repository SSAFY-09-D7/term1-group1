import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] v;
	static boolean[] alpabet;
	static int ans=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		
		map = new char[R][C];
		v= new boolean[R][C];
		alpabet = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		dfs(0,0,1);
		System.out.println(ans);
		
	}
	
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	private static void dfs(int r, int c, int cnt) {
		
		ans=Math.max(ans, cnt);
		
		v[r][c]=true;
		alpabet[(int)(map[r][c]-'A')]=true;
		
		for(int dir=0;dir<4;dir++) {
			
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
			if(v[nr][nc]) continue;
			if(alpabet[(int)(map[nr][nc]-'A')]) continue;
			
			v[nr][nc]=true;
			alpabet[(int)(map[nr][nc]-'A')]=true;
			
			dfs(nr,nc,cnt+1);
			
			alpabet[(int)(map[nr][nc]-'A')]=false;
			v[nr][nc]=false;
		}
	}
}

















