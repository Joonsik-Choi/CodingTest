package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[1]);
        int m=Integer.parseInt(s[0]);
        boolean[][] visited=new boolean[n][m];
        int[][] distance=new int[n][m];
        int[][] arr=new int[n][m];
        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};
        Queue<Point3> q=new LinkedList<>();

        int r = 0, c=0;
        for (int i = 0; i <n ; i++) {
            String[] str=br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j]=Integer.parseInt(str[j]);
                if(arr[i][j]==1){
                    q.add(new Point3(i, j));
                    visited[i][j]=true;
                    distance[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            Point3 p=q.poll();
            int x=p.x;
            int y=p.y;

            for (int i = 0; i <4 ; i++) {
                int newR=x+dr[i];
                int newC=y+dc[i];
                if (newC >= 0 && newR >= 0 && newC < m && newR < n) {
                    if(arr[newR][newC]!=-1 && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        q.add(new Point3(newR, newC));
                        distance[newR][newC]=distance[x][y]+1;

                    }
                }

            }
        }
        boolean check=false;
        int max=0;
        point:
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
               max=Math.max(max, distance[i][j]);
                if(arr[i][j]==1)continue ;
                if(distance[i][j]==0 && arr[i][j]!=-1){
                    check=true;
                    break point;
                }
              //  System.out.print(distance[i][j]+" ");
            }
          //  System.out.println();
        }
        if(check) System.out.println(-1);
        else System.out.println(max);
    }
}
