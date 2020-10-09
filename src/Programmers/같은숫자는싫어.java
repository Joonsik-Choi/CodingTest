package Programmers;

import java.util.ArrayList;
import java.util.Stack;

public class 같은숫자는싫어 {
    public static void main(String[] args) {

    }
    public int[] solution(int []arr) {
        ArrayList<Integer> integerArrayList=new ArrayList<>();
        int temp=-1;
        for(int n:arr){
            if(temp!=n){
                integerArrayList.add( n );
                temp=n;
            }
        }
        int[] answer = new int[integerArrayList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i]=integerArrayList.get( i );
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
