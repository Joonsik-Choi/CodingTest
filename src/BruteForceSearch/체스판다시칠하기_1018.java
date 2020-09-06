package BruteForceSearch;

import java.util.Scanner;

public class 체스판다시칠하기_1018 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        sc.nextLine();
        int[][] nmIntVersion=new int[n][m];
        int[][] chess=new int[8][8];
        String[] nm=new String[n];
        int[] num=new int[64];
        int firstW=0;
        int firstB=0;
        int min=64;
        int result=0;
        for (int i = 0; i < n; i++) {
            nm[i]=sc.nextLine();
        }
        System.out.println();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <nm[i].length() ; j++) {
                if(nm[i].charAt(j)=='W')
                    nmIntVersion[i][j]=0;
                else
                    nmIntVersion[i][j]=1;
            }
        }
        for (int i = 0; i <=n-8; i++) {
            for (int j = 0; j <=m-8 ; j++) {
                int cnt=0;
                for (int k = i; k < i+8; k++) {
                    for (int l = j; l <j+8; l++) {
                        num[cnt++]=nmIntVersion[k][l];
                    }
                }
                int b=1;
                int w=0;
                for (int k = 0; k <64 ; k++) {
                    if(num[k]!=b)firstB++;
                    if(num[k]!=w)firstW++;
                    if((k+1)%8!=0) {
                        b = (b + 1) % 2;
                        w = (w + 1) % 2;
                    }
                }
                result=(firstB<=firstW)?firstB:firstW;
                if(result<min)min=result;
                result=0;
                firstB=0;
                firstW=0;
            }
        }
        System.out.println(min);
    }
}
