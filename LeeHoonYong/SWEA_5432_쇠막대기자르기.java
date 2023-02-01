package homeStudy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
class Solution {
    public static Stack<Character> st = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T;t++) {    
            int num=0;
            int result=0;
            String s = br.readLine();
 
            for(int i=0;i<s.length();i++) {
                if(s.charAt(i)=='(') {
                    st.push(s.charAt(i));
                    num+=1;
                }else if(s.charAt(i)==')') {
                    if(s.charAt(i-1)=='(') {//레이저일때
                        st.pop();
                        num-=1;
                        result+=num;                            
                    }
                    else { //막대기가 끝날 때
                    	if(!st.isEmpty()) {
                    		st.pop();
                            num-=1;
                            result+=1;
                    	}
                    }
 
                }
            }
            bw.write("#"+t+" "+result);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
