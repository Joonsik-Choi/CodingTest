package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;

public class 나이순정렬_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] s;
        Person[] peoples=new Person[n];
        for (int i = 0; i < n; i++) {
            s=br.readLine().split(" ");
            peoples[i]=new Person(Integer.parseInt(s[0]), s[1]);
        }
        Arrays.sort(peoples);

        for (Person p:peoples
             ) {
            System.out.println(p);
        }
    }
}

class Person implements Comparable{
    int age;
    String name;
    LocalDateTime localDateTime;
    public Person(int age, String name){
        this.age=age;
        this.name=name;
        localDateTime=LocalDateTime.now();
    }
    @Override
    public int compareTo(Object o) {
        Person p=(Person) o;
        if(this.age>p.age){return 1;}
        else if(this.age==p.age){
            return this.localDateTime.compareTo(p.localDateTime);
        }
        else return -1;
    }
    public String toString(){
        return age+" "+name;
    }
}
