package Programmers.통과;

import java.util.ArrayList;
import java.util.Collections;

public class 소수찾기 {
    static ArrayList<Integer> array=new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(solution("333"));

    }
    public static int solution(String numbers) {
        int numbersLen=numbers.length();
        int count=0;
        function("", numbers,0);
        Collections.sort(array);
        for (Integer s:array){
           //System.out.println(s);
            if(primeNumCk(s)){
                System.out.println(s);
                count++;
            }
        }
        int answer = count;
        return answer;
    }

    public static void function(String s,String numbers, int i){
        String number=new String(numbers);
        for (int j = 0; j < number.length(); j++) {
            char c= number.charAt(j);
            String str=s+c;
             String newNumber=numbers.replaceFirst(String.valueOf(c),"");
            if(!array.contains(Integer.parseInt(str)))array.add(Integer.parseInt(str));
            function(str,newNumber,i+1);
        }
    }
    public static boolean primeNumCk(int primeNum){
        if(primeNum<=1)return false;
        if(primeNum==2)return true;
        for (int i = 2; i <primeNum ; i++) {
            if(primeNum%i==0)return false;
        }
        return true;
    }

}
