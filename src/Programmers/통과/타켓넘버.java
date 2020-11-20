package Programmers.통과;

import java.util.Arrays;

public class 타켓넘버 {
    static int count=0;
    public static void main(String[] args) {
        int[] arr={1,1,1,1,1};
        System.out.println( solution(arr, 3));
    }
        public static int solution(int[] numbers, int target) {
            function(numbers,target,0);
            int answer = count;
            return answer;
        }
        public static void  function(int[] numbers, int target , int i){
            int numLen=numbers.length;
        if(i<numLen) {
            int[] newNum = Arrays.copyOf(numbers, numLen);
            for (int j = 0; j < 2; j++) {
                newNum[i]*=(j==0)?1:-1;
                function(newNum,target,i+1);
            }
        }
        else if(i==numLen){
            if(Arrays.stream(numbers).sum()==target){
                count++;
            }
        }
    }
}
