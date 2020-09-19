package kakao;

public class kakao_1 {
    public static void main(String[] args) {
        String[] id={"...!@BaT#*..y.abcdefghijklm","z-+.^.",
                "=.=","123_.def","abcdefghijklmn.p"
        };

        for (int i = 0; i < 5; i++) {
            System.out.println(solution(id[i]));
        }
    }
    public static String solution(String new_id) {
        String answer;
        new_id=new_id.toLowerCase();
        char c;
        for (int i = 0; i <new_id.length(); i++) {
             c=new_id.charAt(i);
             if( Character.isAlphabetic(c) || Character.isDigit(c)
                    || c=='-' || c=='_' || c=='.'){
                continue;
                }
                new_id = new_id.replace(String.valueOf(c), " ");
        }
        while(new_id.contains(" "))new_id=new_id.replace(" ", "");
     if(new_id.contains("..")) {
            do{
                new_id = new_id.replace("..", ".");
            }while(new_id.contains(".."));
        }
        if( new_id.length()>0){
            if(new_id.startsWith(".")) {
                new_id = new_id.substring(1);
            }
            if(new_id.endsWith("."))
                new_id=new_id.substring(0, new_id.length()-1);
        }

    if(new_id.compareTo("")==0)new_id="a";

    if(new_id.length()>=16){
        new_id=new_id.substring(0,15);

        if(new_id.charAt(new_id.length()-1)=='.')
            new_id=new_id.substring(0, new_id.length()-1);
    }

    if(new_id.length()<3){
        c=new_id.charAt(new_id.length()-1);
        while(new_id.length()<3)new_id=new_id.concat(String.valueOf(c));
    }

        answer=new_id;
        return answer;
    }
}
