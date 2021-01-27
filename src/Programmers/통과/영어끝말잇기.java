package Programmers.통과;

import java.util.ArrayList;
import java.util.stream.Stream;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
    }
    public static int[] solution(int n, String[] words) {
        int count=1;
        int turn=0;
        char c = 0;
        ArrayList<String> distinct=new ArrayList<>();
        for (int i = 0; i <words.length ; i++) {
            if(distinct.size()!=0){
                if(!distinct.contains(words[i]) &&  c==words[i].charAt(0)){
                    distinct.add(words[i]);
                }
                else{
                    return new int[]{turn+1, (int) Math.ceil((double)count/n)};
                }
            }
            else{
                distinct.add(words[i]);
            }
             c=words[i].charAt(words[i].length()-1);
            count++;
            turn=(turn+1)%n;
        }
        return new int[]{0,0};
    }
}
