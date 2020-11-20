package BFS_DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 유기농배추_1012 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        ArrayList<Integer> result=new ArrayList<>();
        Stack<Point3> stack=new Stack<>();
        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};
        for (int o = 0; o <t ; o++) {
            int m=sc.nextInt();
            int n=sc.nextInt();
            int k=sc.nextInt();
            int[][] arr=new int[n][m];
            boolean[][] visited=new boolean[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i],false);
            }
            for (int i = 0; i < k; i++) {
                int c = sc.nextInt();
                int r = sc.nextInt();
                arr[r][c] = 1;
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        stack.push(new Point3(i, j));
                        count++;
                        visited[i][j] = true;
                        while (!stack.isEmpty()) {
                            Point3 p = stack.pop();
                            int r = p.x;
                            int c = p.y;
                            for (int l = 0; l < 4; l++) {
                                int newR = r + dr[l];
                                int newC = c + dc[l];
                                if (newC >= 0 && newR >= 0 && newC < m && newR < n) {
                                    if(arr[newR][newC]==1 && !visited[newR][newC]) {
                                        visited[newR][newC] = true;
                                        stack.push(new Point3(newR, newC));
                                        stack.push(p);
                                    }
                                }

                            }
                        }
                    }
                }
            }
            result.add(count);
        }

        for(int num:result){
            System.out.println(num);
        }
    }
}
class Point3{
    int x;
    int y;
    public Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
