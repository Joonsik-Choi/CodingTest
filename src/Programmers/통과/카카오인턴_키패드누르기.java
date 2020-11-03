package Programmers.통과;

public class 카카오인턴_키패드누르기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left"));
    }
    public static String solution(int[] numbers, String hand) {
            Point left=new Point(3,0);
            Point right=new Point(3,2);
            StringBuilder builder=new StringBuilder();
            for(int n:numbers){
                System.out.println(n +"  "+left+" "+right);
                System.out.println(n +"  "+ left.getDistance(n)+"  "+ right.getDistance(n));
                if(n%3==1){
                   builder.append("L");
                   left.setRC(n/3,0);
               }else if(n!=0 &&n%3==0){
                   builder.append("R");
                   right.setRC(n/3-1,2);
               }else{
                    if(left.getDistance(n) ==right.getDistance(n)){
                        if(hand.equals("left")){
                            builder.append("L");
                            if(n==0)left.setRC(3,1);
                            else left.setRC(n/3,1);
                        }
                        else{
                            builder.append("R");
                            if(n==0) right.setRC(3,1);
                            else right.setRC(n/3,1);
                        }
                    }
                    else if(left.getDistance(n) <right.getDistance(n)){
                        builder.append("L");
                        if(n==0)left.setRC(3,1);
                        else left.setRC(n/3,1);
                    }
                    else{
                        builder.append("R");
                        if(n==0) right.setRC(3,1);
                            else right.setRC(n/3,1);
                    }
               }
            }
        String answer = builder.toString();
        return answer;
    }
}
class Point{
    private int r;
    private int c;
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
    public void setRC(int r, int c){
        this.r = r;
        this.c = c;
    }
    public int getDistance(int n){
        int r;
        r=n>0?n/3:3;
        return Math.abs(this.r-r)+Math.abs(this.c-1);
    }
    public String toString(){
        return "["+r+" "+c+"]";
    }
}
