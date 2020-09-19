import java.util.Arrays;
import java.util.Collections;

public class 가장큰수_프로그래머스 {
    public static void main(String[] args) {
        int[] nums={3, 30, 34, 5, 9};
        System.out.println(solution1(nums));
    }
    public static String solution1(int[] numbers) {
        String answer = "";
        Number[] nums=new Number[numbers.length];
        for (int i = 0; i <numbers.length ; i++) {
            nums[i]=new Number(numbers[i]);
        }
        Arrays.sort(nums);
        StringBuffer buffer=new StringBuffer();
        for (int i = 0; i <numbers.length ; i++) {
            buffer.append(nums[i].getN());
        }
        answer=buffer.toString();
        return answer;

    }
    public static String solution(int[] numbers) {
        String answer = "";
        int numberLen=numbers.length;
        double max=-1;
        int cnt=0;
        double dm=0;
        Arrays.sort(numbers);
        int[] newNum=new int[numberLen];
        boolean[] test=new boolean[numberLen];
        for (int i = 0; i <numberLen ; i++) {
            for (int j = 0; j <numberLen ; j++) {
               if(test[j]==false) {
                   dm=numbers[j];
                   while(dm/10>=1)dm/=10;
                   if (dm == max) {
                       cnt=(numbers[cnt]<numbers[j])?cnt:j;
                   } else if(dm-max<1){

                   }else if (dm > max) {
                       cnt = j;
                       max = dm;

                   }
               }
            }
            max=-1;
            newNum[i]=cnt;
            test[cnt]=true;
        }
        StringBuffer buffer=new StringBuffer();
        for (int i = 0; i < numberLen; i++) {
            buffer.append(numbers[newNum[i]]);
        }
        answer=buffer.toString();
        return answer;
    }
}

class Number implements Comparable{
    private int n;
    private double m;
    public Number(int n){
        this.n=n;
        m=n;
        while(m/10>=1)m/=10;

    }
    @Override
    public int compareTo(Object o) {
        Number number=(Number)o;
        if(n==number.n){
            return 0;
        }
        else if(m==number.m){
            return (n<=number.n)?-1:1;
        }
        else if(m>number.m){
            if((int)m==(int)number.m){
                return (m> number.m*1.111)?-1:1;
            }else{
                return -1;
            }
        }
        else{
            return 1;
        }
    }

    public int getN() {
        return n;
    }
}
