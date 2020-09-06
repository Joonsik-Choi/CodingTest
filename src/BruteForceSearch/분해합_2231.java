package BruteForceSearch;

import java.util.Scanner;

//브루스포스
public class 분해합_2231 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int min=n;
        int sum=0;
        int num;
        int m;
        for(int i=n;i>0;i--){
                sum+=i;
                num=i;
                  do{
                      m=num%10;
                      num/=10;
                      sum+=m;
                  }while(num!=0);
                  if(sum==n && i<min){
                         min=i;
                  }
                  sum=0;
        }

        System.out.println((n==min)?0:min);
    }
}
