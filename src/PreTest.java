import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PreTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        ArrayList<Integer> list=new ArrayList<>();
        boolean[][] arrBool=new boolean[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                arr[i][j]=sc.nextInt();
                if(arr[i][j]==0){
                    arrBool[i][j]=true;
                }
            }
        }
        int pX=0;
        int pY=0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(arrBool[i][j]==false){
                    pX=i;
                    pY=j;
                    int regSize=0;
                    while(pX<n && pY<n && arrBool[pX][pY]!=true){
                        regSize++;
                        arrBool[pX][pY]=true;
                        if(pY<n-1){
                            if( arrBool[pX][pY+1]!=true)pY++;
                            else{

                            }
                        }
                        else {
                            pX++;
                        }
                    }
                    list.add(regSize);
                }
                System.out.println(list.size());
               for(int a: list)
                   System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
