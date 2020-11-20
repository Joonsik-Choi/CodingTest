package BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스_2606 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();

        int n=sc.nextInt();
        int m=sc.nextInt();
        boolean[] visited=new boolean[n+1];
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i <n+1 ; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int start=sc.nextInt();
            int end= sc.nextInt();
            list.get(start).add(end);
            list.get(end).add(start);
        }
        q.add(1);
        visited[1]=false;

        while(!q.isEmpty()){
            int p=q.poll();
            for (int i = 0; i < list.get(p).size() ; i++) {
                if(!visited[list.get(p).get(i)]){
                    visited[list.get(p).get(i)]=true;
                    q.add(list.get(p).get(i));
                }
            }
        }
        int count=0;
        for (int i = 1; i < visited.length; i++) {
            if(visited[i])count++;
            //System.out.println(visited[i]);
        }
        System.out.println(count-1);
    }
}
