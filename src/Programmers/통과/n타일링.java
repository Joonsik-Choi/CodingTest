package Programmers.통과;

public class n타일링 {
    public static void main(String[] args) {
        solution(9);
    }
    public static int solution(int n) {
        int mod=1_000_000_007;
        int[] dp=new int[n+6];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        dp[4]=5;
        dp[5]=8;
        for (int i = 6; i <=n ; i++) {
            dp[i]=(dp[i-1]+dp[i-2])%mod;
        }
        int answer = dp[n];
        return answer;
    }
}

