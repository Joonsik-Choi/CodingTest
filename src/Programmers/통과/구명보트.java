package Programmers.통과;

import java.util.Arrays;

/*
* people 사람 무게 리스트 limit 보트 무게 제한
* */
public class 구명보트 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70,30}, 100));
    }
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        int peopleLen=people.length;
        boolean[] check=new boolean[peopleLen];
        int total=0;
        int i=0;
        int j=peopleLen-1;
        while(i<j){
          if(people[i]+people[j]<=limit){
              check[i]=check[j]=true;
              total++;
              i++;
              j--;
          }
          else{
              j--;
          }
        }
        for (int k = 0; k <peopleLen ; k++) {
            if(check[k]==false)total++;
        }
        int answer = total;
        return answer;
    }
}
