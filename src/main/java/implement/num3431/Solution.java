package implement.num3431;

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
            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();
            int answer = 0;
            if(X<L) {
                answer = L-X;
            }
            if(U<X) {
                answer = -1;
            }
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}