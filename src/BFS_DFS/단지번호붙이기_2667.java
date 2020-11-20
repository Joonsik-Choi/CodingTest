package BFS_DFS;
import java.util.*;
public class 단지번호붙이기_2667 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[][] arr=new int [n][n];
        boolean[][] check=new boolean[n][n];
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        ArrayList<Integer> arrayList=new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            String s=sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j]=s.charAt(j)-'0';
            }
        }
    /*    System.out.println();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }*/



        Stack<Point> stack=new Stack<>();
        int count=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(!check[i][j] && arr[i][j]!=0){
                    count++;
                    int total=1;
                    check[i][j]=true;
                    stack.push(new Point(i,j));
                    while(!stack.empty()){
                        Point p=stack.pop();
                        for (int k = 0; k <4 ; k++) {
                            int newX=p.x+dx[k];
                            int newY=p.y+dy[k];
                            if(newX>=0 && newY>=0 && newX<n && newY<n ){
                               if(!check[newX][newY] && arr[newX][newY]==1){
                                total++;
                                check[newX][newY]=true;
                                stack.push(p);
                                stack.push(new Point(newX, newY));
                               }
                            }
                        }

                    }
                    arrayList.add(total);
                }
            }
        }//for문 끝
        System.out.println(count);
        Collections.sort(arrayList);
        arrayList.stream().forEach(s-> System.out.println(s));
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}