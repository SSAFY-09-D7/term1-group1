package homeStudy;

import java.io.BufferedReader;

import java.io.IOException;
 
import java.io.InputStreamReader;
//정답
public class SWEA_1873_상호의_배틀필드 {
 
    static int[] a;
 
    static int[] b;
 
    static boolean check=false;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            String[] s=br.readLine().split(" ");
 
            int H = Integer.parseInt(s[0]);
            int W= Integer.parseInt(s[1]);
 
            int th=0;
            int tw=0;
 
            int[][] board = new int [H][W];
 
            for(int i=0;i<H;i++) {
                s=br.readLine().split(" ");
                for(int j=0;j<W;j++) {
                    board[i][j]=s[0].charAt(j);
                    if(s[0].charAt(j)=='<' ||s[0].charAt(j)=='^'
                            ||s[0].charAt(j)=='v'||s[0].charAt(j)=='>') {
                        th=i;
                        tw=j;
                    }
                }
            }
 
            int n=Integer.parseInt(br.readLine());
            String str=br.readLine();
 
            for(int i=0;i<n;i++) {
                if(str.charAt(i)=='S') { //포탄발사
                    if(board[th][tw]=='<') {
                        for(int j=tw-1;j>=0;j--) {
                            if(board[th][j]=='#') {
                                break;
                            }else if(board[th][j]=='*') {
                                board[th][j]='.';
                                break;
                            }
                        }
                    }
                    if(board[th][tw]=='>') {
                        for(int j=tw+1;j<W;j++) {
                            if(board[th][j]=='#') {
                                break;
                            }else if(board[th][j]=='*') {
                                board[th][j]='.';
                                break;
                            }
                        }
                    }
                    if(board[th][tw]=='^') {
                        for(int j=th-1;j>=0;j--) {
                            if(board[j][tw]=='#') {
                                break;
                            }else if(board[j][tw]=='*') {
                                board[j][tw]='.';
                                break;
                            }
                        }
                    }
                    if(board[th][tw]=='v') {
                        for(int j=th+1;j<H;j++) {
                            if(board[j][tw]=='#') {
                                break;
                            }else if(board[j][tw]=='*') {
                                board[j][tw]='.';
                                break;
                            }
                        }
                    }
                }
                if(str.charAt(i)=='U') {
                    board[th][tw]='^';
                    if(th-1>=0) {
                        if(board[th-1][tw]=='.') {
                            board[th-1][tw]='^';
                            board[th][tw]='.';
                            th=th-1;
                        }
                    }
                }
                if(str.charAt(i)=='D') {
                    board[th][tw]='v';
                    if(th+1<H) {
                        if(board[th+1][tw]=='.') {
                            board[th+1][tw]='v';
                            board[th][tw]='.';
                            th=th+1;
                        }
                    }
                }
                if(str.charAt(i)=='L') {
                    board[th][tw]='<';
                    if(tw-1>=0) {
                        if(board[th][tw-1]=='.') {
                            board[th][tw-1]='<';
                            board[th][tw]='.';
                            tw=tw-1;
                        }
                    }
                }
                if(str.charAt(i)=='R') {
                    board[th][tw]='>';
                    if(tw+1<W) {
                        if(board[th][tw+1]=='.') {
                            board[th][tw+1]='>';
                            board[th][tw]='.';
                            tw=tw+1;
                        }
                    }
                }
            }
            System.out.print("#"+t+" ");
            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    System.out.print((char)board[i][j]);
                }
                System.out.println();
            }
             
        }
         
 
    }
 
}