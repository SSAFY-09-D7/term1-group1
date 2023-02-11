import java.util.*;
import java.lang.*;
class Pair{
    private int x;
    private int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Pair> Q = new LinkedList<>();
        
        int nowWeight=0; //다리 위의 무게
        int time=1; //시간
        int idx=0; //truck 인덱스 종료조건 확인 때 사용
       
        while(true){
            if(Q.size()!=bridge_length){ //큐가 꽉 차있지 않으면 추가
                if(idx<truck_weights.length){ //인덱스 범위 내에 있고,
                    if(weight>=nowWeight+truck_weights[idx] ){//버틸 수 있는 무게면추가
                        Q.offer(new Pair(idx,truck_weights[idx]));
                        nowWeight+=truck_weights[idx];
                        idx++;
                    }else{ //버틸 수 없으면 0 넣어줌 
                        Q.offer(new Pair(-1,0));
                    }
                }
                //인덱스 범위를 벗어남 (모든 차량이 다리 위에 있는데,종료되지 않으므로 0추가)
                else{
                    Q.offer(new Pair(-1,0));
                }     
            }
        
            if(Q.size()==bridge_length){ //큐가 꽉참. 차량이 다리를 완전히 건넘.
                Pair p = Q.poll();
                int outidx=p.getX(); //차량 인덱스
                int out = p.getY(); // 차량 무게
                if(out==0){// 무게가 0이면 계속 진행
                    time++;
                    continue;
                }
                nowWeight-=out; //다리위의 무게에서 빼줌
                if(outidx == truck_weights.length-1){ //종료조건. 
                    time++;
                    break;
                }
            }
            time++;
        }
        return time;
    }
}