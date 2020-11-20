package DP;

import java.util.Scanner;

public class RGB거리_1149 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n+1][3];
        int[][] dp=new int[n+1][3];
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        dp[0][0]=dp[0][1]=dp[0][2]=0;

        for (int i = 1; i <=n ; i++) {
            dp[i][0]=Math.min(dp[i-1][1], dp[i-1][2])+arr[i][0];
            dp[i][1]=Math.min(dp[i-1][0], dp[i-1][2])+arr[i][1];
            dp[i][2]=Math.min(dp[i-1][0], dp[i-1][1])+arr[i][2];
        }
       int min=Integer.MAX_VALUE;
        for (int i = 0; i <3 ; i++) {
            if(min>dp[n][i])min=dp[n][i];
        }
        System.out.println(min);
    }
}
