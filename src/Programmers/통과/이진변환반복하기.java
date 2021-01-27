package Programmers.통과;

public class 이진변환반복하기 {
    public static void main(String[] args) {
        solution("110010101001");
    }
    public static int[] solution(String s) {
        int zeroCnt=0;
        int tCnt=0;
        while(!s.equals("1")){
            tCnt++;
            StringBuilder builder=new StringBuilder();
            for (int i = 0; i <s.length() ; i++) {
                if((s.charAt(i)-'0')==0){
                    zeroCnt++;
                }
                else{
                    builder.append(1);
                }
            }
            int newSLen=builder.length();
            builder=new StringBuilder();
            while(newSLen>0){
                builder.append(newSLen%2);
                newSLen=newSLen/2;
            }
            builder.reverse();
            s=builder.toString();
            System.out.println(s);
        }
        int[] answer = {tCnt, zeroCnt};
        System.out.println(tCnt+" "+zeroCnt);
        return answer;
    }
}
