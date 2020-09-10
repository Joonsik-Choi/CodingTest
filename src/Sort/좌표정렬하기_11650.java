package Sort;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class 좌표정렬하기_11650 {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.valueOf(br.readLine());
        Point[] points=new Point[n];
        String s;
        String[] array;
        int x, y;
        for (int i = 0; i <n ; i++) {
               s=br.readLine();
            array=s.split(" ");
           x=Integer.parseInt(array[0]);
           y=Integer.parseInt(array[1]);
           points[i]=new Point(x,y);
        }
        Arrays.sort(points);

        for (int i = 0; i < n; i++) {
            System.out.println(points[i]);
        }
    }
}

 class Point implements Comparable{
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Object o) {
        Point p=(Point)o;
        if(this.x>p.x){
            return 1;
        }else if(this.x==p.x){
            if(this.y>p.y)return 1;
            else if(this.y==p.y)return 0;
            else return -1;
        }
        else
            return -1;
    }
    public String toString(){
        return x+" "+y;
    }
}
