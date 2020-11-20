package Programmers.통과;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
    public  static int solution(int n, int[][] computers) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean[] vistited=new boolean[n];
        for (int i = 0; i <n ; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                if(i==j)continue;
                if(computers[i][j]==1){
                    if(!list.get(i).contains(j)) {
                        list.get(i).add(j);
                        list.get(j).add(i);
                    }
                }
            }
        }

        for (int j = 0; j <n ; j++) {
            if(!vistited[j]){
                answer++;
                q.add(j);
                vistited[j]=true;
                while(!q.isEmpty()){
                    int p=q.poll();
                    for (int i = 0; i <list.get(p).size() ; i++) {
                        if(!vistited[list.get(p).get(i)]){
                            q.add(list.get(p).get(i));
                            vistited[list.get(p).get(i)]=true;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
