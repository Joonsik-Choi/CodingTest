package Programmers.통과;

import java.util.Stack;

public class 다음큰숫자 {
    public static void main(String[] args) {
        System.out.println(solution(78));
    }
    public static int solution(int n) {
        int oneCnt=getCount(n);
        int max=n<<1;
        while(n<max){
            if(oneCnt==getCount(++n)){
                return n;
            }
        }
        return max;
    }
    public static  int getCount(int n){
        int count=0;
        while(n>0){
            if(n%2==1){
                count++;
            }
            n=n/2;
        }
        return count;
    }
}
