package inflearn;

import java.util.Arrays;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] nums={73,74,75,71,69,72,76,73};
        int[] result=solve(nums);
        Arrays.stream(result).forEach(s-> System.out.println(s));
    }
    public static int[] solve(int[] nums){
        int[] result=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]<nums[j]){
                    result[i]=j-i;
                    break;
                }
            }
        }
        return result;
    }
}
