import java.util.Scanner;

public class 사분면고르기_14681 {
        public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            int x=sc.nextInt();
            int y=sc.nextInt();
            int a=0;
            if(x>=0){
                if(y>=0)a=1;
                else a=4;
            }
            else{
                if(y>=0)a=2;
                else a=3;
            }
            System.out.println(a);
        }
    }
