package Programmers;

public class n타일링 {
    static int total;
    public static void main(String[] args) {
        solution(5);
    }
    public static int solution(int n) {
        total=0;
        function(new String[n], 0, n);
        int answer = total;
        return answer;
    }
    public static void function(String[] result,  int i, int n) {
        String[] newResult = result.clone();
        String[] str = {"가로", "세로"};
        if (i < n) {
            for (String s : str) {//j=0 일 경우 가로 j=1일 경우 세로
                if(check(newResult, i)){//홀수일 경우
                    if(s.equals("가로")){
                        newResult[i]=s;
                        function(newResult, i+1, n);
                    }
                }
                else{//짝수일 경우
                    if(n-i==1 ){
                        if(s.equals("세로")){
                            newResult[i]=s;
                            function(newResult, i+1, n);
                        }
                    }
                    else {
                        newResult[i] = s;
                        function(newResult, i + 1, n);
                    }
                }
            }
        }
        else if (i == n) {
                for (int j = 0; j < n; j++) {
                    System.out.print(newResult[j] + " ");
                }
                total++;
                System.out.println();
            }
    }

    public static boolean check(String[] result, int  t){
        int count=0;
        if(t==0)return false;
        for (int i = 0; i <t ; i++) {
            if(result[i].contains("가로"))count++;
        }
        if(count%2==0)return false; //짝수 일 경우
        else return true; // 가로 배열이 홀 수개 일경우 true;
    }
}

