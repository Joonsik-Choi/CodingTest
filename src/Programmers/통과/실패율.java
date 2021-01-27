package Programmers.통과;



import java.util.Arrays;
import static java.util.Arrays.*;

public class 실패율 {

    public static void main(String[] args) {
        solution(4,new int[]{4,4,4,4,4});
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] countArr=new int[N+2];
        double[] loss= new double[N];
        sort(stages);
            for (int j = 0; j <stages.length ; j++) {
                countArr[stages[j]]++;
            }
        stream(countArr).forEach(System.out::println);
        System.out.println();
        for (int i = 0; i <N ; i++) {
            int cnt= stream(copyOfRange(countArr,i+1,countArr.length)).sum();
            loss[i]=(double)countArr[i+1]/cnt;
        }
        for (int i = 0; i <N ; i++) {
            answer[i]=i+1;
        }
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (loss[j] < loss[j + 1]) {
                    swap(loss, j, j + 1);
                    swap(answer,j,j+1);
                }
            }
        }
        Arrays.stream(answer).forEach(System.out::println);

        return answer;
    }

    public static void swap (int [] arr, int a, int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void swap (double [] arr, int a, int b){
        double temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
