package Programmers.통과;

import java.util.ArrayList;

public class 카펫 {
    public static void main(String[] args) {

    }
    public int[] solution(int brown, int yellow) {
        int area=brown+yellow;
        int[] answer = new int[2];

        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i = 2; i <area ; i++) {
            if(area%i==0)arrayList.add(i);
        }
            for(int w: arrayList){
                for(int h: arrayList){
                    if((w-2)*(h-2)==yellow){
                        answer[0]=w;
                        answer[1]=h;
                    }
                }
            }
        return answer;
    }
}
