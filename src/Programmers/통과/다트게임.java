package Programmers.통과;

import java.util.Arrays;
import java.util.stream.Stream;

public class 다트게임 {
    public static void main(String[] args) {
        solution("1S2D*3T");
    }
    public static int solution(String dartResult) {
        int answer = 0;
        int[] part=new int[3];
        int idx=0;
        String[] mutiple={"", "S", "D", "T"};
        for (int i = 0; i <dartResult.length() ; i++) {
            char c=dartResult.charAt(i);
            if(Character.isDigit(c)){
                if(c=='1' && dartResult.charAt(i+1)=='0'){
                    part[idx++]=i;
                    i++;
                }
                else {
                    part[idx++] = i;
                    if (idx == 3) break;
                }
            }
        }
        Arrays.stream(part).forEach(System.out::println);
        String[] str=new String[3];
        str[0]=dartResult.substring(0, part[1]);
        str[1]=dartResult.substring(part[1],part[2]);
        str[2]=dartResult.substring(part[2]);
        boolean check=false;
        Stream.of(str).forEach(System.out::println);

        for (int i = 2; i >=0 ; i--) {
            int mtp=1;
            int num=0;
            for (int j = 1; j <4; j++) {
                if(str[i].contains(mutiple[j])){
                    mtp=j;
                    str[i]=str[i].replaceAll(mutiple[j],"");
                }
            }
            if(str[i].contains("*")){
                num=Integer.parseInt(str[i].substring(0,str[i].length()-1));
                num= (int) Math.pow(num,mtp)*2;
                if(check)num*=2;
                check=true;
            }
            else if(str[i].contains("#")){
                num=Integer.parseInt(str[i].substring(0,str[i].length()-1));
                num= -1*(int) Math.pow(num,mtp);
                if(check)num*=2;
                check=false;

            }
            else{
                num=Integer.parseInt(str[i]);
                num= (int) Math.pow(num,mtp);
                if(check)num*=2;
                check=false;
            }
            System.out.println(num);
            answer+=num;
        }

        System.out.println(answer);
        return answer;
    }
}
