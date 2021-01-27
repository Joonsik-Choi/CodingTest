package Programmers.통과;

import org.w3c.dom.ls.LSOutput;

public class 예상대진표 {
    public static void main(String[] args) {
        System.out.println(solution(8,2,3));
    }
    public static int solution(int n, int a, int b)
    {
        int temp=Math.min(a,b);
        b=Math.max(a,b);
        a=temp;

        int count=1;
        while(!((b-a)==1 && a%2==1)){
            count++;
            a= (int) Math.ceil(a/2.0);
            b= (int) Math.ceil(b/2.0);
        }
        return count;
    }

}
