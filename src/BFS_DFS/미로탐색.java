package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        boolean[][] visited=new boolean[n][m];
        int[][] distance=new int[n][m];
        int[][] arr=new int[n][m];
        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};

        for (int i = 0; i <n ; i++) {
            String str=br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j]=str.charAt(j)-'0';
            }
        }
        Queue<Point3> q=new LinkedList<>();
        q.add(new Point3(0,0));
        visited[0][0]=true;
       distance[0][0]=1;
        while(!q.isEmpty()){
            Point3 p=q.poll();
            int x=p.x;
            int y=p.y;

            for (int i = 0; i <4 ; i++) {
                int newR=x+dr[i];
                int newC=y+dc[i];
                if (newC >= 0 && newR >= 0 && newC < m && newR < n) {
                    if(arr[newR][newC]==1 && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        q.add(new Point3(newR, newC));
                        distance[newR][newC]=distance[x][y]+1;

                    }
                }

            }
        }
        System.out.println(distance[n-1][m-1]);
    }
}
