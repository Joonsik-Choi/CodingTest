package BFS_DFS;

import java.util.*;

public class 내리막길_1520 {
    static int[] dx={0,1,0,-1}; //
    static int[] dy={1,0,-1,0}; // 상하좌우 입력 용
    static int[][] visited;
    static int[][] arr;
    static int m;
    static int n;
    static int total;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        m=sc.nextInt();//세로
        n=sc.nextInt();//가로
        arr=new int[m][n];
        visited=new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                arr[i][j]=sc.nextInt();
                visited[i][j]=-1;
            }
        }
        total=function(m-1,n-1);
        System.out.println(total);
    }
    public static int function(int x, int y) {
        if (visited[x][y] != -1) return visited[x][y];
        if(x==0 && y==0)return 1;
        visited[x][y]=0;
        for (int i = 0; i < 4; i++) {
            int newX=x+dx[i];
            int newY=y+dy[i];
            if(newX>=0 && newY>=0 && newX<m && newY<n) {
                if (arr[newX][newY] > arr[x][y]) {
                    visited[x][y] += function(newX, newY);
                }
            }
        }
        return visited[x][y];
    }
    }
