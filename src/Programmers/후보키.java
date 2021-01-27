package Programmers;

import java.util.ArrayList;

public class 후보키 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}}));
    }
    public static int solution(String[][] relation) {
        int row=relation.length, col=relation[0].length;
        int answer = 0;
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < col; i++) {
            ArrayList<String> strings=new ArrayList<>();
            for (int j = 0; j <row ; j++) {
                if(!strings.contains(relation[j][i])){
                    strings.add(relation[j][i]);
                    continue;
                }
                else{
                    list.add(i);
                    break;
                }
            }
            strings.clear();
        }
        answer=col-list.size();

        return answer;
    }
}
