package Sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;

public class 수정렬하기_2750 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] num=new int[n];
        int temp;
        for (int i = 0; i < n; i++) {
            num[i]=sc.nextInt();
        }
        for (int i = 0; i <n-1 ; i++) {
            for (int j = n-1; j >i; j--) {
                if(num[i]>num[j]){
                    temp=num[j];
                    num[j]=num[i];
                    num[i]=temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(num[i]);
        }
    }
}
