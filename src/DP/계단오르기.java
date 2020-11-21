package DP;

import java.util.Scanner;

public class 계단오르기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr=new int[n+1];
        int[] dp=new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i]=sc.nextInt();
        }
        dp[0]=arr[0];
        dp[1]=arr[1];
        dp[2]=Math.max(dp[1]+arr[2], dp[0]+arr[2]);
        for (int i = 3; i <=n ; i++) {
            dp[i]=Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i]);
        }
        for (int i = 0; i <=n ; i++) {
            System.out.println(dp[i]);
        }
        //System.out.println(dp[n]);
    }
}
