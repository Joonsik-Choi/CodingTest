package Programmers;

import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        System.out.println(solution("(())"));
    }
    static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c=='('){
                stack.push(c);
                continue;
            }
            else if(c==')' && !stack.empty() && stack.peek()=='('){
                stack.pop();
                continue;
            }
            else{
                answer=false;
                break;
            }
        }
        if(!stack.empty())answer=false;
        return answer;
    }
}
