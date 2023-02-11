import java.util.*;
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Pair> st = new Stack<>();
        int time=0;
        for(int i=0;i<prices.length;i++){
            time++;
            
            while(!st.isEmpty()){ //스택이 비어있지 않을때까지
                if(prices[st.peek().getX()]>prices[i]){ //stack top이 더 작으면
                    Pair p = st.pop(); //pop 실행
                    answer[p.getX()]=time-p.getY(); //시간 계산해서 넣어주기
                   }else{
                       break;
                   }
                }
                st.push(new Pair(i,time)); //현재 idx 삽입
        }       
        while(!st.isEmpty()){
            Pair p = st.pop();
            answer[p.getX()]=time-p.getY();
        }        
        return answer;
    }
}