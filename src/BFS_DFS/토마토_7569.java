package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 토마토_7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[1]);
        int m=Integer.parseInt(s[0]);
        int h=Integer.parseInt(s[2]);
        boolean[][][] visited=new boolean[h][n][m];
        int[][][] distance=new int[h][n][m];
        int[][][] arr=new int[h][n][m];
        int[] dr={0,0,0,1,0,-1};
        int[] dc={0,0,1,0,-1,0};
        int[] dh={1,-1,0,0,0,0};
        Queue<Point4> q=new LinkedList<>();

        int r = 0, c=0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i <n ; i++) {
                String[] str=br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    arr[k][i][j]=Integer.parseInt(str[j]);
                    if(arr[k][i][j]==1){
                        q.add(new Point4(i, j, k));
                        visited[k][i][j]=true;
                        distance[k][i][j]=0;
                    }
                }
            }
        }

        while(!q.isEmpty()){
            Point4 p=q.poll();
            int x=p.x;
            int y=p.y;
            int z=p.z;

            for (int i = 0; i <6 ; i++) {
                int newR=x+dr[i];
                int newC=y+dc[i];
                int newH=z+dh[i];
                if (newC >= 0 && newR >= 0 &&  newH>=0 &&newC < m && newR < n && newH<h ) {
                    if(arr[newH][newR][newC]!=-1 && !visited[newH][newR][newC]) {
                        visited[newH][newR][newC] = true;
                        q.add(new Point4(newR, newC, newH));
                        distance[newH][newR][newC]=distance[z][x][y]+1;
                    }
                }
            }
        }
        boolean check=false;
        int max=0;
        for (int k = 0; k <h; k++) {
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <m ; j++) {
                    max=Math.max(max, distance[k][i][j]);
                    if(arr[k][i][j]==1){
                     //   System.out.print("s ");
                        continue;
                    }
                    else{
                    //    System.out.print(distance[k][i][j]+" ");
                    }
                    if(distance[k][i][j]==0 && arr[k][i][j]!=-1){
                        check=true;
                    }
                }
              //  System.out.println();
            }
        //    System.out.println();
        }

        if(check) System.out.println(-1);
        else System.out.println(max);
    }
}
class Point4{
    int x;
    int y;
    int z;

    public Point4(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}