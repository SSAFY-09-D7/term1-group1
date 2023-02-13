import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
 
public class Solution {
 
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            ArrayList<Integer> array = new ArrayList<>();
            for (int i = 0; i < s.length; i++) {
                array.add(Integer.parseInt(s[i]));
            }
             
            int M = Integer.parseInt(br.readLine());
            s = br.readLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                if(s[i].charAt(0)=='I') {
                    int k= Integer.parseInt(s[i+1]);
                    //System.out.println(k);
                    int len=Integer.parseInt(s[i+2]);
                    for(int j=k;j<k+len;j++) { // j 1~6  i+3 i+7
                        array.add(j, Integer.parseInt(s[i+3+j-k]));
                    }
                    i+=(len+2);
                }
            }
            System.out.print("#"+t+" ");
            for(int i=0;i<10;i++) {
                if(i>=array.size()) {
                    return;
                }
                System.out.print(array.get(i)+" ");
            }
            System.out.println();
             
             
        }
             
    }
}