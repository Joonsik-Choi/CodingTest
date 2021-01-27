package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Test {
    static ArrayList<String[]> strings=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(k);
        String[] strArr=new String[n];
        fun(0,n,k,strArr);
    }
    public static void  fun(int i, int n, int k, String[] strArr){
        if(i<n){
            String[] strCpy= Arrays.copyOf(strArr, i);
            for (int j = 0; j <2 ; j++) {
                strCpy[i]= String.valueOf(j);
                if(count(strArr)<k){
                    fun(i+1,n,k,strCpy);
                }
            }
        }
        else{
          strings.add(strArr);
          Arrays.stream(strArr).forEach(s->System.out.print(s+" "));
            System.out.println();
        }
    }
    public  static int count(String[] s){
        int cnt=0;
        for (int i = 0; i <s.length ; i++) {
            if(s.equals("1"))cnt++;
        }
        return cnt;
    }
}

