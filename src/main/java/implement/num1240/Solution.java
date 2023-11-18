package implement.num1240;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    final static int ENCRYPT_LENGTH=56;
    final static int ENCRYPT_ONE_DIGIT=7;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] row_col = br.readLine().split(" ");
            int row = Integer.parseInt(row_col[0]);
            int col = Integer.parseInt(row_col[1]);
            String encrypt="";

            for(int i=0; i<row; i++) {
                String line = br.readLine();
                if(line.contains("1") && encrypt.isEmpty()) {
                    for(int j=col-1; j>=0; j--) {
                        if(line.charAt(j)=='1') {
                            encrypt = line.substring(j-ENCRYPT_LENGTH+1, j+1);
                            break;
                        }
                    }
                }
            }

            int sum = 0;
            int odd = 0;
            int even = 0;

            for(int i=0; i<=ENCRYPT_ONE_DIGIT; i++) {
                String one = encrypt.substring(i*ENCRYPT_ONE_DIGIT, (i+1)*ENCRYPT_ONE_DIGIT);
                int tmp = decrypt(one);
                if(i%2==0) {
                    odd += tmp;
                } else {
                    even += tmp;
                }
                sum += tmp;
            }

            if((odd*3+even)%10!=0) {
                System.out.printf("#%d %d\n", test_case, 0);
            } else {
                System.out.printf("#%d %d\n", test_case, sum);
            }

        }
    }
    public static int decrypt(String in) {
        switch(in) {
            case "0001101":
                return 0;
            case "0011001":
                return 1;
            case "0010011":
                return 2;
            case "0111101":
                return 3;
            case "0100011":
                return 4;
            case "0110001":
                return 5;
            case "0101111":
                return 6;
            case "0111011":
                return 7;
            case "0110111":
                return 8;
            case "0001011":
                return 9;
        }
        return 0;
    }
}