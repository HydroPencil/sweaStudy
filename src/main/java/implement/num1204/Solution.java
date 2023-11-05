package implement.num1204;

import java.util.*;

class Solution
{
    private static List<Integer> score;
    private final static int STUDENT_CAPACITY=1000;
    private static int mode=0;
    private static int count=0;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int time=sc.nextInt();
            score = new ArrayList<>();
            for(int i=0; i<STUDENT_CAPACITY; i++){
                score.add(sc.nextInt());
            }
            score.sort(Comparator.reverseOrder());
            int pointMode=score.get(0);
            int numCount=0;

            if(score.get(0)==0){
                System.out.printf("#%d %d\n", test_case, 0);
                continue;
            }

            for(int num:score){
                if(num!=pointMode){
                    if(count<numCount){
                        mode=pointMode;
                        count=numCount;
                    }
                    if(count==numCount&&mode<pointMode){
                        mode=pointMode;
                    }
                    pointMode=num;
                    numCount=0;
                }
                numCount++;
            }
            System.out.printf("#%d %d\n", test_case, mode);
            mode=0;
            count=0;
        }
    }
}