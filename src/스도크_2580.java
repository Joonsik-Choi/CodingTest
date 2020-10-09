import java.util.Scanner;

public class 스도크_2580 {
    static int[] row=new int[9];
    static int[] col=new int[9];
    static int[] box=new int[9];
    static int[] arr;
    static int x;
    static int y;
    static int spaceNum=0;
    public static void main(String[] args) {
       // BufferedReader br=new BufferedReader( new InputStreamReader( System.in));
        Scanner sc=new Scanner( System.in );
        int[][] num=new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                num[i][j]=sc.nextInt();
                if(num[i][j]==0){
                    spaceNum++;
                }
            }//0의 개수 파악
        }
        int count=0;
         arr=new int[spaceNum];
        for (int i = 0; i < spaceNum; i++) {
            arr[i]=0;
        }
        int[][] numPoint=new int[spaceNum][2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(num[i][j]==0){
                    numPoint[count][0]=i;
                    numPoint[count][1]=j;
                    count++; //0의 위치저장
                }
            }
        }

        function(num, numPoint, 0); //백트랙킹시작

        for (int i = 0; i < spaceNum; i++) {
            num[numPoint[i][0]][numPoint[i][1]]=arr[i];//각 자리에 결과 값 저장
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

 public static void function(int[][] num, int[][]point, int i) {
     if(arr[arr.length-1]!=0) return;
        int[][] numCopy=new int[9][9];
     for (int j = 0; j < 9; j++) {
         numCopy[j]=num[j].clone();
     }
         for (int k = 1; k<10; k++) { // 맞는 값을 하나씩 대입
             x = point[i][0];// 행
             y = point[i][1];// 열
             if(arr[arr.length-1]!=0) return;
             numCopy[x][y] = k;

             col = numCopy[x].clone();  //값을 넣은 후 열복사
             if(!check( col )) continue;

             for (int l = 0; l < 9; l++) {//값을 넣은 후 행 복사
                 row[l] = numCopy[l][y];
             }
             if(!check(row)) continue;
             int newX = x / 3 * 3;
             int newY = y / 3 * 3;
             int count = 0;

             for (int j = newX; j < newX + 3; j++) { // 입력 값을 기준으로 3*3 행렬로 복사
                 for (int l = newY; l < newY + 3; l++) {
                     box[count++] = numCopy[j][l];
                 }
             }
             if(!check( box ))
                 continue;
                    arr[i]=k;
             if(arr[arr.length-1]!=0) return;
                 if(i+1!=spaceNum)
                     function( numCopy, point, i + 1 );
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
