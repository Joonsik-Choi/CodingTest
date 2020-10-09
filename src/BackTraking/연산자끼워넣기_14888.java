package BackTraking;

import java.util.Scanner;

public class 연산자끼워넣기_14888 {
    private static int max=Integer.MIN_VALUE;
    private static int min=Integer.MAX_VALUE;
    private static int[] a;
    public static void main(String[] args) {
        Scanner sc =new Scanner( System.in );
        int n=sc.nextInt();
        a=new int[n];
        int[] M=new int[4];
        int mCount=0;
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            M[i]=sc.nextInt();
            mCount+=M[i];
        }
        String[] m={"+","-","*","/"};
        StringBuffer buffer=new StringBuffer();
        for (int i=0, t =0; i < mCount;) {
            if(M[t]==0) {
                t++;
                continue;
            }
            M[t]--;
            buffer.append( m[t] );
            i++;
        }
        int result=a[0];
        //System.out.println(buffer.toString());
        function( buffer.toString(), result, 0 );
       // System.out.println( "max : "+ max+" min : "+min);
        System.out.println(max);
        System.out.println(min);
    }
    public static void function(String s,int result, int i){
            String str=new String(s.toString());
            int resultTemp=result;
            for (int j = 0; j < s.length(); j++) {
                    if(s.charAt( j )==' '){
                        continue;
                    }
                    resultTemp=cal(result, str.charAt( j ),a[i+1]);
                    //System.out.println(i +" "+ resultTemp+" "+ max+" "+min);
                    str = s.replaceFirst( String.valueOf( "\\"+s.charAt( j ) ), " " );
                    if(a.length-1>i+1) {
                        function( str, resultTemp, i + 1 );
                    }
                    else{
                        max=max<resultTemp?resultTemp:max;
                        min=min>resultTemp?resultTemp:min;
                    }
                }

    }
    public static int cal(int a, char s, int b){
        int result=a;
        switch (s){
            case '+':
                result=a+b;
                break;
            case '-':
                result=a-b;
                break;
            case '*':
                result=a*b;
                break;
            case '/':
                result=(a<0)?(a*(-1)/b)*(-1):a/b;
                break;
            default:
        }
        return result;
    }
}
