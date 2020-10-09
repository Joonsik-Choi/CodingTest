package 동적계획법;

import java.util.Scanner;

public class 파보나치함수_1003 {
    static long[] M;
    static int[] a;
    static int[] b;
    public static void main(String[] args) {
        Scanner sc=new Scanner( System.in );
        int t= sc.nextInt();
        int n;
        a=new int [100];
        b=new int [100];
        M=new long[50];
        M[0]=0;
        M[1]=1;
        for (int i = 0; i < t; i++) {
            n=sc.nextInt();
            function(n);
            System.out.println(a[n]+" "+b[n]);
        }
    }
    private static long function(int n) {
        if(n==0){
            a[0]=1;
            return Long.valueOf( 0 );
        }
        if(n==1){
            b[1]=1;
            return Long.valueOf( 1 );
        }
        if(M[n]==0){
            M[n]=function( n-1 )+ function( n-2 );
            if(a[n]==0) a[n]=a[n-1]+a[n-2];
            if(b[n]==0) b[n]=b[n-1]+b[n-2];
        }
        return M[n];
    }
}
