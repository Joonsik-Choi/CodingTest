package inflearn;

import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args) {
            MeetingRoom a=new MeetingRoom();

        Interval in1=new Interval(15,20);
        Interval in2=new Interval(5,10);
        Interval in3=new Interval(0,30);
        Interval[] intervals={in1,in2,in3};
        System.out.println(a.solve(intervals));
    }

    public boolean solve(Interval[] intervals){
        Arrays.sort(intervals,(o1, o2) -> o1.a-o2.a);
        print(intervals);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i-1].b>intervals[i].a)return false;
        }
        return true;
    }
    public void print(Interval[] intervals){
        for(Interval interval: intervals){
            System.out.println(interval.a+" "+interval.b);
        }

    }
}

class Interval{
    int a;
    int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Interval(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
