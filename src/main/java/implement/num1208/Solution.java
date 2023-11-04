package implement.num1208;

import java.util.Scanner;
class Solution
{
    static int T = 10;
    static int[] boxHeight;
    static int hightPoint=1;
    static int lowPoint=100;
    static int dumpCount;
    static int[] answer = new int[10];
    static int calcTmp;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);

        for(int test_case = 0; test_case < T; test_case++)
        {
            boxHeight = new int[101];
            dumpCount=sc.nextInt();
            for(int i=0; i<100; i++){
                calcTmp = sc.nextInt();
                boxHeight[calcTmp]++;
                if(calcTmp>hightPoint){
                    hightPoint = calcTmp;
                }
                if(calcTmp<lowPoint){
                    lowPoint = calcTmp;
                }
            }
            for(int i=0; i<dumpCount; i++){
                if(hightPoint==lowPoint){
                    break;
                }
                boxHeight[hightPoint]--;boxHeight[hightPoint-1]++;
                boxHeight[lowPoint]--;boxHeight[lowPoint+1]++;
                if(boxHeight[hightPoint]==0){
                    for(int j=hightPoint; j>0; j--){
                        if(boxHeight[j]!=0){
                            hightPoint=j;
                            break;
                        }
                    }
                }
                if(boxHeight[lowPoint]==0){
                    for(int j=lowPoint; j<100; j++){
                        if(boxHeight[j]!=0){
                            lowPoint=j;
                            break;
                        }
                    }
                }
            }
            answer[test_case]=hightPoint-lowPoint;
            hightPoint=1;
            lowPoint=100;
        }

        for(int test_case = 0; test_case < T; test_case++){
            System.out.printf("#%d %d\n", test_case+1, answer[test_case]);
        }
    }
}