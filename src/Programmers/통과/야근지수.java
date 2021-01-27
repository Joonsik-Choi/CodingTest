package Programmers.통과;

import java.util.Arrays;

public class 야근지수 {
    public static void main(String[] args) {
        solution1(1400,new int[]{159,218,114,214,321,451,11,25,59,14,54,428,559});
    }
    public static long solution1(int n, int[] works) {
        long answer=0;
        Arrays.sort(works);
        int sum=Arrays.stream(works).sum();
        System.out.println(sum);
        int[] newArr=new int[works.length];
        int[] sortedWorks=new int[works.length];
        for (int i = 0; i < works.length; i++) {
            sortedWorks[i]=works[works.length-i-1];
        }
        if(sum<=n)return 0;
        int gap=0;
        int time=n;
        int i=0;
        int idx=0;
        for (i = 1; i <newArr.length; i++) {
            newArr[i] = sortedWorks[i-1] - sortedWorks[i];
            int newGap = gap + (newArr[i] * i);
            if (newGap <= time) {
                idx=i;
                gap = newGap;
                continue;
            }
            break;
        }
        time-=gap;
        System.out.println(gap);
        for (int j = 0; j <idx ; j++) {
            sortedWorks[j]=sortedWorks[idx];
        }
        Arrays.stream(sortedWorks).forEach(s-> System.out.print(s+" "));
        System.out.println();
        int div=time/(idx+1);
        for (int j = 0; j <=idx ;j++) {
           sortedWorks[j]-=div;
           time-=div;
        }
        System.out.println(time);
        Arrays.stream(sortedWorks).forEach(s-> System.out.print(s+" "));
        System.out.println();
        if(time!=0){
            for (int j = 0; j <=idx ;j++) {
                sortedWorks[j]--;
                time--;
                if(time<=0)break;
            }
        }
        System.out.println(Arrays.stream(sortedWorks).sum());
        sum-=Arrays.stream(sortedWorks).sum();
        System.out.println(sum);
        for ( i = 0; i < sortedWorks.length; i++) {
                answer += (sortedWorks[i] * sortedWorks[i]);
            }
        System.out.println(answer);
            return answer;
    }

    public static long solution(int n, int[] works) {
        long answer = 0;
        int time=n;
        Arrays.sort(works);
        int i=0;
        while(time>0){
                for (i = works.length-2; i >=0 && works[i]>works[i+1] ; i--) {
                    swap(works,i,i+1);
                 }
                if(works[works.length-1]==0)return 0;
                if(works[works.length-1]!=works[works.length-2] && works[works.length-1]-works[works.length-2]<=time){
                    int gap=works[works.length-1]-works[works.length-2];
                    works[works.length-1]-=gap;
                    time-=gap;
                }
                else {
                    works[works.length - 1]--;
                    time--;
                }
        }
        for (i = 0; i <works.length ; i++) {
            answer+= (works[i]*works[i]);
        }
        System.out.println(answer);
        return answer;
    }
    public static void  swap(int[] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
