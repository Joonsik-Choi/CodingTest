package Programmers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class 추석트래픽 {
    public static void main(String[] args) {
        String[] s = {
                "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        solution(s);
    }

    public static int solution(String[] lines) {
        ArrayList<LocalDateTime> beging = new ArrayList<>();
        ArrayList<LocalDateTime> finish = new ArrayList<>();
        HashMap<LocalDateTime, Boolean> hashMap = new HashMap<>();
        HashMap<LocalDateTime, LocalDateTime> startEndHash = new HashMap<>();
        int i = 0;
        for (String s : lines) {
            String[] data = s.split(" ");
            int nanoSecond = (int) ((Double.parseDouble(data[2].substring(0, data[2].length() - 1)) - 0.001) * 1000000000);
            beging.add(LocalDateTime.of(LocalDate.parse(data[0]), LocalTime.parse(data[1])).minusNanos(nanoSecond));
            finish.add(LocalDateTime.of(LocalDate.parse(data[0]), LocalTime.parse(data[1])));
            startEndHash.put(beging.get(i), finish.get(i));
            hashMap.put(finish.get(i), false);
            i++;
             //System.out.println(hashMap);
        }
        beging.addAll(finish);
        beging.sort((a, b) -> a.compareTo(b));
        int max = 0;
        System.out.println(startEndHash);
        for (LocalDateTime localDateTime : beging) {
            if (!hashMap.containsKey(localDateTime) || startEndHash.get(localDateTime)==localDateTime) {
                hashMap.replace(startEndHash.get(localDateTime), true);
               // System.out.println(hashMap);
            }
            LocalDateTime[] localDateTimes = hashMap.keySet().stream().filter(a -> a.compareTo(localDateTime.minusNanos(Long.valueOf("999999998"))) == -1).toArray(LocalDateTime[]::new);
            for (LocalDateTime local : localDateTimes) {
                if (hashMap.get(local) == true) {
                    hashMap.replace(local, false);
                }
            }
                max = (int) Math.max(hashMap.values().stream().filter(s -> s == true).count(), max);
                //  System.out.println(max);

        }
            System.out.println(max);
            int answer = max;
            return answer;
        }
    }

