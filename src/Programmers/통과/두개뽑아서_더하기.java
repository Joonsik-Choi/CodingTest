package Programmers.통과;

import java.util.ArrayList;
import java.util.Arrays;

public class 두개뽑아서_더하기 {
    public static void main(String[] args) {
        solution(new int[]{1,4});
    }


    public static int[] solution(int[] numbers) {
        int numbersLen=numbers.length;
        ArrayList<Integer> answerList=new ArrayList<>();
        int result=0;
        for(int i=0;i<numbersLen;i++){
            for(int j=0;j<numbersLen;j++){
                if(i==j)continue;
                result=numbers[i]+numbers[j];
                if(!answerList.contains( (Integer)result )){
                    answerList.add( result );
                }
            }
        }

        int[] answer =new int[answerList.size()];
        int size=0;

        for(Integer n : answerList){
            answer[size++]=n;
        }
        Arrays.sort( answer );
        return answer;
    }
}