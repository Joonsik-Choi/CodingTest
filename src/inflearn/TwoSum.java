package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums={2,8,11,21};
        int target=10;
        TwoSum a=new TwoSum();
        int[] result=a.solve(nums, target);
        Arrays.stream(result).forEach(s-> System.out.println(s));
    }

    private int[] solve(int[] nums, int target) {
        int[] result=new int[2];
        Map<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                result[0]=map.get(nums[i])+1;
                result[1]=i+1;
            }
            else{
                map.put(target-nums[i],i);
            }
        }
        return result;
    }
}
