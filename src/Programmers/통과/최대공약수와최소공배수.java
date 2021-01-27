package Programmers.통과;

import java.util.HashSet;
import java.util.Set;

public class 최대공약수와최소공배수 {
    public static void main(String[] args) {
        Set<Integer> set=new HashSet();
        System.out.println((char)('b'+('A'-'a')));
    }
    public int[] solution(int n, int m) {
        int[] answer = {};
        return answer;
    }
    public int gcd1(int a, int b){
        int temp=a;
        if(b>a){
            a=b;
            b=temp;
        }
        while(b>0){
            temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
    public int gcd2(int a, int b){
       if(b==0)return a;
       else return gcd2(b,a%b);
    }
    public int lcd(int a, int b){
        int temp=a;
        if(b>a){
            a=b;
            b=temp;
        }
        return a*b/gcd1(a,b);
    }
}
