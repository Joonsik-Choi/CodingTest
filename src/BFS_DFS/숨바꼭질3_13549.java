package BFS_DFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질3_13549 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        Queue<Integer> q=new LinkedList<>();
        int[] visited=new int[100001];
        q.add(n);
        while(!q.isEmpty()){
            int p=q.poll();
            for (int i = 0; i < 3; i++) {
                int newP=p;
                if(i==0){
                    newP=newP+1;
                }
                else if(i==1){
                    newP=newP-1;
                }
                else if(i==2){
                    newP=newP*2;
                }
                if(newP>=0 && newP<100001 && newP!=n){
                    int weight=visited[p];
                    if(i!=2)weight+=1;
                    if(visited[newP]==0 || visited[newP]>=weight){
                        if(visited[newP]==weight && i==2)continue;
                        q.add(newP);
                        visited[newP] = weight;
                    }
                }
            }
        }
        System.out.println(visited[k]);
    }
}