import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 스도크_2580 {
    static int[] row=new int[9];
    static int[] col=new int[9];
    static int[] box=new int[9];
    static int x;
    static int y;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader( new InputStreamReader( System.in));
        Scanner sc=new Scanner( System.in );
        int spaceNum=0;
        int[][] num=new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                num[i][j]=sc.nextInt();
                if(num[i][j]==0){
                    spaceNum++;
                }
            }
        }
        int count=0;
        int[] result=new int[spaceNum];
        int[][] numPoint=new int[spaceNum][2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(num[i][j]==0){
                    numPoint[count][0]=i;
                    numPoint[count][1]=j;
                    count++;
                }
            }
        }

        function(num, result, numPoint, 0);

        for (int i = 0; i < spaceNum; i++) {
            num[numPoint[i][0]][numPoint[i][1]]=result[i];
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(num[i][j]);
                if(j!=8) System.out.print(" ");
            }
            if(i!=8)
                System.out.println();
        }
    }

 public static void function(int[][] num,int[] arr, int[][]point, int i) {
         x = point[i][0];
         y = point[i][1];

         for (int k = 1; k < 10; k++) {
             num[x][y] = k;
             col = num[x].clone();//열복사
             for (int l = 0; l < 9; l++) {//행복사
                 row[l] = num[l][y];
             }
             int newX = x / 3 * 3;
             int newY = y / 3 * 3;
             int count = 0;
             for (int j = newX; j < newX + 3; j++) {
                 for (int l = newY; l < newY + 3; l++) {
                     box[count++] = num[j][l];
                 }
             }
                 for (int j = 0; j < 9; j++) {
                     System.out.print(col[j]);
                 }
                 System.out.println();

                 for (int j = 0; j < 9; j++) {
                     System.out.print(row[j]);
                 }
                 System.out.println();
                 for (int j = 0; j < 9; j++) {
                     System.out.print(box[j]);
                 }
                 System.out.println();
                 System.out.println();

             if (check( row ) && check( col ) && check( box )) {
                 arr[i]=k;
                 if(i+1< arr.length)
                 function( num, arr, point, i + 1 );
                 else break;
             }
         }
 }
 public static boolean check(int[] num){
     int[] count=new int[10];
     for(int i=0;i<9;i++){
         count[num[i]]++;
     }
     for (int i = 1; i < 10; i++) {
         if(count[i]>1)return false;
     }
     return true;
 }


}
