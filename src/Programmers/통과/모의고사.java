package Programmers.통과;

import java.util.ArrayList;

public class 모의고사 {
    public static void main(String[] args) {
            int[] arr=solution(new int[]{1,2,2,3});
            for (int n: arr)
                System.out.println(n);
    }
    public static int[] solution(int[] answers) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        int[] b1={2,1,2,3,2,4,2,5};
        int[] b2={3,3,1,1,2,2,4,4,5,5};
        int[] count={0,0,0};
        for (int i = 0; i <answers.length ; i++) {
            if((i%5)+1==answers[i])count[0]++;
            if(b1[i%b1.length]==answers[i])count[1]++;
            if(b2[i%b2.length]==answers[i])count[2]++;
        }
        int max=-1;
        for (int i = 0; i < count.length; i++) {
            if(max<count[i])max=count[i];
        }
        int c=0;
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
            if(max==count[i])arrayList.add(i+1);
        }
        int[] answer=new int[arrayList.size()] ;
        for(int n:arrayList)answer[c++]=n;
        return answer;
    }
}
