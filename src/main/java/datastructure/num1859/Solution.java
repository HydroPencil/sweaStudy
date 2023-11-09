package datastructure.num1859;

import java.util.*;
import java.util.Scanner;

class Solution {
    private static int days;
    private static List<Integer> dayPrice;
    private static List<Integer> highPrice;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int highPoint=0;
            int count=0;
            int spend=0;
            int revenue=0;
            dayPrice = new ArrayList<>();
            days = sc.nextInt();
            for (int i = 0; i < days; i++) {
                dayPrice.add(sc.nextInt());
            }
            highPrice = new ArrayList<>(dayPrice);
            highPrice.sort(Comparator.reverseOrder());

            for(int i : dayPrice){
                if(i == highPrice.get(highPoint)){
                    if (count != 0) {
                        revenue+=count*highPrice.get(highPoint)-spend;
                    }
                    highPoint++;
                    count=0; spend=0;
                    continue;
                }
                spend+=i;
                count++;
            }
            System.out.printf("#%d %d\n",test_case, revenue);
        }
    }
}