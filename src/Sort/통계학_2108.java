package Sort;

import java.io.*;
import java.util.Arrays;

public class 통계학_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int[] num = new int[n];
        int[] cpNum=new int[n];
        int cpNumCount=0;
        int total = 0;
        int center;
        double avg = 0;
        int gap;

        for (int i = 0; i < n; i++) {
            num[i] = Integer.valueOf(br.readLine());
            total += num[i];
            if(i==0){
                cpNum[cpNumCount++]=num[i];
            }else{
                boolean check =true;
                for (int j = 0; j < cpNumCount; j++) {
                    if(num[i]==cpNum[j])check=false;
                }
                if(check){
                    cpNum[cpNumCount++]=num[i];
                }
            }
        }
        quickSort(num,0,n-1);
      // quickSort(cpNum,0,cpNumCount-1);
        int[] countNum=new int[cpNumCount];
        int maxCount=Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <cpNumCount ; j++) {
                if(num[i]==cpNum[j]){
                    countNum[j]++;
                    if(countNum[j]>maxCount){
                        maxCount=countNum[j];
                    }
                }
            }
        }
        int mode=0;
        int modeCount=0;
        for (int j = 0; j < cpNumCount; j++) {
            if(countNum[j]==maxCount){
                mode=cpNum[j];
                modeCount++;
                if(modeCount==2)break;
            }
        }

            center = num[n / 2];
            avg = total / n;
            avg=(avg>0)?Math.round(avg):-Math.round(-avg)-1;
            gap = num[n-1]-num[0];
            bw.write((int)avg + "\n");
           bw.write(center + "\n");
           bw.write(mode+"\n");
           bw.write(gap + "\n");
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

