package Programmers;

import java.util.*;

public class 프린터 {
    public static void main(String[] args) {
        int[] arr={1,1,9,1,1,1};
        System.out.println(solution(arr,0));
    }
    public static int solution(int[] priorities, int location) {
        Queue<Integer>  que=new LinkedList<>();
        Queue<Integer>  point=new LinkedList<>();
        Stack<Integer> weight=new Stack<>();
        int[] arr=priorities.clone();
        int answer = 0;

        Arrays.sort(arr);
        for(int n : arr){
            weight.push(n);
        }
        int i=0;
        for(int n:priorities){
            que.add(n);
            point.add(i++);
        }
        i=1;
        while(!que.isEmpty()){
            if(que.peek()==weight.peek()){
                que.poll();
                weight.pop();
                int p=point.poll();
                if(p==location){
                    answer=i;
                    break;
                }
                i++;
            }else{
                int n=que.poll();
                que.add(n);
                int p=point.poll();
                point.add(p);
            }
        }
        return answer;
    }
}
