package Programmers.통과;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }
    static int[][] arr;
    static boolean[] visited;
    public static int solution(int n, int[][] edge) {
        Queue<Integer> q=new LinkedList<>();
        arr=new int[n+1][n+1];
        visited=new boolean[n+1];
        int answer = 0;
        for (int i = 0; i <edge.length ; i++) {
            arr[edge[i][0]][edge[i][1]]=1;
            arr[edge[i][1]][edge[i][0]]=1;
        }
        q.add(1);
        visited[1]=true;
        int[] distance=new int[n+1];
        distance[1]=0;
        int max=Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int p=q.poll();
            for (int i = 1; i <=n ; i++) {
                if(arr[p][i]==1 && visited[i]==false){
                    visited[i]=true;
                    distance[i]=distance[p]+1;
                    q.add(i);
                    if(distance[i]>max)max=distance[i];
                }
            }
        }
        for (int i = 1; i <distance.length ; i++) {
            if(distance[i]==max)answer++;
        }
        return answer;
    }
}
