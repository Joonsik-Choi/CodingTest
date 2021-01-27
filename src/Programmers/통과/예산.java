package Programmers.통과;

import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int total=0;
        Arrays.sort(d);
        int i=0;
        for (i = 0; i <d.length ; i++) {
            if(total+d[i]>budget){
                break;
            }
            else {
                total += d[i];
            }
        }
        return i;
    }
}
