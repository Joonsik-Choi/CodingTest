package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int[] arr={7,4,5,6};
        System.out.println(solution(2,10,arr));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> que=new LinkedList<>();
        Queue<Integer> going=new LinkedList<>();
        Queue<Integer> time=new LinkedList<>();
        for(Integer n : truck_weights){
            que.add(n);
        }
        int second=0;
        int total=0;
        while(!que.isEmpty() || !going.isEmpty()){
            second++;
           // System.out.println(second);
            if(!going.isEmpty()){
                if(second-time.peek()==bridge_length){
                    // System.out.println("다리 건넘");
                    total-=going.poll();
                    time.poll();
                }
            }
                if(!que.isEmpty() && total+que.peek()<=weight){
                    total+=que.peek();
                    going.add(que.poll());
                    time.add(second);
                  //  System.out.println("다리 건너는중");
                }

        }
        int answer = second;
        return answer;
    }
}
