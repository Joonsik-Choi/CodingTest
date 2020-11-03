package inflearn;

import java.util.ArrayList;
import java.util.List;
public class Mergelnterval {
    public static void main(String[] args) {
        Interval in1=new Interval(1,3);
        Interval in2=new Interval(2,6);
        Interval in3=new Interval(8,10);
        Interval in4=new Interval(15,18);
        List<Interval> intervalList=new ArrayList<>();
        intervalList.add(in1);
        intervalList.add(in2);
        intervalList.add(in3);
        intervalList.add(in4);
        List<Interval> resultList=merge(intervalList);
        resultList.stream().forEach(s-> System.out.println(s.a+" "+s.b));
    }

    private static List<Interval> merge(List<Interval> intervalList) {
        List<Interval> resultList=new ArrayList<>();
        int idx=0;
        Interval before=intervalList.get(0);
        for (int i = 1; i < intervalList.size(); i++) {
            Interval current=intervalList.get(i);
            if(before.b>current.a){
                    before.setB(current.b);
                }
                else {
                    resultList.add(before);
                    before=current;
                }
            }
        if(!resultList.contains(before))
        {
            resultList.add(before);
        }
        return resultList;
        }


}
