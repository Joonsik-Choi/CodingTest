package Programmers.통과;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres={"classic","pop","classic","classic","pop"};
        int[] plays={500,600,150,800,2500};
        int[] answer=solution(genres,plays );
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> hashMap=new HashMap<>();
        GenresPlays[] genresPlays=new GenresPlays[genres.length];
        for (int i = 0; i < genres.length; i++) {
            genresPlays[i]=new GenresPlays( genres[i],plays[i] , i);
            if (!hashMap.containsKey( genres[i] )) {
                hashMap.put( genres[i], plays[i] );
            } else {
                int count = hashMap.get( genres[i] );
                hashMap.replace( genres[i], count + plays[i] );
            }
        }
        Arrays.sort( genresPlays );
       /* for (int i = 0; i < genresPlays.length; i++) {
            System.out.println(genresPlays[i].getGenre() +" "+genresPlays[i].getCount());
        }*/
        GenresPlays[] genresCount=new GenresPlays[hashMap.size()];
        String[] gen=hashMap.keySet().toArray( new String[hashMap.size()] );
        Integer[] genCount=hashMap.values().toArray( new Integer[hashMap.size()] );
        for (int i = 0; i < hashMap.size(); i++) {
            genresCount[i]=new GenresPlays(gen[i], genCount[i]);
        }
        Arrays.sort(genresCount);

        ArrayList<Integer> integers=new ArrayList<>();
        for (int i = 0; i <hashMap.size(); i++) {
            int count=0;
            for (int j = 0; j < genresPlays.length; j++) {
                if(genresPlays[j].getGenre().equals( genresCount[i].getGenre() )){
                    integers.add(  genresPlays[j].getC());
                    count++;
                    if(count>1)break;
                }
            }
        }
        int[] answer = new int[integers.size()];
        Iterator<Integer>iterator=integers.iterator();
        int c=0;
        while(iterator.hasNext()){
            answer[c++]= iterator.next();
        }
        /*for (int i = 0; i < hashMap.size(); i++) {
            System.out.println(genresCount[i].getGenre()+" "+ genresCount[i].getCount());
        }*/
        return answer;
    }
}

class GenresPlays implements Comparable{
    private String genre;
    private int count;
    private int c;

    public GenresPlays(String genre, int count) {
        this.genre = genre;
        this.count = count;
    }

    public GenresPlays(String genre, int count, int c) {
        this.genre = genre;
        this.count = count;
        this.c = c;
    }

    public String getGenre() {
        return genre;
    }

    public int getCount() {
        return count;
    }

    public int getC() {
        return c;
    }

    @Override
    public int compareTo(Object o) {
        GenresPlays genresPlays=(GenresPlays)o;
        if(count>genresPlays.count)return -1;
        else if(count==genresPlays.count)return 0;
        else return 1;
    }
}
