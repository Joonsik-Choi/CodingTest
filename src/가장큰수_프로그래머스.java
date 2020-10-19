import java.util.Arrays;
import java.util.Collections;

public class 가장큰수_프로그래머스 {
    public static void main(String[] args) {
        int[] nums={3, 30, 34, 5, 9};
        System.out.println(solution(nums));
    }
    public static String solution(int[] numbers) {
        String answer = "";
        Number[] nums=new Number[numbers.length];
        for (int i = 0; i <numbers.length ; i++) {
            nums[i]=new Number(numbers[i]);
        }
        Arrays.sort(nums, Collections.reverseOrder());
        StringBuffer buffer=new StringBuffer();
        int total=0;
        for (int i = 0; i <numbers.length ; i++) {
            buffer.append(nums[i].getN());
            total+=nums[i].getN();
        }
        if(total==0)return "0";
        answer=buffer.toString();
        return answer;

    }
}
class Number implements Comparable {
    private int n;
    int firstNum;
    public Number(int n) {
        this.n = n;
        firstNum = n;
        while (firstNum / 10 > 0) {
            firstNum = firstNum / 10;
        }
    }
    @Override
    public int compareTo(Object o) {
        Number number = (Number) o;
        if (n == number.n) return 0;
        else if (firstNum > number.firstNum) {
            return 1;
        } else if (firstNum == number.firstNum) {
            int a=Integer.parseInt((String.valueOf(n)+String.valueOf(number.n)));
            int b=Integer.parseInt((String.valueOf(number.n)+String.valueOf(n)));
            return a-b;
        } else {
            return -1;
        }
    }
        public int getN () {
            return n;
        }

}
