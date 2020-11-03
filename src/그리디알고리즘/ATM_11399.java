package 그리디알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class ATM_11399 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int time=arr[0];
        int sum=arr[0];
        for (int i = 1; i <n ; i++) {
            sum=sum+time+arr[i];
            time+=arr[i];
        }
        System.out.println(sum);
    }
}
