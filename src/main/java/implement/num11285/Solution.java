package implement.num11285;

import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int C;
            int answer = 0;
            C = sc.nextInt();
            for(int i=0; i<C; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(x==0&&y==0) {
                    answer += 10;
                    continue;
                }
                answer += calcPoint(x, y);
            }
            System.out.printf("#%d %d\n",test_case, answer);
        }
    }
    public static int calcPoint(int x, int y) {
        double tmp = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        if(tmp<=20) {
            return 10;
        }
        if(tmp<=40) {
            return 9;
        }
        if(tmp<=60) {
            return 8;
        }
        if(tmp<=80) {
            return 7;
        }
        if(tmp<=100) {
            return 6;
        }
        if(tmp<=120) {
            return 5;
        }
        if(tmp<=140) {
            return 4;
        }
        if(tmp<=160) {
            return 3;
        }
        if(tmp<=180) {
            return 2;
        }
        if(tmp<=200) {
            return 1;
        }
        return 0;
    }
}