package inflearn;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums={0,3,2,0,8,5};
        int index=0;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }
        }
        while (index<nums.length){
            nums[index++]=0;
        }
        Arrays.stream(nums).forEach(s-> System.out.println(s));
    }
}
