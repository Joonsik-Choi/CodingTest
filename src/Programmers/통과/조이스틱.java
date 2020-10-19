package Programmers.통과;
/*
 * 모든 문자   AAAA로 기본 셋팅
 *
 * 첫번 째 문자까지 이동(앞으로 가거나 뒤로가거나 둘중 하나)
 *
 * 왼쪽 또는 오른 쪽으로 자리 이동
 *
 *
 * */
public class 조이스틱 {

    public static void main(String[] args) {
       // System.out.println((int)'A');
        System.out.println(solution("JEROEN"));
    }
    public static int solution(String name) {
        int[] nameLen=new int[name.length()];// ABCDEFGHIJKLMNOPQRSTUVWXYZ
        boolean[] nameBool=new boolean[name.length()];
        for (int i = 0; i < name.length(); i++) {
            for (int j = 0; j<=26; j++) {
              //  System.out.println(j+'A');
                if((int)name.charAt(i)==  j+65){
                    nameLen[i]=j;
                    System.out.print((char)(j+65)+" ");
                    break;
                }
            }
        }
        System.out.println();

        int i=0;
        int count=0;
        int sum=0;
        for (int j = 0; j < name.length(); j++) {
            if(nameLen[j]==0)nameBool[j]=true;
        }
        int c=0;
        while(count<name.length() && c<name.length()){
            int leftCount=0;
            int rightCount=0;
            if(nameBool[i]==false)nameBool[i]=true;

            if(nameLen[i]>13){
                sum+=26-nameLen[i];
            }
            else{
                sum+=nameLen[i];
            }
            c=0;
            for (int j = i; ;) {
                if(nameBool[j]==false){
                    break;
                }
                if(c>=name.length())break;
                    j=(j+1)%name.length();
                    rightCount++;
                    c++;
            }
            c=0;
            for (int j = i; ; ) {
                if(nameBool[j]==false){
                    break;
                }
                if(c>=name.length())break;
                j=(j-1)<0?name.length()-1:j-1;
                leftCount++;
                c++;
            }
            System.out.println("현재 i : "+i);
            System.out.println(rightCount+" : "+leftCount);
            System.out.println(rightCount<=leftCount?"오른쪽이동":"왼쪽이동");
            i=rightCount<=leftCount?(i+1)%name.length():(i-1)<0?name.length()-1:i-1;
            System.out.println("이동 후 i : "+i);
            count++;
        }
        int answer = sum+count-1;
        return answer;
    }
}
