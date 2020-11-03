package Programmers.통과;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class 스킬체크Level_2 {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap=new HashMap<>();
        for(String[] sArr:clothes){
            if(hashMap.containsKey(sArr[1])){
                hashMap.replace(sArr[1], hashMap.get(sArr[1])+1);
            }
            else{
                hashMap.put(sArr[1],1);
            }
        }
        int result=1;
        for(int n:hashMap.values()){
            result=result*(n+1);
        }
        int answer = result-1;
        return answer;
    }
}
