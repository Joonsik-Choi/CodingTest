package BruteForceSearch;

import java.util.Scanner;

public class 덩치_7568 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] heightWeight=new int[n][2];
        int[] count=new int[n];
        for (int i = 0; i < n; i++) {
           heightWeight[i][0]=sc.nextInt();
           heightWeight[i][1]=sc.nextInt();
            count[i]=0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                if(i==j)continue;
                if(heightWeight[i][0]<heightWeight[j][0] && heightWeight[i][1]<heightWeight[j][1]){
                    count[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(count[i]+1);
        }
    }
}
