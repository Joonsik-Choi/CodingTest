package BackTraking;

import java.io.*;

public class N과M4_15652 {
    static int[] result;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String[] s;
        s=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int m=Integer.parseInt(s[1]);
        result=new int[m];
        solve(n, 0);
    }

    static void solve(int n, int i) throws IOException {
        for (int j = 1; j <=n ; j++) {
            if(i<result.length){
                if(i==0){
                    result[i] = j;
                }
                else if(i!=0 && result[i-1]<=j) {
                    result[i] = j;
                }
                else
                    continue;
                solve(n, i + 1);
            }else{
                for (int k = 0; k <i ; k++) {
                    bw.write(String.valueOf(result[k])+" ");
                }
                bw.write("\n");
                bw.flush();
                break;
            }
        }

    }

}
