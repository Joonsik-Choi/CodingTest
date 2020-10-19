package Programmers.통과;

import java.util.Arrays;

public class 가장큰수 {
    public static void main(String[] args) {

    }
    public static String solution(int[] numbers) {
        String answer = "";
        Number[] nums=new Number[numbers.length];
        for (int i = 0; i <numbers.length ; i++) {
            nums[i]=new Number(numbers[i]);
        }
        Arrays.sort(nums);
        StringBuffer buffer=new StringBuffer();
        for (int i = 0; i <numbers.length ; i++) {
            buffer.append(nums[i].getN());
        }
        answer=buffer.toString();
        return answer;

    }
}
class Number implements Comparable{
    private int n;
    private double m;
    public Number(int n){
        this.n=n;
        m=n;
        while(m/10>=1)m/=10;

    }
    @Override
    public int compareTo(Object o) {
        Number number=(Number)o;
        if(n==number.n){
            return 0;
        }
        else if(m==number.m){
            return (n<=number.n)?-1:1;
        }
        else if(m>number.m){
            if((int)m==(int)number.m){
                return (m> number.m*1.111)?-1:1;
            }else{
                return -1;
            }
        }
        else{
            return 1;
        }
    }
    public int getN() {
        return n;
    }
}