package implement.num1221;

import java.util.Arrays;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.InputStreamReader;

enum Number{
    ZRO,ONE,TWO,THR,FOR,FIV,SIX,SVN,EGT,NIN;
}

class Solution
{
    static Number[] numbers;
    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String T;
        T=bf.readLine();

        for(int test_case = 1; test_case <= Integer.parseInt(T); test_case++)
        {
            String[] numberImf = bf.readLine().split(" ");
            numbers = new Number[Integer.parseInt(numberImf[1])];
            String[] numberIn = bf.readLine().split(" ");

            for(int i=0; i<numbers.length; i++) {
                numbers[i] = Number.valueOf(numberIn[i]);
            }

            Arrays.sort(numbers, new Comparator<Number>() {
                @Override
                public int compare(Number num1, Number num2) {
                    return num1.ordinal() - num2.ordinal();
                }
            });

            System.out.println(numberImf[0]);
            String result = "";
            for(Number n : numbers) {
                result += n.name() + " ";
            }
            System.out.println(result);
        }
    }
}