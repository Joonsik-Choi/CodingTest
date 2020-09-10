package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 단어정렬_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        Word[] s=new Word[n];
        String[] str=new String[n];
        int strCount=0;
        for (int i = 0; i < n; i++) {
            String word=br.readLine();
            s[i]=new Word(word);


        }
        Arrays.sort(s);
        for (int i = 0; i <n ; i++) {
            boolean check=true;
            String word=s[i].getS();
            for (int j = 0; j < strCount; j++) {
                if (word.equals(str[j])){
                    check=false;
                }
            }
            if(check){
                str[strCount++]=word;
            }
        }
        for (int i = 0; i < strCount; i++) {
            System.out.println(str[i]);
        }
    }
}
class Word implements Comparable{
    private String s;
    public Word(String s){
        this.s=s;
    }
    @Override
    public int compareTo(Object o) {
        String s=((Word)o).getS();
        if(this.s.length()>s.length()){
            return 1;
        }else if(this.s.length()==s.length()){
            return  this.s.compareTo(s);
        }else{
            return -1;
        }
    }
    public String toString(){
        return this.getS();
    }
    public String getS(){return s;}
}