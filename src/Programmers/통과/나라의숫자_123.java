package Programmers.통과;

public class 나라의숫자_123 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }
    public static String solution(int n) {
        String[] s={"1","2","4"};
        int m=0;
        StringBuffer buffer=new StringBuffer();

        while(n>0){
            m=(n-1)%3;
            n=(n-1)/3;
            buffer.append(s[m]);
        }
        buffer=buffer.reverse();
        String answer = buffer.toString();
        return answer;
    }
}
