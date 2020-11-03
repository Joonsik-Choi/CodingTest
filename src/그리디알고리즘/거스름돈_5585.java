package 그리디알고리즘;

import java.util.Scanner;

public class 거스름돈_5585 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=1000-sc.nextInt();
        int[] num={500,100,50,10,10,5,1};

        int total=0;
        for (int i = 0; i < num.length; i++) {
            if(n<=0)break;
            while(n>=num[i]){
                n-=num[i];
                total++;
            }
        }
        System.out.println(total);
    }
}
