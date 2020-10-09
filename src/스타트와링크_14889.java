import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크_14889 {
    static int[][] arr;
    static int n;
    static int min=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader( new InputStreamReader( System.in ) );
        n=Integer.parseInt( String.valueOf( br.readLine() ) );
        arr=new int[n][n];
        int[] result=new int[n/2];
        StringTokenizer stringTokenizer;
        for (int i = 0; i <n ; i++) {
            stringTokenizer=new StringTokenizer( br.readLine());
            for (int j = 0; j <n ; j++) {
            arr[i][j]= Integer.parseInt( stringTokenizer.nextToken() );
            }
        }
        br.close();
        function(0,  result, 0 );
        System.out.println(min);

    }
    public static void function(int start, int[] result,int i){
        if(min<=0)return;
        int[] resultTemp=result.clone();
        for (int j = start; j < n; j++) {
            if(isNum( resultTemp, j, i ))continue;
            resultTemp[i]=j;
            start=j;
               if(i+1<n/2){
                   function(start ,  resultTemp, i+1);
               }
               if(i+1==n/2){
                   int a=0, b=0;
                   int[] reverseNum=reverse( resultTemp );
                   for (int k = 0; k < n/2; k++) {
                       for (int l = k+1; l <n/2 ; l++) {
                               a=a+arr[resultTemp[k]][resultTemp[l]]+arr[resultTemp[l]][resultTemp[k]];
                               b=b+arr[reverseNum[k]][reverseNum[l]]+arr[reverseNum[l]][reverseNum[k]];
                       }
                   }
                   int gap=Math.abs(a-b);
                   min=(min>gap)?gap:min;

               }
            }
        }

        public static int[] reverse(int[] a){
            boolean[] num=new boolean[n];
            int[] reverseNum=new int[a.length];
            for (int i = 0; i < a.length; i++) {
                num[a[i]]=true;
            }
            int c=0;
            for (int i = 0; i < num.length; i++) {
                if(num[i]==false) {
                    reverseNum[c++] = i;
                }
            }
        return reverseNum;
        }
        public static boolean isNum(int[] box, int m, int l ){
            for (int i = 0; i < l; i++) {
                if(box[i]==m)return true;
            }
        return false;
        }
}
