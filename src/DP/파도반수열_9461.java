package DP;

import java.util.Scanner;

public class 파도반수열_9461 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] dp=new long[105];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=2;
        for (int i = 0; i < n; i++) {
            int m=sc.nextInt();
            for (int j = 5; j <=m ; j++) {
                if(dp[j]==0) {
                    dp[j]=dp[j-1]+dp[j-5];
                }
            }
            System.out.println(dp[m]);
        }
    }
}
