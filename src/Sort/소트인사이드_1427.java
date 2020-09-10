package Sort;

import java.io.*;
import java.util.Arrays;

public class 소트인사이드_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.valueOf(br.readLine());
        int[] num=new int[20];
        int digit=0;
        for (int i = 0; i < 20; i++) {
            num[i]=n%10;
            digit++;
            if(n/10==0){
             break;
            }
            n/=10;
        }
        Arrays.sort(num, 0, digit);
        for (int i = digit-1; i >= 0; i--) {
            bw.write(String.valueOf(num[i]));
        }
        bw.write("\n");
        bw.flush();
    }
}
