package implement.num10965;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Solution
{
    static int capacity = 10000001;
    static boolean[] sieve = new boolean[capacity];
    public static void main(String args[]) throws Exception
    {
        List<Integer> decimal = new ArrayList<>();
        for(int i=2; i<=Math.sqrt(capacity); i++){
            if(sieve[i]){
                continue;
            }
            decimal.add(i);
            if(Math.sqrt(i)%1 != 0){
                for(int j=i*2; j<capacity; j +=i){
                    if((j)%i==0){
                        sieve[j]=true;
                    }
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int n;
        int[] answerArr = new int[T];

        for(int test_case = 0; test_case < T; test_case++)
        {
            n = sc.nextInt();
            answerArr[test_case]=1;

            if(!sieve[n]){
                answerArr[test_case]=n;
                continue;
            }

            for(int i : decimal){
                if(i>n){
                    break;
                }
                int count = 0;
                while (n%i==0){
                    n/=i;
                    count++;
                }
                if(count%2==1){
                    answerArr[test_case] *= i;
                }
                if(!sieve[n]){
                    answerArr[test_case] *= n;
                    break;
                }
            }
        }

        for(int i=0; i<answerArr.length;i++){
            System.out.printf("#%d %d\n", i+1, answerArr[i]);
        }
    }
}