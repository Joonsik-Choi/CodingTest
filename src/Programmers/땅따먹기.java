package Programmers;

import java.util.Arrays;

public class 땅따먹기 {
    public static void main(String[] args) {
        int[][] arr={{1,2,3,5},{5,6,7,8},{4,3,2,1},{100,9,1,7},{5,9,5,9}};
        solution(arr);
    }
  /*
    1,2,3,5   1,2,3,5
    5,6,7,8   9,10,11,12
    4,3,2,1
*/
    static  int solution(int[][] land) {
        int answer = 0;
        int[][] dp= new int[land.length+1][4];
        for(int i=1;i<=land.length;i++){
            for (int j = 0; j <4 ; j++) {
                int max=Integer.MIN_VALUE;
                for (int k = 0; k <4 ; k++) {
                    if(j!=k) {
                        if(dp[i-1][k]>=max){
                            max=dp[i-1][k];
                        }
                    }
                }
                dp[i][j] =  land[i - 1][j]+max;
            }
        }
        for (int i = 0; i <dp.length ; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        answer=Arrays.stream(dp[land.length]).max().getAsInt();
        System.out.println(answer);
        return answer;
    }
}
