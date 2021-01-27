package DP;
import java.util.Scanner;
public class BABBA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] dpA=new int[50];
        int[] dpB=new int[50];
        dpA[1]=0;
        dpB[1]=1;

        for (int i = 2; i <=n ; i++) {
            dpA[i]=dpB[i-1];
            dpB[i]=dpA[i-1]+dpB[i-1];
        }
        System.out.println(dpA[n]+" "+dpB[n]);

    }
}
