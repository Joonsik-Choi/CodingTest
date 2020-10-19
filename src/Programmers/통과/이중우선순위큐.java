package Programmers.통과;

import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public static void main(String[] args) {
        int[] arr=solution(new String[]{"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"});
        System.out.println(arr[0]+" "+arr[1]);
    }
    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueueReverse=new PriorityQueue<>(Collections.reverseOrder());
        int size=0;
        for(String s: operations){
            if(s.contains("I")){
                    int n=Integer.parseInt(s.substring(2));
                    priorityQueue.add(n);
                    priorityQueueReverse.add(n);
                    size++;
            }else if(s.equals("D 1")){
                priorityQueueReverse.poll();
                --size;
                System.out.println("D 1 "+ size);
                if(priorityQueueReverse.isEmpty() || size==0) {
                    priorityQueueReverse.clear();
                    priorityQueue.clear();
                }

            }
            else{
                priorityQueue.poll();
                --size;
                System.out.println("D-1 "+ size);
                if(priorityQueue.isEmpty() || size==0){
                    priorityQueueReverse.clear();
                    priorityQueue.clear();
                }
            }
        }
        int max=0;
        int min=0;
        if(!priorityQueue.isEmpty() && !priorityQueueReverse.isEmpty()) {
            max = priorityQueueReverse.poll();
            min = priorityQueue.poll();
        }
        else {

        }
        int[] answer = {max, min};

        return answer;
    }
}
