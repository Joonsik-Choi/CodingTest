import java.math.BigInteger;
import java.util.Comparator;
import java.util.Scanner;

public class 큰수A_B_10757 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BigInteger a=new BigInteger(sc.next());
        BigInteger b=new BigInteger(sc.next());
        BigInteger result=a.add(b);
        System.out.println(result);
    }
}
