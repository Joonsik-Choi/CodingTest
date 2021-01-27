package Programmers.통과;

public class 보행자천국 {
    public static void main(String[] args) {
        System.out.println(solution(3,6,new int[][]{{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}}));
    }
    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int MOD = 20170805;
        int[][] rightArr=new int[m+1][n+1];
        int[][] downArr=new int[m+1][n+1];
        rightArr[1][1]=downArr[1][1]=1;
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(cityMap[i-1][j-1]==0){
                    rightArr[i][j]=(rightArr[i][j]+rightArr[i][j-1]+downArr[i-1][j])%MOD;
                    downArr[i][j]=(downArr[i][j]+rightArr[i][j-1]+downArr[i-1][j])%MOD;
                }
                else if(cityMap[i-1][j-1]==1){
                    rightArr[i][j]=0;
                    downArr[i][j]=0;
                }
                else{
                    rightArr[i][j]=rightArr[i][j-1];
                    downArr[i][j]=downArr[i-1][j];
                }
            }
        }
        answer=(rightArr[m][n-1]+downArr[m-1][n])%MOD;
        return answer;
    }

}
