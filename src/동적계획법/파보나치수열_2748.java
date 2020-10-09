package 동적계획법;

import java.util.Scanner;

public class 파보나치수열_2748 {
    static long[] M;
    public static void main(String[] args) {
        Scanner sc=new Scanner( System.in );
        int n=sc.nextInt();
        M=new long[100];
        M[0]=0;
        M[1]=1;
        System.out.println(function(n));
    }

    private static Long function(int n) {
        if(n==0)return Long.valueOf( 0 );
        if(n==1)return Long.valueOf( 1 );
        if(M[n]==0) M[n]=function( n-1 )+ function( n-2 );
        return M[n];
    }
}
