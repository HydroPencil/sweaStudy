package implement.num1206;

import java.util.Scanner;

class Solution
{
    static int T=10;
    static int[] answer = new int[T];
    static int[] building;
    static int buildingCapacity;
    static int calcTmp;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 0; test_case < T; test_case++)
        {
            buildingCapacity = sc.nextInt();
            building = new int[buildingCapacity];

            for(int i=0; i<building.length; i++){
                building[i]=sc.nextInt();
            }

            if(buildingCapacity==4){
                answer[test_case] = 0;
                continue;
            }
            if(buildingCapacity==5){
                answer[test_case] = building[2];
                continue;
            }

            for(int i=2; i<building.length-2; i++){
                calcTmp =building[i]-Math.max(Math.max(building[i-1],building[i-2]),Math.max(building[i+1],building[i+2]));
                if(calcTmp>0){
                    answer[test_case] += calcTmp;
                }
            }
        }
        for(int test_case = 0; test_case < T; test_case++){
            System.out.printf("#%d %d\n",test_case+1, answer[test_case]);
        }
    }
}