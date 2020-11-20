package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 수식최대화 {
    static ArrayList<int[]> ints=new ArrayList<>();
    static ArrayList<Character> strings = new ArrayList<>();
    public static void main(String[] args) {
        solution("100-200-500+20");
    }

    public static long solution(String expression) {
        long answer = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' && !strings.contains('+')) {
                strings.add('+');
            } else if (c == '-' && !strings.contains('-')) {
                strings.add('-');
            } else if (c == '*' && !strings.contains('*')) {
                strings.add('*');
            }
        }
        int[] num = new int[strings.size()];
        function(num, 0);

        return answer;
    }
  /*  public static int result(String s, int[] num){

    }*/
    public static void function(int[] num, int i) {
        if (i < num.length) {
           int[]  newNum = Arrays.copyOf(num, num.length);
            int k;
            for (int j = 0; j < num.length; j++) {
                    k=(i+j)%num.length;
                    if(!isNum(newNum,i,k)) {
                        newNum[i] = k;
                        function(newNum, i + 1);
                    }
            }
        }
        else if(i==num.length){
            Arrays.stream(num).forEach(s-> System.out.print(s+" "));
            System.out.println();
            ints.add(num);
        }
    }

    public static  boolean isNum(int[] arr, int p, int n){
        for (int i = 0; i <p; i++) {
            if(arr[i]==n)return true;
        }
        return false;
    }
}
