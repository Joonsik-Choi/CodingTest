package Programmers.통과;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 튜플 {
    public static void main(String[] args) {
        solution("{{20,111},{111}}");
    }
    public static int[] solution(String s) {
        String[] str=s.substring(2,s.length()-2).split("},");
        Str[] strArray=new Str[str.length];
        for (int i = 0; i < str.length; i++) {
            if(str[i].indexOf("{") !=-1){
                str[i]=str[i].substring(str[i].indexOf("{")+1);
            }
            strArray[i]=new Str(str[i]);
        }
        Arrays.sort(strArray);
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> tempList=new ArrayList<>();
       // for(Str sss : strArray) System.out.println(sss);
        for (int i = 0; i < strArray.length; i++) {
                StringTokenizer strToken=new StringTokenizer(strArray[i].getS(),",");
                while(strToken.hasMoreTokens()){
                    String stk=strToken.nextToken();
                    //System.out.println(stk);
                    tempList.add(Integer.parseInt(stk));
                }
                tempList.removeAll(list);
                int temp=tempList.get(0);
                list.add(temp);
                tempList.clear();
        }

        int i=0;
        int[] answer = new int[list.size()];

        for(int temp: list) {
            answer[i++] = temp;
            System.out.println(temp);
        }
        return answer;
    }

}
class Str implements Comparable{
    private String s;

    public String getS() {
        return s;
    }

    public Str(String s) {
        this.s = s;
    }

    @Override
    public int compareTo(Object o) {
        Str str=(Str)o;
        int strLen=str.getS().length();
        if(s.length()>strLen)return 1;
        else if(s.length()==strLen)return 0;
        else{
            return -1;
        }
    }
    public String toString(){return s;}
}
