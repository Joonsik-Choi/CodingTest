package Programmers;
public class 정수삼각형 {
    public static void main(String[] args) {
        solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}});
    }
    public static int solution(int[][] triangle) {
        int answer = 0;
        int n=triangle.length;
        int[][] dp=new int[n+1][n+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <i ; j++) {
                if(j==0){
                    dp[i][j]=dp[i-1][0]+triangle[i-1][j];
                }
                else if(j==i-1){
                    dp[i][j]=dp[i-1][j-1]+triangle[i-1][j];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i-1][j];
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            if(max<dp[n][i])max=dp[n][i];
        }
        answer=max;
        System.out.println(max);
        return answer;
    }
}
