package Programmers.통과;
import java.util.PriorityQueue;
public class 섬연결하기 {
    static int N;//정점의 개수
    static int E;//간선의 개수
    static int result; //결과
    static boolean[] visit; //방문
    static PriorityQueue<Mst> pq;
    static int[] parent;
    public static void main(String[] args) {
        System.out.println(solution(4,new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1}, {2,3,8}}));
    }
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        N=n;
        E=costs.length;
        parent=new int[N+1];
        visit=new boolean[N+1];
        result=0;
        pq=new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            pq.add(new Mst(costs[i][0],costs[i][1],costs[i][2]));
        }
        for (int i = 1; i <=N ; i++) {
            parent[i]=i;
        }

        for (int i = 0; i <E ; i++) {
            Mst m=pq.poll();
            int start=m.s;
            int end=m.e;
            int a=find(start);
            int b=find(end);
            if(a==b) continue;
            union(start, end);
            result+=m.v;
        }
        answer=result;
        return answer;
    }
    public static int find(int a){
        if(a==parent[a])return a;
        parent[a]=find(parent[a]);
        return parent[a];
    }
    public static void union(int s, int e){
        int sRoot=find(s);
        int eRoot=find(e);
        if(sRoot!=eRoot){
            parent[sRoot]=e;
        }
    }
}
class Mst implements Comparable{
    int s;
    int e;
    int v;
    public Mst(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(Object o) {
        Mst m=(Mst)o;
        return this.v-m.v;
    }
}
