package Programmers.통과;

public class 등굣길 {
    public static void main(String[] args) {
        solution(4,3,new int[][]{{2,2}});
    }
    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int MOD=1_000_000_007;
        int[][] arr=new int[n][m];
        long[][] rightArr=new long[n+1][m+1];
        long[][] downArr=new long[n+1][m+1];
        rightArr[1][1]=downArr[1][1]=1;
        for (int i = 0; i <puddles.length ; i++) {
            int x=puddles[i][1];
            int y=puddles[i][0];
            arr[x-1][y-1]=1;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if(arr[i-1][j-1]==1){
                    rightArr[i][j]=0;
                    downArr[i][j]=0;
                }
                else if(arr[i-1][j-1]==0){
                    rightArr[i][j]=(rightArr[i][j]+rightArr[i][j-1]+downArr[i-1][j])%MOD;
                    downArr[i][j]=(downArr[i][j]+rightArr[i][j-1]+downArr[i-1][j])%MOD;
                }
            }
        }

        answer= (int) ((rightArr[n][m-1]+downArr[n-1][m])%MOD);
        System.out.println(answer);
        return answer;
    }
}
