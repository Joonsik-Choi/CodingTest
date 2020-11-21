package DP;

import java.util.Scanner;
public class 쉬운계단수 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long mod=1000000000;
        long[][] dp=new long[n+1][11];
        for (int i = 0; i < 10; i++) {
            dp[1][i]=1;
        }
        for (int i = 2; i <=n ; i++) {
            dp[i][0]=dp[i-1][1];
            for (int j = 1; j <10 ; j++) {
                dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%mod;
            }
        }
        long sum=0;
        for (int i = 0; i <10 ; i++) {
            sum=(sum+dp[n][i])%mod;
        }
        System.out.println(sum);
    }
}
