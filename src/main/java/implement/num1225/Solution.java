package implement.num1225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Solution
{
    final static int TEST_NUM = 10;
    final static int EN_NUM = 5;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <=TEST_NUM ; test_case++)
        {
            int T=Integer.parseInt(br.readLine());
            ArrayList<Integer> code = new ArrayList<>();
            String[] inCode = br.readLine().split(" ");
            for(String in : inCode) {
                code.add(Integer.parseInt(in));
            }

            boolean retry = true;
            while(retry) {
                for(int i=1; i<=EN_NUM; i++) {
                    int tmp = code.remove(0);
                    tmp -= i;
                    if(tmp<=0) {
                        retry=false;
                        code.add(0);
                        break;
                    }
                    code.add(tmp);
                }
            }
            System.out.printf("#%d ", T);
            for(int i : code) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}