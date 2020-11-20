package Programmers;
public class 큰수만들기 {
    public static void main(String[] args) {
        String s="123412523156234236123342361234236123423612341236512342352136236345234634723453754845675634547";
        System.out.println(solution(s, 10));
    }
    public static String solution(String number, int k) {
        int totalNumLen=number.length()-k;
        int numberLen=number.length();
        int max=0;
        int n;
        for (int i = 0; i < totalNumLen; i++) {
            n=number.charAt(i)-'0';
            if(max<n)max=n;
            if(max==9)break;
        }
        int i=0;
        for (  i= 0; i < totalNumLen; i++) {
            if(number.charAt(i)-'0'==max)break;
        }
        StringBuffer buffer=new StringBuffer();
        for (int j = 0; j < totalNumLen; j++) {
            for (int l = i+1; l < numberLen; l++) {
                if(numberLen-l>=totalNumLen-j) {
                    if (number.charAt(i)< number.charAt(l)) {
                        i = l;
                    }
                }
                else{
                    break;
                }
            }
            buffer.append(number.charAt(i)-48);
                i++;
        }
        String answer=buffer.toString();
        if(answer.equals(""))answer="0";
        return answer;
    }
}