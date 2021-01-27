package Programmers.통과;

public class 비밀지도 {
    public static void main(String[] args) {
        //solution(5,new int[]{9,20,28,18,11},new int[]{30,1,21,17,28});
        System.out.println(change(22|14, 6));
        System.out.println(22|14);
    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            answer[i]=change(arr1[i] | arr2[i], n);
            System.out.println(answer[i]);
        }
        return answer;
    }
    public static String change(int num, int n){
        StringBuilder builder=new StringBuilder();
        while(num>0){
            if((num&1)==1){
                builder.append("#");
            }
            else{
                builder.append(" ");
            }
            num>>=1;
        }
        while(builder.length()<n){
            builder.append(" ");
        }
        builder.reverse();
        return builder.toString();
    }
}
