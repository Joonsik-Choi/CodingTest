package DP;

import java.util.Scanner;
public class 타일장식물_13301 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] dp=new long[82];
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        long width=2*(2*dp[n]+dp[n-1]);
        System.out.println(width);

    }
}
