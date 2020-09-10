package Sort;

import java.io.*;
import java.util.Arrays;

public class 수정렬하기2_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.valueOf(br.readLine());
        int[] num=new int[n];
        int i;
        for (i = 0; i < n; i++) {
            num[i]=Integer.valueOf(br.readLine());
        }
        quickSort(num, 0, n-1);
        for (i = 0; i < n; i++) {
            bw.write(Integer.toString(num[i])+"\n");
        }
        bw.flush();
    }
    static void quickSort(int[] a, int left, int right){
        int pl=left;
        int pr=right;
        int x=a[(pl+pr)/2];
        do{
            while(a[pl]<x)pl++;
            while(a[pr]>x)pr--;
            if(pl<=pr){
                swap(a,pl++,pr--);
            }
        }while(pl<=pr);
        if(left<pr)quickSort(a,left, pr);
        if(right>pl)quickSort(a,pl,right);
    }
    static void swap(int[] a, int n1, int n2){
        int temp=a[n1];
        a[n1]=a[n2];
        a[n2]=temp;
    }
}
