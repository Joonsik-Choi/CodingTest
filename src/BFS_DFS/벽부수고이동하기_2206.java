package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 벽부수고이동하기_2206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        int[][] distance=new int[n][m];
        boolean[][] visited=new boolean[n][m];
        int[][] arr=new int[n][m];
        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};
        for (int i = 0; i <n ; i++) {
            String str=br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j]=str.charAt(j)-'0';
            }
        }
        Queue<Point5> q=new LinkedList<>();
        q.add(new Point5(0,0, false));
        distance[0][0]=1;
       // distance[n-1][m-1]=-1;
        Point5 p;
        int newR;
        int newC;
        while(!q.isEmpty()){
            p=q.poll();
            int x=p.x;
            int y=p.y;
            boolean check=p.check;

            for (int i = 0; i <4 ; i++) {
                 newR=x+dr[i];
                 newC=y+dc[i];
                boolean newCheck=check;
                if (newC >= 0 && newR >= 0 && newC < m && newR < n) {
                    p=new Point5(newR, newC, newCheck);
                    if(arr[newR][newC]==0 && !visited[newR][newC]) {
                        q.add(p);
                        distance[newR][newC]=distance[x][y]+1;
                    }
                    else if(!newCheck && arr[newR][newC]==1&& !visited[newR][newC] ) {
                        newCheck=true;
                        q.add(p);
                        distance[newR][newC]=distance[x][y]+1;
                    }
                }
            }
        }
        if(distance[n-1][m-1]==0){
            System.out.println(-1);
        }
        else {
            System.out.println(distance[n - 1][m - 1]);
        }
    }
}
class Point5{
    int x;
    int y;
    boolean check;

    public Point5(int x, int y, boolean check) {
        this.x = x;
        this.y = y;
        this.check = check;
    }
}
