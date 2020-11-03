package Programmers.통과;


import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        int[] s = solution(new String[]{"AA", "AAA", "A", "AAA", "AAA", "AAA", "AAA", "AAA", "CCC"});
        System.out.println(s[0] + " " + s[1]);
    }
    public static int[] solution(String[] gems) {
        String[] uniqueGems = Arrays.stream(gems).distinct().toArray(String[]::new);
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int k = 0;
        for (String s : uniqueGems) {
            hashMap.put(s, k++);
            arrayList.add(0);
        }
        Point1 minPoint1 = null;
        int s, e;
        s = 0;
        e = 0;
        arrayList.set(0, 1);
        for (s = 0; s < gems.length; s++) {
            int Point = hashMap.get(gems[s]);
            while (arrayList.contains(0) && e <= gems.length) {
                if (e + 1 < gems.length) e++;
                else break;
                int p = hashMap.get(gems[e]);
                arrayList.set(p, arrayList.get(p) + 1);
            }
            if (!arrayList.contains(0)) {
                if (minPoint1 == null) {
                    minPoint1 = new Point1(s, e);
                } else if (minPoint1.compareTo(new Point1(s, e)) == 1) {
                    minPoint1.setPoint1(s, e);
                }
            }
            arrayList.set(Point, arrayList.get(Point) - 1);
        }
        int[] answer = {minPoint1.x + 1, minPoint1.y + 1};
        return answer;
    }
}
    /*public static int[] solution(String[] gems) {
        String[] uniqueGems=  Arrays.stream(gems).distinct().toArray(String[]::new);
        HashMap<String,Integer> hashMap=new HashMap<>();
        Arrays.stream(uniqueGems).forEach(s -> hashMap.put(s, 0));
        ArrayList<Point1> points=new ArrayList<>();
        int s, e;
        s=0;
        e=0;
        hashMap.replace(gems[s],  1);
        for ( s = 0; s < gems.length; s++) {
            while(hashMap.values().contains(0) && e<=gems.length) {
                if(e+1<gems.length)e++;
                else break;
                hashMap.replace(gems[e],hashMap.get(gems[e]) + 1);
            }
            if(!hashMap.values().contains(0)){
                points.add(new Point1(s,e));
            }
            hashMap.replace(gems[s],hashMap.get(gems[s])-1);
        }
        Optional<Point1> p=points.stream().min(new Comparator<Point1>() {
            @Override
            public int compare(Point1 o1, Point1 o2) {
                return o1.d-o2.d;
            }
        });
        int[] answer={p.get().x+1,p.get().y+1};
        return answer;
    }*/

class Point1 implements Comparable{
    int x;
    int y;
    int d;
    public Point1(int x, int y){
        this.x=x;
        this.y=y;
        d=Math.abs(y-x);
    }
    public void setPoint1(int x, int y){
        this.x=x;
        this.y=y;
        d=Math.abs(y-x);
    }
    public String toString(){
        return (x+" "+y+" "+" "+d);
    }
    @Override
    public int compareTo(Object o) {
        Point1 p=(Point1)o;
        if(d!=p.d){
            return d-p.d;
        }
        else{
            return x-((Point1) o).x;

        }
    }
}