package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 지형이동 {
    public static void main(String[] args) {

    }
    public static int solution(int[][] land, int height) {
        int answer = 0;
        int n=land.length;
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int[][] check=new int[n][n];
        Queue<Point4> q = new LinkedList<>();
        int min=Integer.MAX_VALUE;
        Point4 minPoint = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                min=Math.min(min, land[i][j]);
                if(min>land[i][j])
                minPoint=new Point4(i,j,0);
            }
        }
        q.add(minPoint);
        while(!q.isEmpty()){
            Point4 p=q.poll();
            for (int i = 0; i <4; i++) {
                int newX=p.x+dx[i];
                int newY=p.y+dy[i];
                if(newX>=0 && newY>=0 && newX<0 && newY<0){
                    if(check[newX][newY]==0 && Math.abs(land[newX][newY]-land[p.x][p.y])<=height){

                    }
                    else if(Math.abs(land[newX][newY]-land[p.x][p.y])>height){

                    }
                }

            }
        }
        return answer;
    }
}
class Point4{
    int x;
    int y;
    int cost;

    public Point4(int x, int y, int cost) {
        this.x = x;
        this.y = y;

        this.cost=cost;
    }

    public int getCost() {
        return cost;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
