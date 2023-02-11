import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] arr= new int[progresses.length];
        ArrayList<Integer> array = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<progresses.length;i++){
            int k=0;
            if((100-progresses[i])%speeds[i]==0){
                k = (100-progresses[i])/speeds[i];
            }else{
                k = (100-progresses[i])/speeds[i]+1;
            }
            arr[i]=k;
        }
        for(int i=arr.length-1;i>=0;i--){
            st.push(arr[i]);
        }
        while(!st.empty()){
            int now =st.peek();
            int num=0;
            while(!st.empty()){
                if(st.peek()<=now){
                    st.pop();
                    num++;
                }else{
                    break;
                }
            }
            array.add(num);
        }
        
        int[] answer = new int[array.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=array.get(i);
        }
        return answer;
    }
}