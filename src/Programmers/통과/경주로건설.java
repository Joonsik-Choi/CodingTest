package Programmers.통과;

import java.util.LinkedList;
import java.util.Queue;
//{{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
//{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
/*{{0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0}};
                */
public class 경주로건설 {
    public static void main(String[] args) {
        int[][] arr=new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        System.out.println(solution(arr));
    }
    public static int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int boardLen=board.length;
        int x, y;
        x=y=0;
        board[0][0]=1;
        int[][] check=new int[boardLen][boardLen];
        Queue<Point2> q=new LinkedList<>();
        check[x][y]=0;
        q.add(new Point2(x,y, -1,0));
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        while(!q.isEmpty()){
            Point2 p=q.poll();
            x=p.getX();
            y=p.getY();
            if(x==boardLen-1 && y==boardLen-1){
                answer=Math.min(answer,p.cost );
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nX=x+dx[i];
                int nY=y+dy[i];
                if(nX>=0 && nY>=0 && nX<boardLen && nY<boardLen && board[nX][nY]==0){
                        int weight=0;
                        if(p.direction==-1 || p.getDirection()==i) {
                             weight = check[x][y] + 100;
                        }
                        else if(p.getDirection()!=i){
                            weight=check[x][y] + 600;
                        }
                        if(check[nX][nY]==0 || check[nX][nY]>=weight ) {
                            check[nX][nY] = weight;
                            q.add(new Point2(nX, nY, i, weight));
                        }
                }
            }
        }
      /*  for (int i = 0; i < boardLen; i++) {
            for (int j = 0; j < boardLen; j++) {
                System.out.print(check[i][j]+"      ");
            }
            System.out.println();
        }*/
      //  answer=check[boardLen-1][boardLen-1];
        return answer;
    }
}
class Point2{
    int x;
    int y;
    int direction;
    int cost;

    public Point2(int x, int y, int direction, int cost) {
        this.x = x;
        this.y = y;
        this.direction=direction;
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

    public int getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "Point2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}