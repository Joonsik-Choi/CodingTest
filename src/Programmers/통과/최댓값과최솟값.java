package Programmers.통과;

public class 최댓값과최솟값 {
    class Solution {
        public String solution(String s) {
            String[] str=s.split(" ");
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            for(String ss:str){
                max=Math.max(Integer.parseInt(ss), max);
                min=Math.min(Integer.parseInt(ss), min);

            }
            String answer = min+" "+max;
            return answer;
        }
    }
}
