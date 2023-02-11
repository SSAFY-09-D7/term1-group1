import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push('(');
            }else{
                if(!st.empty()){
                    if(st.peek()=='('){
                        st.pop();
                    }else{
                        answer=false;
                        return answer;
                    }
                }else{
                    answer=false;
                    return answer;
                }
                
            }
        }
        if(st.empty()){
            answer=true; 
            return answer;
        }else{
            answer=false;
            return answer;
        }

    }
}