package Programmers;

import java.util.*;

public class 위장 {
    public static void main(String[] args) {

    }
    public static int solution(String[][] clothes) {
       HashMap<String, String> hash=new HashMap<>();
        HashMap<String, Integer> clothCount=new HashMap<>();
       for(String[] wear:clothes){
           hash.put(wear[0],wear[1]);
       }
        Iterator<Map.Entry<String, String>> iterator=hash.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry=iterator.next();
            if(!clothCount.containsKey( entry.getValue() )){
                clothCount.put( entry.getValue(), 1);
            }else{
                int count=clothCount.get( entry.getValue() );
                clothCount.replace( entry.getValue(), count+1);
            }
        }
        int result=1;
        Iterator<Map.Entry<String, Integer>> iteratorClothCount=clothCount.entrySet().iterator();
        while(iteratorClothCount.hasNext()){
            Map.Entry<String, Integer> entry=iteratorClothCount.next();
            int n=entry.getValue();
            result=result*(n+1);
        }
        int answer = result-1;
        return answer;
    }
}
