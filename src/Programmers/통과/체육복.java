package Programmers.통과;

import java.util.ArrayList;
import java.util.Arrays;

public class 체육복 {
    public static void main(String[] args) {
        System.out.println( solution(5,new int[]{2,4},new int[]{3}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> lostList=new ArrayList<>();
        ArrayList<Integer> reserveList=new ArrayList<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < reserve.length; i++) {
            reserveList.add(reserve[i]);
        }
        for (int i = 0; i < lost.length; i++) {
            lostList.add(lost[i]);
        }
          for (int i = 0; i <lost.length ; i++) {
                if(reserveList.contains(lost[i])){
                    reserveList.remove(new Integer(lost[i]));
                    lostList.remove(new Integer(lost[i]));
                }
            }
          lost=new int[lostList.size()];
          int t=0;
          for(int a: lostList){
              lost[t++]=a;
          }
        for (int i = 0; i < lost.length; i++) {
            if(lostList.isEmpty() ||reserveList.isEmpty())break;
            if(reserveList.contains(lost[i]+1)){
                reserveList.remove(new Integer(lost[i]+1));
                lostList.remove(new Integer(lost[i]));
            }
            else if(reserveList.contains(lost[i]-1)){
                reserveList.remove(new Integer(lost[i]-1));
                lostList.remove(new Integer(lost[i]));
            }
        }
        int answer = n-lostList.size();
        return answer;
    }
}
