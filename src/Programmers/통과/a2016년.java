package Programmers.통과;
import java.time.LocalDate;
import java.util.Date;

public class a2016년 {
    public static void main(String[] args) {
        LocalDate date= LocalDate.of(2016,1,1);

       // String[] day={"SUN","MON","TUE","WED","THU","FRI","SAT"};
      //  String answer = day[date.getDayOfWeek().getValue()];
        System.out.println(date.getDayOfWeek().getValue());
    }
    public String solution(int a, int b) {
        LocalDate date= LocalDate.of(2016,a,b);
        String[] day={"","MON","TUE","WED","THU","FRI","SAT","SUN"};
        String answer = day[date.getDayOfWeek().getValue()];
        return answer;
    }
}

