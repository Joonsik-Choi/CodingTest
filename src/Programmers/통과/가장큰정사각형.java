package Programmers.통과;

public class 가장큰정사각형 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
        System.out.println(solution(new int[][]{{0,0,1,1},{1,1,1,1}}));
    }
    public static int solution(int [][]board)
    {
        int rowLen=board.length, colLen=board[0].length;
        int answer = 0;
        int[][] max=new int[rowLen+1][colLen+1];
        for (int i = 0; i <rowLen ; i++) {
            for (int j = 0; j <colLen ; j++) {
                max[i+1][j+1]=board[i][j];
            }
        }
        for (int i = 1; i <=rowLen ; i++) {
            for (int j = 1; j <=colLen ; j++) {
                if(max[i][j]!=0){
                    max[i][j]=Math.min(Math.min(max[i-1][j-1], max[i-1][j]), max[i][j-1])+1;
                    answer=Math.max(answer, max[i][j]);
                }
            }
        }
        return answer*answer;
    }
}
