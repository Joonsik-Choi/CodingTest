import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class 보물_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[]copyA=new int[n];
        int[] b=new int[n];
        int[] c=new int[n];
        boolean[] ck=new boolean[n];
        int cnt=0;
        for (int i = 0; i < a.length; i++) {
            a[i]= sc.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i]= sc.nextInt();
        }
        copyA=a.clone();
        Arrays.sort(copyA);
        int max=Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                if(b[j]>=max && ck[j]==false){
                    max=b[j];
                    cnt=j;
                }
            }
            max=Integer.MIN_VALUE;
            c[i]=cnt;
            ck[cnt]=true;
        }
        int result=0;
        for (int i = 0; i < n; i++) {
            a[c[i]]=copyA[i];
            //result+=(a[i]*b[i]);
        }
        for (int i = 0; i < n; i++) {
           // System.out.println(a[i]);
            result+=(a[i]*b[i]);
        }
        System.out.println(result);
    }
}
