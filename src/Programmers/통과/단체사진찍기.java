package Programmers.통과;

public class 단체사진찍기 {
    static String[] name={"A","C","F","J","M","N","R","T"};
    static int total=0;
    public static void main(String[] args) {
        //System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(solution(2, new String[]{"M~C<2","C~M>1"}));
    }
    public static int solution(int n, String[] data) {
        int answer = 0;
        total=0;
        Condition[] c=new Condition[n];
        String[] sArr=new String[8];
        for (int i = 0; i < n; i++) {
            c[i]=new Condition(data[i].substring(0,1),data[i].substring(2,3), data[i].substring(3,4), data[i].substring(4,5));
        }
        function(sArr,c,0);
       answer=total;
        return answer;
    }
    public static void  function(String[] sArr,Condition[] c  ,int i){
            if(i<8){
                 String[] newArr=sArr.clone();
                for (int j = 0; j <8 ; j++) {
                    boolean check=false;
                    for (int k = 0; k <i ; k++) {
                        if(newArr[k].equals(name[j])){
                            check=true;
                        }
                    }
                    if(!check){
                        newArr[i]=name[j];
                        function(newArr, c, i+1);
                    }
                }
            }else if(i==8){
                boolean cc=true;
                for (int j = 0; j <c.length ; j++) {
                    if(!c[j].check(sArr)){
                        cc=false;
                        break;
                    }
                }
                if(cc)total++;
            }
    }
    static class Condition{
        String start;
        String end;
        String d;
        int  m;
        public Condition(String start, String end, String d, String m) {
            this.start = start;
            this.end = end;
            this.d = d;
            this.m = Integer.parseInt(m);
        }
        public boolean check(String[] sArr){
            int startPoint=0;
            int endPoint=0;
            for (int i = 0; i <sArr.length ; i++) {
                if(sArr[i].equals(start)){
                    startPoint=i;
                }
                if(sArr[i].equals(end)){
                    endPoint=i;
                }
            }
            int gap=Math.abs(startPoint-endPoint)-1;
           if(d.equals("=")){
             return gap==m?true:false;
           }else if(d.equals(">")){
               return gap>m?true:false;
           }else if(d.equals("<")){
               return gap<m?true:false;
           }
            return false;
        }
    }
}
