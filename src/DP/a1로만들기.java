package DP;

import java.util.Scanner;

public class a1로만들기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dp=new int[n+4];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;

        for (int i = 3; i <=n; i++) {
            if(i%3==0 && i %2==0){
                dp[i]=Math.min(Math.min(dp[i/3],dp[i/2]), dp[i-1])+1;
            }
            else if(i%3==0){
                dp[i]=Math.min(dp[i/3], dp[i-1])+1;
            }
            else if(i%2==0){
                dp[i]=Math.min(dp[i/2], dp[i-1])+1;
            }
            else
                dp[i]=dp[i-1]+1;
        }

        System.out.println(dp[n]);
    }
}
