package Programmers.통과;

import java.util.HashSet;
import java.util.Iterator;

public class 전화번호목록 {
    public static void main(String[] args) {
            String[] s={"119", "97674223", "1195524421"};
        System.out.println(solution( s ));
    }
    public static boolean solution(String[] phone_book) {
        HashSet<String> strings=new HashSet<>();
        boolean answer = true;
        for (int i = 0; i < phone_book.length; i++) {
            if(!strings.contains( phone_book[i] )){
                strings.add( phone_book[i] );
            }
            else {
                answer=false;
                return answer;
            }
        }
        Iterator<String> iterator1=strings.iterator();
        while(iterator1.hasNext()){
            String s1=iterator1.next();
                for (String s:strings){
                    if(s1.equals( s ))continue;
                    if(s1.startsWith( s )){
                        answer=false;
                        return answer;
                    }
                }
        }
        return answer;
    }
}
