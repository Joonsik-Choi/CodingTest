package Programmers.통과;
import java.util.ArrayList;
import java.util.Arrays;

public class 소수만들기 {
    private static int count=0;
    public static void main(String[] args) {
            solution(new int[]{1,2,7,6,4});
    }
    public static int solution(int[] nums) {
        Arrays.sort(nums);
        function(new int[3], nums,0, 0);
        int answer = count;
        System.out.println(answer);
        return answer;
    }
    public static void function(int[] arr, int[] nums, int i, int t){
        int[] newArr=arr.clone();
        if(i<3){
        for (int j = t; j < nums.length; j++) {
            boolean check = false;
            for (int k = 0; k < newArr.length; k++) {
                if (newArr[k] == nums[j]) {
                    check = true;
                    break;
                }
            }
            if (check) {
                continue;
            }
            newArr[i] = nums[j];

            if(i<3)function(newArr, nums, i + 1, j+1);
        }
            }else{
                int total=0;
                for (int k = 0; k < 3; k++) {
                    total+=newArr[k];
                }
            System.out.println();
                if(isPrimeNum(total)){
                        count++;
                }
            }
    }
    public static boolean isPrimeNum(int n){
        for (int i = 2; i < n; i++) {
           if(n%i==0)return false;
        }
        return true;
    }
}
