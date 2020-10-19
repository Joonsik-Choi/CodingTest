package Programmers.통과;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 스킬트리 {
    public static void main(String[] args) {
        System.out.println(solution("CBD",new String[]{"BACDE","CBADF","AECB","BDA"}));
    }
    public static int solution(String skill, String[] skill_trees) {
        Queue<Character> queue =new LinkedList<>();
        int count=0;
        int c=0;
        boolean check=false;
        for (String s:skill_trees) {
            for (int i = 0; i < s.length(); i++) {
                check=false;
                if(skill.charAt(c)==s.charAt(i)){
                    c++;
                    if(c==skill.length())break;
                }else{
                    queue.add(s.charAt(i));
                    for (int j = c; j <skill.length() ; j++) {
                        if(queue.contains(skill.charAt(j))){
                            check=true;
                            break;
                        }
                    }
                }
                if(check)break;
            }
            if(!check){
                count++;
            }
            c=0;
            queue.clear();
        }
        int answer = count;
        return answer;
    }
}
