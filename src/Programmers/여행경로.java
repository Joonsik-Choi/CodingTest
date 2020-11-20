package Programmers;

import java.util.*;

public class 여행경로 {
    static Path[] paths;
    static ArrayList<Path> result;
    public static void main(String[] args) {
       // String[] s=solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}});//[[ICN, A], [A, C], [A, D], [D, B], [B, A]]
        String[] s=solution(new String[][]{{"ICN", "A"},{"ICN", "A"},{"A", "ICN"}}); //{{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}}
        for (int i = 0; i <s.length ; i++) {
            System.out.println(s[i]);
        }
    }
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        ArrayList<String> strings=new ArrayList<>();
        ArrayList<Path> pathArrayList=new ArrayList<>();
        paths=new Path[tickets.length];
        for (int i = 0; i <tickets.length ; i++) {
            paths[i]=new Path(tickets[i][0], tickets[i][1], false);
        }
        result=new ArrayList<>();
        Arrays.sort(paths);
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].start.equals("ICN")) {
                paths[i].check=true;
                pathArrayList.add(paths[i]);
                function(pathArrayList, 0);
                pathArrayList.remove(paths[i]);
                paths[i].check=false;

            }
        }
            strings.add("ICN");
            for (int j = 0; j < result.size(); j++) {
                strings.add(result.get(j).end);
            }
            answer=strings.toArray(String[]::new);
        return answer;
    }
    public static void function(ArrayList<Path> pathArrayList, int i){
        if(pathArrayList.size()==paths.length){
            result.addAll(pathArrayList);
            return;
        }
        if(result.size()!=0)return;
        else {
            for (int j = 0; j < paths.length; j++) {
                if (!paths[j].check && pathArrayList.get(i).end.equals(paths[j].start)) {
                    paths[j].check=true;
                    pathArrayList.add(paths[j]);
                    function(pathArrayList, i + 1);
                    pathArrayList.remove(paths[j]);
                    paths[j].check=false;

                }
            }
        }
    }
}
class Path implements  Comparable{
    String start;
    String end;
    boolean check;
    public Path(String start, String end, boolean check) {
        this.start = start;
        this.end=end;
        this.check=check;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return Objects.equals(start, path.start) &&
                Objects.equals(end, path.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(Object o) {
        Path p=(Path)o;
        int k=start.compareTo(p.start);
        if(k==0){
            return end.compareTo(p.end);
        }
        else {
            return start.compareTo(((Path) o).start);
        }
    }
    @Override
    public String toString() {
        return "Path{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
