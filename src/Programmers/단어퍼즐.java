package Programmers;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.stream.IntStream;

public class 단어퍼즐 {
    public static void main(String[] args) {
        String[] strs=new String[]{"ab", "na", "n", "a", "bn"};
        System.out.println(solution(strs,"nabnabn"));
    }
    public static int solution(String[] strs, String t) {
        int min=Integer.MAX_VALUE;
        Queue<Pair> q=new LinkedList<>();
        boolean check=false;
        for (int i = 0; i <strs.length ; i++) {
            if (t.startsWith(strs[i])) {
                q.add(new Pair(strs[i],1));
                while (!q.isEmpty()) {
                    StringBuilder builder = new StringBuilder();
                    Pair pair = q.poll();
                    builder.append(pair.key);
                    if (pair.key.equals(t)) {
                        check=true;
                        min=Math.min(min, pair.value);
                        break;
                    }
                    for (int j = 0; j < strs.length; j++) {
                        if (t.startsWith(builder.toString() + strs[j])) {
                            q.add(new Pair(builder.toString() + strs[j],pair.value+1));
                        }
                    }
                }
            }
        }
            return check?min:-1;
    }
}
class Pair{
    public String key;
    public int value;

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}