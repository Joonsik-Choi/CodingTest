package Programmers.통과;

import java.util.*;

public class 디스크컨트롤러 {
    public static void main(String[] args) {
        int[][] arr={{0,10},{2,10},{25,10},{25,2}};// {0,10},{4,10},{5,11}, {15,2}    {0,3},{0,1},{4,7}  {0,10},{2,10},{9,10},{15,2}
        System.out.println(solution(arr));
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        int jobsLen= jobs.length;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        } );
        PriorityQueue<Job> priorityQueue=new PriorityQueue<>();
        int second=0;
        int start=0;
        int total=0;
        int i=0;
        Job job = null;
        boolean check=false;
        do{
            while(i<jobsLen && jobs[i][0]==second){
                priorityQueue.add( new Job( jobs[i][0],jobs[i][1] ) );
                i++;
            }
           if(!check && !priorityQueue.isEmpty() ){
               start=second;
               job=priorityQueue.poll();
               check=true;
               System.out.println(second +" 작업시작 " +job.getStartTime());
           }
           if(check){
               if(start+job.getOperationTime()<=second){
                   int t=second-job.getStartTime();
                    total+=t;
                   check=false;
                   System.out.println(second +" 작업 끝 소요 시간 "+ t);
                   continue;
               }
           }
           if(i<jobsLen && priorityQueue.isEmpty() && !check){
                second=jobs[i][0];
           }else{
               second++;
           }
       } while (i<jobsLen || !priorityQueue.isEmpty() || check);
       answer=total/jobsLen;
       return answer;
    }
}

class Job implements Comparable {
    private int startTime;
    private int operationTime;
    public Job(int startTime, int operationTime) {
        this.startTime = startTime;
        this.operationTime=operationTime;
    }
    public int getStartTime() {
        return startTime;
    }
    public int getOperationTime() {
        return operationTime;
    }
    @Override
    public int compareTo(Object o) {
        Job j=(Job)o;
        if(operationTime>j.operationTime)return 1;
        else if(operationTime==j.operationTime)return 0;
        else return -1;
    }
}
