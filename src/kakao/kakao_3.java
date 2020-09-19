package kakao;

public class kakao_3 {
    public static void main(String[] args) {
        String[] a={"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] b={"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] result=solution(a, b);


    }
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int infoLen= info.length;
        String[] strA;
        String[] strB;
        int scoreA;
        String[] lan=new String[infoLen];
        String[] job=new String[infoLen];
        String[] career=new String[infoLen];
        String[] food=new String[infoLen];
        int[] score=new int[infoLen];
        int i=0;
        int j=0;
        for ( i=0;i<infoLen;i++) {
            strB=info[i].split(" ");
            lan[i]=strB[0];
            job[i]=strB[1];
            career[i]=strB[2];
            food[i]=strB[3];
            score[i]=Integer.valueOf(strB[4]);
        }
        i=0;
        for(String q: query) {
            q=q.replaceAll(" and ", " ");
            strA=q.split(" ");
            scoreA=Integer.valueOf(strA[4]);
                for (j = 0; j <infoLen ; j++) {
                    if (!strA[0].equals("-")) {
                        if (!strA[0].equals(lan[j])) {
                            continue;
                        }
                    }
                    if (!strA[1].equals("-")) {
                        if (!strA[1].equals(job[j])) {
                            continue;
                        }
                    }
                    if (!strA[2].equals("-")) {
                        if (!strA[2].equals(career[j])) {
                            continue;
                        }
                    }
                    if (!strA[3].equals("-")) {
                        if (!strA[3].equals(food[j])) {
                            continue;
                        }
                    }
                 if(score[j]<scoreA){
                     continue;
                 }
                    answer[i]++;
           }
            System.out.println(answer[i]);
            i++;
        }

        return answer;
    }
}
