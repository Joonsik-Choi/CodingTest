package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class 기지국설치 {
    public static void main(String[] args) {
        System.out.println(solution(16,new int[]{9}, 2));
    }
    public static int solution(int n, int[] stations, int w) {
        int answer=0;
        ArrayList<Integer> result=new ArrayList<>();
        int[] area=new int[n];
        for (int idx:stations) {
            if(idx-w>0 && idx+w<=n){
                for (int i = idx-w-1; i <idx+w ; i++) {
                    area[i]=+1;
                }
            }
            else if(idx-w<=0){
                for (int i = 0; i <idx+w ; i++) {
                    area[i]=+1;
                }
            }
            else{
                for (int i = idx-w; i <n ; i++) {
                    area[i]=+1;
                }
            }
        }
        int count=0;
        for (int i = 0; i <n ; i++) {
            if(area[i]==0){
                count++;
            }else if(count!=0 && area[i]!=0) {
                result.add(count);
                count = 0;
            }
        }
        if(count!=0){
            result.add(count);
        }
        answer=result.stream().mapToInt(num -> {
            if((num%(2*w+1))!=0){
                return num/(2*w+1)+1;
            }
            else{
                return num/(2*w+1);
            }
        } ).sum();
        return answer;
    }
}
