package BruteForceSearch;

import java.util.Scanner;

public class 영화감독숌_1436 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int countN=0;
        int[] num=new int[10001];
        String s;
        for (int i = 0;  countN<10001;i++) {
            s=String.valueOf(i);
            if(s.contains("666")){
                num[countN++]=i;
            }
        }
        System.out.println(num[n-1]);
   /*     for (int i = 0; i < 100; i++) {
            System.out.println(num[i]);
        }*/
    }
}
