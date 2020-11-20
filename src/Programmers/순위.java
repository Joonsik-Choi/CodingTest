package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 순위 {
    static int[][] arr;
    public static void main(String[] args) {
        System.out.println(solution(5,new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}})) ;
    }
    public static int solution(int n, int[][] results) {
        int answer = 0;
        arr=new int[n+1][n+1];
        Queue<Integer> q=new LinkedList<>();
        Arrays.sort(results, (a1, a2)-> a1[0]-a2[0]);
        for (int i = 0; i < results.length; i++) {
            arr[results[i][0]][results[i][1]]=1;
        }

        for (int i = 1; i <arr.length ; i++) {
            for (int j = 1; j <arr.length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        return answer;
    }
}

