package Programmers.통과;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 완주하지못한선수 {
    public static void main(String[] args) {
        String[] a={"leo", "kiki", "eden"};
        String[] b={"leo", "kiki"};
        System.out.println(solution(a,b));
    }
    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hash=new HashMap<>();
        for (int i = 0; i <participant.length ; i++) {
            if(!hash.containsKey( participant[i] )){
                hash.put( participant[i] , 1);
            }
            else{
                int count=hash.get( (String)participant[i] );
                hash.remove( participant[i] );
                hash.put(participant[i], count+1);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if(hash.containsKey( completion[i] )){
                int count=hash.get( completion[i] );
                if(count!=1){
                    hash.replace( completion[i], count-1);
                }
                else{
                    hash.remove( completion[i] );
                }
            }
        }
        String answer = "";
        Iterator<Map.Entry<String,Integer>> entryIterator=hash.entrySet().iterator();
        if(entryIterator.hasNext()){
            Map.Entry<String, Integer> next=entryIterator.next();
            answer=next.getKey();
        }
        return answer;
    }
}
