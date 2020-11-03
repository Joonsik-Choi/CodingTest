package Programmers.통과;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class 스킬체크level2_1 {
    private static ArrayList<Integer> arrayList=new ArrayList();
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,6,8,14,10,15,23,32,59,78}));
    }
    public static int solution(int[] arr) {
        Arrays.sort(arr);
        int k=1;
        arrayList.add(1);
        for(int a:arr){
            k=function(k ,a);
        }
        int answer = k;
        return answer;
    }
    public static int function(int k,int n){
        ArrayList<Integer> list=new ArrayList<>();
        int j=2;
        while(n!=1 && j<=n){
            if(n%j==0){
                list.add(j);
                n/=j;
                continue;
            }
            j++;
        }
        Iterator<Integer> iterator=arrayList.iterator();
        while(iterator.hasNext()){
            int num=iterator.next();
            list.remove(new Integer(num));
        }
        if(list.size()!=0){
            arrayList.addAll(list);
        }

        for(int num: list){
            k*=num;
        }
        return k;
    }
}
