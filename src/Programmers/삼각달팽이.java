package Programmers;

public class 삼각달팽이 {
    public static void main(String[] args) {
       int[] arr= solution( 6 );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
    public static int[] solution(int n) {
        int maxNum=(n*(n+1))/2;
        int[] answer =new int[maxNum];
        int[][] arr=new int[n][n];
        int i=1;
        int k=0;
        int w=0;
        int h=0;
        while(i<=maxNum){
            for (int j = 0; j < n-k; j++) {
                arr[w++][h]=i++;
                if(i>maxNum)break;
            }
            k++;
            --w;
            for (int j = 0; j <n-k ; j++) {
                arr[w][++h]=i++;
            }
            k++;
            for (int j = 0; j <n-k ; j++) {
                arr[--w][--h]=i++;
            }
            k++;
            if(k<n){
                ++w;
            }
        }
        int answerPoint=0;
        for (int j = 0; j <n ; j++) {
            for (int l = 0; l <n ; l++) {
                if(arr[j][l]!=0) {
                    answer[answerPoint++] = arr[j][l];
                }
            }
        }
        return answer;
    }
}
