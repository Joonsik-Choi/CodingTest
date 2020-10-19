package Programmers.통과;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        int[] arr ={1,2,3,9,10,12};
        System.out.println(solution(arr,7));
    }
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue();
        for(int n:scoville){
            priorityQueue.add(n);
        }
        int i=0;
        while(!priorityQueue.isEmpty() && priorityQueue.peek()<K){
            i++;
            int first= priorityQueue.poll();
            if(priorityQueue.isEmpty())return -1;
            int second=priorityQueue.poll();
            int mix=first+second*2;
            priorityQueue.add( mix );
        }
        int answer = i;
        return answer;
    }
}
