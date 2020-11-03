package 그리디알고리즘;
/*
*N(1≤N≤100,000)개의 로프가 있다. 이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다. 각각의 로프는 그 굵기나 길이가 다르기 때문에 들 수 있는 물체의 중량이 서로 다를 수도 있다.

하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다. k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.

각 로프들에 대한 정보가 주어졌을 때, 이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오. 모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.

입력
첫째 줄에 정수 N이 주어진다. 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다. 이 값은 10,000을 넘지 않는 자연수이다.

출력
첫째 줄에 답을 출력한다.
* */


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
* 로프 굵기 , 길이가 다름
* 전략
* 1. 각 로프의 중량 허용 치를 내림차 순으로 정렬
* 2. 로프의 개수당 최대 중량을 구하고 기존 최대 중량보다 작아진다면 break;
* */
public class 로프_2217 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer[] weight=new Integer[n];
        for (int i = 0; i < n; i++) {
            weight[i]=sc.nextInt();
        }
        Arrays.sort(weight,((o1, o2) -> o2-o1) );
        int max=0;
        for (int i = 0; i <n ; i++) {
            max=Math.max(weight[i]*(i+1), max);
        }
        System.out.println(max);
    }

}
// 9,10,15
//27