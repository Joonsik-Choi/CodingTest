import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_Queen_9663 {
    static int total=0;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        num=new int[n];
        queen(0, n);
        System.out.println(total);

    }
    static void queen(int i, int n){
        for (int j = 0; j <n ; j++) {
            if (i < n) {
                boolean check=true;
                for (int k = 0; k < i; k++) {
                    if (num[k] == j || (Math.abs(j-num[k])==Math.abs(i-j)) ) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    num[i] = j;
                    queen(i + 1, n);
                }
            }
            else{
                for (int k = 0; k < n; k++) {
                    System.out.print(num[k]+" ");
                }
                System.out.println();
                total++;
                break;
            }
        }
    }
}
