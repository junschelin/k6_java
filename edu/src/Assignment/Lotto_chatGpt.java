package Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Lotto_chatGpt {

    public static void main(String[] args) {
        lotto_generator(10000000);
    }

    public static void lotto_generator(int n) {
        Random number = new Random();
        List<HashSet<Integer>> lotSet = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            HashSet<Integer> lotto = new HashSet<>();
            // 6개의 번호 생성
            while (lotto.size() < 6) {
                lotto.add(1 + number.nextInt(45));
            }
            lotSet.add(lotto);
        }

        System.out.println("\nlot hashset을 출력\n");
        
        // lotSet HashSet을 출력
        for (HashSet<Integer> eachLotto : lotSet) {
            System.out.println(eachLotto);
            //구현할 부분
        }
        
        // 당첨번호 추첨
        HashSet<Integer> win = new HashSet<>();
        for (int j = 0; win.size() < 6; j++) { // 6개 번호와 보너스 번호
            win.add(1 + number.nextInt(45));
        }
        int bonus = 1 + number.nextInt(45);
        System.out.print("당첨번호: " + win + " 보너스번호=" + bonus); // 6개의 당첨번호와 보너스번호

        // 6개를 맞힌 복권을 찾는다
        System.out.println();
        winnerLotto(win, bonus, lotSet); // 1등을 찾는다
    }

    static void winnerLotto(HashSet<Integer> w, int bn, List<HashSet<Integer>> lottoSet) {
        // 당첨번호 w에 대하여 발행된 복권 리스트 lottoSet의 모든 원소 elem에 대하여 조사한다
        for (HashSet<Integer> elem : lottoSet) {
            checkWinner(w, bn, elem);
        }
    }

    static void checkWinner(HashSet<Integer> w, int bonus, HashSet<Integer> elem) {
        int count = 0;
        for (Integer num : elem) {
            if (w.contains(num)) {
                count++;
            }
        }

        switch (count) {
            case 0:
            case 1:
            case 2:
                System.out.println("꽝");
                break;
            case 3:
                System.out.println("5등 복권 " + elem + " 당첨번호:" + w);
                break;
            case 4:
                System.out.println("4등 복권 " + elem + " 당첨번호:" + w);
                break;
            case 5:
                if (elem.contains(bonus)) { // 보너스 번호가 일치하는 지를 조사
                    System.out.println("2등 복권 " + elem + " 당첨번호:" + w);
                } else {
                    System.out.println("3등 복권 " + elem + " 당첨번호:" + w);
                }
                break;
            case 6:
                System.out.println("1등 복권 " + elem + " 당첨번호:" + w);
                break;
        }
    }
}
