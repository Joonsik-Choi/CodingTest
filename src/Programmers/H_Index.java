package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class H_Index {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 4, 4, 5, 0, 1, 2, 3})); //0,1,2,3,4,4,4,5
    }
    public static int solution(int[] citations) { //0,1,3,5,6
        Arrays.sort(citations);
        int h=0;
        int smallCount=0;
        int bigCount=0;
        int i=0;
        for( i=0;i<citations.length;i++){
            h=citations.length-i;
            for (int j = 0; j < citations.length; j++) {
                if(citations[i]>=citations[j])smallCount++;
                if(citations[i]<=citations[j])bigCount++;
            }
            if(smallCount<=h && bigCount>=h)break;
            smallCount=0;
            bigCount=0;
        }
        int answer = h;
        return answer;
    }

    public static class 단어변환 {
        public static void main(String[] args) {
            System.out.println(solution("hit", "cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        }
        public static  int solution(String begin, String target, String[] words) {
            int answer = 0;
            Queue<String> q=new LinkedList<>();
            int[] level=new int[words.length];
            q.add(begin);
            while(!q.isEmpty()){
                String word=q.poll();
                int idx=-1;
                for (int i = 0; i <words.length ; i++) {
                    if(words[i].equals(word)){
                        idx=i;
                        break;
                    }
                }
                for (int i = 0; i < words.length; i++) {
                    if(isCheck(word, words[i]) && (level[i]==0 || level[i]>=level[idx]+1)){
                        q.add(words[i]);
                        if(idx==-1) {
                            level[i]=1;
                        }
                        else{
                            level[i] = level[idx]+1;
                        }
                    }
                }
            }
            for (int i = 0; i <words.length ; i++) {
                if(target.equals(words[i])){
                    answer=level[i];
                }
            }
            return answer;
        }
        public static  boolean isCheck(String a, String b){
            int count=0;
            for (int i = 0; i <a.length() ; i++) {
                if(a.charAt(i)!=b.charAt(i))++count;
            }
            if(count==1)return true;
            else return false;
        }
    }
}
