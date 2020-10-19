package Programmers.통과;

import java.math.BigInteger;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        int w=999999999;
        int h=100000000;
        System.out.println(solution(w, h));
        BigInteger a=new BigInteger("12");
    }//700000  20000000
    public static long solution(int w, int h) {
        long k=1;
        long ww,hh;
        long answer=0;
        ww=(w<=h)?w:h;
        hh=(w<=h)?h:w;
        long g=gcd(ww, hh);
        ww=ww/g;
        hh=hh/g;
        double m=(double) hh/ww%1;
        long total= (long) (Math.ceil((double)hh/ww)*ww)*g;
        if(m!=0){
            total= (long) (total+(m*ww-1)*g);
        }
        answer=(long)w*h-total;
        return answer;
    }
    static long gcd(long a, long b) {
        int g=1;
        for (int i = 2; i <= a; i++) {
            if (a % i == 0 && b%i==0) {
                g=i;
            }
        }
        return g;
    }
}
