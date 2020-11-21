package Programmers;

import java.util.*;

public class N으로표현 {
    public static void main(String[] args) {
        solution(5,31168);
    }
    public static int solution(int N, int number) {
        int answer = 0;
        ArrayList<Set<Integer>> sets=new ArrayList<>();
        for (int i = 0; i <9 ; i++) {
            sets.add(new HashSet<>());
        }
        char[] ch={'+','-','*','/'};
        sets.get(1).add(N);
        sets.get(2).addAll(Arrays.asList(new Integer[]{N*11, N/N, N*N, N+N}));
        int[] arr={0,N, N*11,N*111,N*1111,N*11111,N*111111,N*1111111,N*11111111};
        int idx=-1;
        d:
        for (int i=3; i < 9; i++) {
            if(arr[i]<=32000)
                sets.get(i).add(arr[i]);
            for (int j = 1; j <i ; j++) {
                    for(int a: sets.get(j)){
                        for(int b: sets.get(i-j)){
                            for (int l = 0; l <4 ; l++) {
                                int num=function(a,ch[l],b);
                                if(num==number){
                                    idx=i;
                                    break d;
                                }
                                sets.get(i).add(num);
                            }
                        }
                    }
            }
        }
        for (int i = 1; i <=2 ; i++) {
            for(int n:sets.get(i)){
                if(number==n)idx=i;
            }
        }
        answer=idx;
        System.out.println(answer);
        return answer;
    }
    public static Integer function(int a, char c, int b){
        Integer num=0;
        switch (c){
            case '+': num=a+b;
                break;
            case '-': num=a-b;
                break;
            case '*': num=a*b;
                break;
            case '/': num= b!=0?a/b:a;
                break;
        }
        if(num>32000)return 0;
        if(num<0)return 0;
        return num;
    }
}
