package BFS_DFS;

import java.util.*;

public class DFS와BFS_1260 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int start=sc.nextInt();
        boolean[] visited=new boolean[n+1];
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for (int i = 0; i <n+1 ; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int s=sc.nextInt();
            int e=sc.nextInt();
            list.get(s).add(e);
            list.get(e).add(s);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        visited[start]=true;
        ArrayList<Integer> bfsList=new ArrayList<>();
        ArrayList<Integer> dfsList=new ArrayList<>();
        dfsList.add(start);
        bfsList.add(start);
        while(!q.isEmpty()){
            int p=q.poll();
            list.get(p).sort((a1,a2)->a1-a2);
            for (int i = 0; i < list.get(p).size(); i++) {
                if(!visited[list.get(p).get(i)]){
                    visited[list.get(p).get(i)]=true;
                    q.add(list.get(p).get(i));
                    bfsList.add(list.get(p).get(i));
                }
            }
        }
        Arrays.fill(visited,false);
        Stack <Integer> stack=new Stack<>();
        stack.push(start);
        visited[start]=true;
        while(!stack.isEmpty()){
            int p=stack.pop();
            list.get(p).sort((a1,a2)->a1-a2);
            for (int i = 0; i < list.get(p).size(); i++) {
                if(!visited[list.get(p).get(i)]){
                    visited[list.get(p).get(i)]=true;
                    dfsList.add(list.get(p).get(i));
                    stack.push(p);
                    stack.push(list.get(p).get(i));
                    break;
                }
            }
        }

        for(Integer integer:dfsList){
            System.out.print(integer+" ");
        }
        System.out.println();

        for(Integer integer:bfsList){
            System.out.print(integer+" ");
        }
    }
}
