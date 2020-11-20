package Programmers.통과;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int [][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int keyLen=key.length;
        int lockLen=lock.length;
        int newLen=lockLen+(keyLen-1)*2;
        int[][] newArr=new int[newLen][newLen];//새로운 배열 생성 배열
        for (int i = 0; i <lockLen ; i++) {
            for (int j = 0; j <lockLen ; j++) { //배열 가운데  자물쇠 입력
                newArr[keyLen-1+i][keyLen-1+j]=lock[i][j];
            }
        }
        for (int i = 0; i <4 ; i++) {
            int[][] temp=transform(key, i); // 회전
            if(check(newArr,temp,lockLen)){ // 좌물쇠 맞는지 검사
                answer=true;
                break;
            }
        }
        return answer;
    }

    private static int[][] transform(int[][] key, int n) {
        int[] x={0,0,key.length-1, key.length-1};
        int[] y={0,key.length-1, key.length-1,0 };
        int[][] newArr=new int[key.length][key.length];
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if(n==0) {
                   return key;
                }
                else if(n==1){
                    newArr[x[n]+j][y[n]-i]=key[i][j];
                }
                else if (n==2){
                    newArr[x[n]-i][y[n]-j]=key[i][j];
                }else if(n==3){
                    newArr[x[n]-j][y[n]+i]=key[i][j];
                }
            }
        }
        return newArr;
    }

    public static boolean check(int[][] newArr, int[][] key, int lockLen){
        for (int i = 0; i <newArr.length-(key.length-1) ; i++) {
            for (int j = 0; j <newArr.length-(key.length-1) ; j++) {
                int[][] newTemp=new int[newArr.length][newArr.length];
                for (int k = 0; k < newArr.length; k++) {
                    for (int l = 0; l < newArr.length; l++) {
                        newTemp[k][l]=newArr[k][l];
                    }
                }
                for (int k = 0; k <key.length ; k++) {
                    for (int l = 0; l <key.length ; l++) {
                        newTemp[i+k][j+l]+=key[k][l];
                    }
                }
               /* for (int k = 0; k < newArr.length; k++) {
                    for (int l = 0; l <newArr.length ; l++) {
                        System.out.print(newTemp[k][l]+" ");
                    }
                    System.out.println();
                }
                System.out.println();*/
                if(check2(newTemp, key.length,lockLen)){
                   return true;
                }
            }
        }
        return false;
    }
    public static  boolean check2(int[][] arr, int keyLen, int lockLen){
        int n=1;
        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) {
                if(n!=arr[keyLen-1+i][keyLen-1+j]){
                  //  System.out.println((keyLen-1+i)+" "+(keyLen-1+j) );
                    return false;
                }
            }
        }
        return true;
    }

}
