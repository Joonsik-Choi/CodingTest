package Programmers.통과;

import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        int[] price={1,2,3,2,3,5,1,0,8};
        int[] answer=solution( price );
        for (int j : answer) {
            System.out.println( j );
        }
    }
        public  static int[] solution(int[] prices) {
            Stack<Integer> stack=new Stack<>();
            Stack<Integer> stackIndex=new Stack<>();
        int[] answer=new int[prices.length];
        int second=0;
            for (int i = 0; i < prices.length; i++) {
                second++;
                    if(!stack.empty() && stack.peek()>prices[i]) {
                        while (!stack.empty() && stack.peek() > prices[i]) {
                            stack.pop();
                            int n = stackIndex.pop();
                            answer[n] = second - n - 1;
                        }
                    }
                        stack.push( prices[i] );
                        stackIndex.push( i );
            }
            while(!stackIndex.empty()){
                int n=stackIndex.pop();
                answer[n]=second-n-1;
            }
        return answer;
    }
}
