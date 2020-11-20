package Programmers.통과;

import java.util.Stack;

public class 괄호변환 {
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }
    public static String solution(String p) {
        String answer = function(p);
        return answer;
    }

    public static String function(String p){
        if(p.equals(""))return "";
        int leftCount=0;
        int rightCount=0;
        int idx=0;
        for (int i = 0; i <p.length() ; i++) {
            if(p.charAt(i)=='(')leftCount++;
            else if(p.charAt(i)==')')rightCount++;
            if(leftCount==rightCount){
                idx=i;
                break;
            }
        }
        String u=p.substring(0,idx+1);
        String v=p.substring(idx+1);
//        System.out.println("u: "+u);
//        System.out.println("v: "+v);
        if(check(u)){
         //   System.out.println("check "+u);
            return u+function(v);
        }else{
    //        System.out.println(u);
            u=u.substring(1,u.length()-1);
            u=reverse(u);
            return "("+function(v)+")"+u;
        }

    }
    public static boolean check(String s){
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
           if(s.charAt(i)=='(')stack.push(s.charAt(i));
           else{
               if(stack.empty())return false;
               else stack.pop();
           }
        }
        return stack.isEmpty();
    }
    public static String reverse(String s){
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)=='(') builder.append(")");
            else if(s.charAt(i)==')'){
                builder.append("(");
            }
        }
        return builder.toString();
    }
}
