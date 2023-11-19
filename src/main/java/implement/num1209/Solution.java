package implement.num1209;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
    static int[] sum;
    final static int TEST = 10;
    final static int CAPACITY=202;
    final static int ROW_COL=100;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int test_case = 1; test_case <= TEST; test_case++)
        {
            int T=Integer.parseInt(br.readLine());
            sum = new int[CAPACITY];
            for(int i=0; i<ROW_COL; i++) {
                String[] row = br.readLine().split(" ");
                for(int j=0; j<ROW_COL; j++) {
                    int num = Integer.parseInt(row[j]);
                    if(i==j) {sum[200] += num;}
                    if(i+j==100) {sum[201] += num;}
                    sum[j] += num;
                    sum[i+ROW_COL] += num;
                }
            }
            Arrays.sort(sum);
            System.out.printf("#%d %d\n", T, sum[201]);
        }
    }
}