package Programmers.통과;

import java.util.*;

public class 소수구하기 {
    public static void main(String[] args) {
        int n=10;
        int[] arr=new int[n+1];
        for (int i = 2; i <=n ; i++) {
            arr[i]=i;
        }
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(arr[i]==0)continue;
            for (int j = i+i; j <=n ; j+=i) {
                arr[j]=0;
            }
        }
        for (int i = 0; i <=n ; i++) {
            if(arr[i]!=0)
                System.out.println(arr[i]);
        }
    }
}
