package implement.num10993;

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N;
            N=sc.nextInt();
            Country[] cList = new Country[N];
            double[] maxPower = new double[N];
            int[] status = new int[N];

            for(int i=0; i<N; i++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                double power=sc.nextDouble();
                cList[i] = new Country(x,y,power);
                maxPower[i] = power;
                status[i] = i;
            }

            for(int i=0; i<N; i++) {
                Country a = cList[i];
                for(int j=i+1; j<N; j++) {
                    Country b = cList[j];

                    if(a.power==b.power) continue;

                    double path = a.checkPath(b);
                    double powerA = a.power/path;
                    double powerB = b.power/path;

                    if(a.power<powerB) {
                        if(maxPower[i] == powerB) {
                            status[i]=-1;
                        }
                        if(maxPower[i] < powerB) {
                            maxPower[i]=powerB;
                            status[i]=j;
                        }
                    }

                    if(b.power<powerA) {
                        if(maxPower[j] == powerA) {
                            status[j]=-1;
                        }
                        if(maxPower[j] < powerA) {
                            maxPower[j]=powerA;
                            status[j]=i;
                        }
                    }
                }
            }
            System.out.printf("#%d", test_case);
            for(int i=0; i<N; i++) {
                String answer="K";
                if(status[i]!=i && status[i]!=-1) {
                    int target = status[i];
                    while(status[target]!=target) {
                        target=status[target];
                    }
                    answer = Integer.toString(target+1);
                }
                if(status[i]==-1) {
                    answer="D";
                }
                System.out.printf(" %s", answer);
            }
            System.out.println();
        }
    }
}
class Country{
    int x;
    int y;
    double power;

    Country(int x, int y, double power){
        this.x=x;
        this.y=y;
        this.power=power;
    }

    public double checkPath(Country c) {
        return Math.pow(x-c.x, 2)+Math.pow(y-c.y, 2);
    }
}