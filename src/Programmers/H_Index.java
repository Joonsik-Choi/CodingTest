package Programmers;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 4, 4, 5, 0, 1, 2, 3})); //0,1,2,3,4,4,4,5
    }
    public static int solution(int[] citations) { //0,1,3,5,6
        Arrays.sort(citations);
        int h=0;
        int smallCount=0;
        int bigCount=0;
        int i=0;
        for( i=0;i<citations.length;i++){
            h=citations.length-i;
            for (int j = 0; j < citations.length; j++) {
                if(citations[i]>=citations[j])smallCount++;
                if(citations[i]<=citations[j])bigCount++;
            }
            if(smallCount<=h && bigCount>=h)break;
            smallCount=0;
            bigCount=0;
        }
        int answer = h;
        return answer;
    }
}
