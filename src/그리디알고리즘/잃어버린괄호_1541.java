package 그리디알고리즘;

import java.util.*;

public class 잃어버린괄호_1541 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] str=s.split("-");
        int sum=sum(str[0]);
        for (int i = 1; i < str.length; i++) {
            sum-=sum(str[i]);
        }
        System.out.println(sum);
    }
    public static  int sum(String str){
        String[] strings=str.split("[+]");
        int sum=0;
        for (int i = 0; i < strings.length; i++) {
            sum+=Integer.parseInt(strings[i]);
        }
        return sum;
    }
}
