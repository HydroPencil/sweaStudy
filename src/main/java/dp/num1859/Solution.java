package dp.num1859;

import java.util.*;
import java.util.Scanner;

class Solution {
    private static Long days;
    private static List<Long> dayPrice;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            dayPrice = new ArrayList<>();
            days = sc.nextLong();
            for (int i = 0; i < days; i++) {
                dayPrice.add(sc.nextLong());
            }
            ListIterator<Long> iterator = dayPrice.listIterator(dayPrice.size());
            long count = 0;
            long maxPrice = (long)iterator.previous();
            long purchase = 0;
            long revenue = 0;
            while(iterator.hasPrevious()){
                long now = iterator.previous();
                if(maxPrice<now){
                    if(count != 0){
                        revenue += maxPrice *count - purchase;
                    }
                    count = 0;
                    maxPrice = now;
                    purchase = 0;
                    continue;
                }
                count++;
                purchase += now;
            }
            revenue += maxPrice*count - purchase;
            System.out.printf("#%d %d\n",test_case, revenue);
        }
    }
}