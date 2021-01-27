package Programmers;

import java.util.Arrays;

public class 프렌즈4블록 {
    static char[] codeName={'R','M','A','F','N','T','J','C'};

    public static void main(String[] args) {

    }
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] boardArr=new char[m][n];
        boolean[][] chk=new boolean[m][n];
        for (int i = 0; i <m ; i++) {
            boardArr[i]=board[i].toCharArray();
        }

        int codeLen=codeName.length;
        char[][][] charArr=new char[codeLen][2][2];
        for (int i = 0; i <codeLen ; i++) {
            for (int j = 0; j <2 ; j++) {
                Arrays.fill(charArr[i][j],codeName[i]);
            }
        }

        while(true){
            for (int i = 0; i <codeLen ; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k <n ; k++) {
                        if(check(boardArr,j,k,charArr[i])){
                            fill(chk,j,k);
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) { //블록 내리기
                for (int j = 0; j <m ; j++) {
                    if(chk[i][j]){
                        
                    }
                }
            }



            break;
        }
        return answer;
    }

    public static boolean check(char[][]board, int sI, int sJ, char[][] charArr){
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <2 ; j++) {
                if(charArr[i][j]!=board[sI+i][sJ+j])return false;
            }
        }
        return true;
    }
    public static void fill(boolean[][] check, int SI, int SJ){
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <2 ; j++) {
                check[SI+i][SJ+j]=true;
            }
        }
    }

}
