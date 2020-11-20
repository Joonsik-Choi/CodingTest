package Programmers.통과;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 가장먼노드_list {
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) {
        System.out.println(solution(6, new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }
    public static ArrayList<Integer> getNode(int index){
        return list.get(index);
    }
    public static void insertBridge(int edge1, int edge2){
        list.get(edge1).add(edge2);
        list.get(edge2).add(edge1);
    }
    public static void printGraph(){
        for (int i = 1; i <list.size() ; i++) {
            System.out.println(i+"리스트");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j));
            }
            System.out.println();
        }
    }
    static boolean[] visited;
    public static int solution(int n, int[][] edge) {
        list=new ArrayList<ArrayList<Integer>>();
        int max=Integer.MIN_VALUE;
        int[] level=new int[n+1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }
        Queue<Integer> q=new LinkedList<>();
        visited=new boolean[n+1];
        int answer = 0;
        for (int i = 0; i < edge.length; i++) {
            insertBridge(edge[i][0],edge[i][1]);
        }
        visited[1]=true;
        level[1]=0;
        q.add(1);
        while(!q.isEmpty()){
            int p=q.poll();
            for (int i = 0; i < list.get(p).size(); i++) {
                if(visited[list.get(p).get(i)]==false){
                    int idx=list.get(p).get(i);
                    visited[idx]=true;
                    q.add(idx);
                    level[idx]=level[p]+1;
                    if(max<level[idx])max=level[idx];
                }
            }
        }
        for (int i = 0; i <level.length ; i++) {
            if(max==level[i])answer++;
        }
      return answer;
    }
}
