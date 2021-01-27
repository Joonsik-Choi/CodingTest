package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 줄서는방법 {
    public static void main(String[] args) {
        solution(10, 0);
    }
    public static int[] solution(int n, long k) {
        int[] answer = {};
        long[] arr=new long[n+1];
        int lastIdx=n;
        ArrayList<Long> longArrayList=new ArrayList<>();
        arr[0]=1;
        for (int i = 1; i <=n ; i++) {
            arr[i]=i*arr[i-1];
            if(arr[i]>=k){
                lastIdx=i;
                break;
            }
        }
        long num=k;


        Arrays.stream(arr).forEach(System.out::println);
        return answer;
    }
}
