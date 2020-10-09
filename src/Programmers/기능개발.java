package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public static void main(String[] args) {

    }
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que= new LinkedList<>();
        for(int prgresss : progresses){
            que.add(prgresss);
        }
        int second=1;
        int i=0;
        ArrayList<Integer> arrayList=new ArrayList<>();
        while (!que.isEmpty()){
            int count=0;
                while (!que.isEmpty() && que.peek()+second*speeds[i]>=100){
                    que.poll();
                    i++;
                    count++;
                }
                if(count!=0)arrayList.add(count);
                second++;
        }
        int[] answer = new int[arrayList.size()];
        i=0;
        for(int n: arrayList){
            answer[i++]=n;
        }
        return answer;
    }
}
