package Programmers;


import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    public int solution(int[][] board) {
        int answer = 0;
        int boardLen=board.length;
        boolean[][] check=new boolean[boardLen][boardLen];
        ArrayList<Point1> points=new ArrayList<>();
        Stack<Point1> pointStack=new Stack<>();
        pointStack.push(new Point1(0,0));
        int x=0;
        int y=0;
        int[] dX={0,1,0,-1};
        int[] dY={1,0,-1,0};
        pointStack.push(new Point1(x,y));
        while(!pointStack.empty()) {
            Point1 p=pointStack.pop();
            x=p.getX();
            y=p.getY();

            for (int i = 0; i < 4; i++) {
                int nX =x+ dX[i];
                int nY=y + dY[i];
                if(nX>=0 &&nY>0 && nX<boardLen && nY<boardLen){
                    if(board[nX][nY]==0 && check[nX][nY]==false){
                        check[nX][nY]=true;
                        pointStack.push(p);
                        pointStack.push(new Point1(nX, nY));
                    }
                }
            }
        }
        pointStack.pop();

        return answer;
    }
}
 class Point1{
    int x;
    int y;

    public Point1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
