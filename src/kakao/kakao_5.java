package kakao;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class kakao_5 {
    public static void main(String[] args) {
        String play_time="99:59:59";
        String adv_time="25:00:00";
        String[] logs={"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        solution(play_time,adv_time, logs);
    }
    public static String solution(String play_time, String adv_time, String[] logs) {
        int count=0;
        int maxCount=0;
        String answer = "";
        int logLen=logs.length;
        String str[];
        int maxTime=0;
        int hour=0;
        int minute=0;
        int second=0;
        int total=0;
        str=play_time.split( ":" );
        int advTotal=Integer.parseInt(str[0])*3600+Integer.parseInt(str[1])*60+Integer.parseInt(str[2]);
        str=play_time.split( ":" );
        hour=Integer.parseInt( str[0] );
        minute=Integer.parseInt( str[1] );
        second=Integer.parseInt( str[2] );
        total= hour*3600 + minute*60 +second;


        int start=0;
        int[] beg=new int[logLen];
        int[] fin=new int[logLen];
        int i=0;
        String[] begin;
        String[] finish;
        for(String s : logs){
            str=s.split("-");
            begin=str[0].split( ":" );
            finish=str[1].split( ":" );
            beg[i]=Integer.parseInt(begin[0])*3600+Integer.parseInt(begin[1])*60+Integer.parseInt(begin[2]);
            fin[i]=Integer.parseInt(finish[0])*3600+Integer.parseInt(finish[1])*60+Integer.parseInt(finish[2]);
            System.out.println(beg[i]+"-"+fin[i]);
            i++;
        }
        System.out.println(start+"    "+total);
        while(start<=total){
            count=0;
            start+=1;
            for (int j = 0; j <logLen ; j++) {
                if(start>=beg[j] && start <fin[j]){
                    count++;
                }
            }
            if(count>=maxCount){
                maxCount=count;
                maxTime=start;
            }
        }
        System.out.println(maxTime);
        System.out.println(maxCount);
        System.out.println(advTotal);
        int result=Math.abs(maxTime-advTotal);
        hour=result/3600; result%=3600;
        minute=result/60; result%=60;
        second=result;
        answer=hour+":"+minute+":"+second;
        System.out.println(answer);
        return answer;
    }
}
