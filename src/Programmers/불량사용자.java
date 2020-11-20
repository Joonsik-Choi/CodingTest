package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 불량사용자 {
    static int total;
    static ArrayList<String[]> strings1;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo","frcdo"},new String[]{"fr*d*"}));
        for(String[] sArr:strings1){
            for (int i = 0; i <sArr.length ; i++) {
                System.out.println(sArr[i]);
            }
            System.out.println();

        }

    }
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        total=0;
        String[] result=new String[banned_id.length];
        strings1=new ArrayList<>();
        function(user_id, banned_id,result,0);
        answer=strings1.size();
        return answer;
    }

    public static void function(String[] user_id, String[] banned_id, String[] result, int i){
        String[] newResult=result.clone();

        if(i<banned_id.length){
            for (int j = 0; j <user_id.length ; j++) {  //넣을 아이디 확인
                boolean resultCheck=false;
                for (int k = 0; k <result.length ; k++) { //result 에 중복 아이디 있나 확인
                    if(newResult[k]!=null&& newResult[k].equals(user_id[j])){
                        resultCheck=true;//아이디가 있을 경우
                        break;
                    }
                }
                if(resultCheck){//아이디가 있을경우 아이디 건너뛰기
                    continue;
                }
                if(user_id[j].length()== banned_id[i].length() && check(user_id[j], banned_id[i])){ //result에 입력되지 않았고 조건에 만족하는 경우 입력
                    newResult[i]=user_id[j];
                    function(user_id,banned_id, newResult,i+1);
                    }
            }
        }
        else if(i==banned_id.length){
            Arrays.sort(newResult);
            boolean check1=true;
            for (int j = 0; j <strings1.size() ; j++) {
                String[] sArr=strings1.get(j);
                if (Arrays.deepEquals(sArr, newResult)) {
                    check1=false;
                    break;
                }
            }
            if(check1){
                strings1.add(newResult);
            }
        }

    }
    public static boolean check(String user_id, String banned_id){
        for (int i = 0; i < user_id.length(); i++) {
            if(banned_id.charAt(i)=='*')continue;
            if(user_id.charAt(i)!=banned_id.charAt(i))return false;
        }
        return true;
    }
}
