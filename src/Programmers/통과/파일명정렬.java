package Programmers.통과;

import java.util.Arrays;
import java.util.Comparator;

public class 파일명정렬 {
    public static void main(String[] args) {
        for(String s: solution(new String[]{"img00000000012345", "img000110001.png","img4560","IMG1235", "img1234.56defg1244.jpg"})){
            System.out.println(s);
        }
    }
    public static String[] solution(String[] files) {
        Comparator comparator=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String[] a=getFiles((String) o1);
                String[] b=getFiles((String) o2);
                if(a[0].equals(b[0])){
                    int num1=Integer.parseInt(a[1]);
                    int num2=Integer.parseInt(b[1]);
                    if(num1==num2){
                        return a[2].compareTo(b[2]);
                    }
                    else{
                        return num1-num2;
                    }
                }
                else{
                    return a[0].compareTo(b[0]);
                }
            }
        };
        Arrays.sort(files, comparator);
        return files;
    }
    public static String[] getFiles(String s){
        int i=0;
        String head="";
        String number="";
        String tail="";
        for ( i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                break;
            }
            head+=c;
        }
        int idx=i;
        for (; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(!Character.isDigit(c) || i>=idx+5)break;
            number+=c;
        }
        for (; i <s.length() ; i++) {
            char c=s.charAt(i);
            tail+=c;
        }
        System.out.println(head+" "+ Integer.parseInt(number)+" "+tail);
        return new String[]{head.toLowerCase(),number,tail};
    }
}

