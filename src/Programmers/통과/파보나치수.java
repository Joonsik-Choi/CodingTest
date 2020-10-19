package Programmers.통과;

public class 파보나치수 {
    static long[] arr=new long[100001];

    public static void main(String[] args) {
        System.out.println(function(45));
    }
    public int solution(int n) {
        int answer = (int)(function(n));
        return answer;
    }
    static long function(long n){
          if(n==0)
              return 0;
          if(n==1)
              return 1;
          if(arr[(int) n]==0)
              arr[(int) n]=(function(n-2)%1234567+function(n-1)%1234567)%1234567;
          return arr[(int) n];
    }
}
