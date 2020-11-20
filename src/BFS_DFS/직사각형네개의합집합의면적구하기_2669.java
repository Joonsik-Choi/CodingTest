package BFS_DFS;

import java.util.Scanner;

public class 직사각형네개의합집합의면적구하기_2669 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] arr=new int[101][101];
        for (int i = 0; i < 4; i++) {
            String[] strs=sc.nextLine().split(" ");
            int x1,x2,y1,y2;
            x1= Integer.parseInt(strs[0]);
            y1= Integer.parseInt(strs[1]);
            x2= Integer.parseInt(strs[2]);
            y2= Integer.parseInt(strs[3]);
            check(arr, x1,y1,x2,y2);
        }
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]!=0)count++;
            }
        }
        System.out.println(count);
    }
    public  static void check(int[][] arr, int x1,int y1,int x2,int y2){
        for (int i = 0; i < y2-y1; i++) {
            for (int j = 0; j < x2-x1; j++) {
                arr[y1+i][x1+j]++;
            }
        }
    }
}
