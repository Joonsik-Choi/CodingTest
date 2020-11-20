package Programmers;

public class 보행자천국 {
    static  int MOD = 20170805;
    static  int[] dx;
    static  int[] dy;
    static  int[][] dp;
    public static void main(String[] args) {
        System.out.println(solution(3,6,new int[][]{{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}}));
    }
    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        dp=new int[m][n];
        dx=new int[]{0,-1};
        dy=new int[]{-1,0};
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                dp[i][j]=-1;
            }
        }
        answer=function( cityMap,m-1,n-1, m, n, -1);
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(cityMap[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return answer;
    }
    public static int function(int[][] cityMap, int x, int y, int m, int n, int d){
        if(dp[x][y]!=-1)return dp[x][y];
        if(x==0 && y==0)return 1;
        dp[x][y]=0;
        for (int i = 0; i < 2; i++) {
            int newX=x+dx[i];
            int newY=y+dy[i];

            if(newX>=0 && newY>=0 && newX<m && newY<n && cityMap[newX][newY]!=1){
                if(cityMap[x][y]==0){
                    if(cityMap[newX][newY]==0 ){
                        dp[x][y]+=function(cityMap, newX, newY, m, n, i);
                    }
                    else if(cityMap[newX][newY]==2){
                        dp[x][y]+=function(cityMap, newX, newY, m, n, i);
                    }
                }
               else if(cityMap[x][y]==2) {
                    if(cityMap[newX][newY]==0){
                        if(d==-1 || d==i){
                            dp[x][y]+=function(cityMap, newX, newY, m, n, i);
                        }
                    }
                    if(cityMap[newX][newY]==2){
                        if(d==-1 || d==i){
                            dp[x][y]+=function(cityMap, newX, newY, m, n, i);
                        }
                    }
                }
            }
        }
        return dp[x][y];
    }
}
