package backtracking.num1244;

import java.util.*;

class Solution
{
    static int price;
    static int count;
    static List<Integer> priceDigit;
    static List<Integer> bestPrice;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int answer;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            price=sc.nextInt();
            count=sc.nextInt();
            priceDigit=new ArrayList<>();
            bestPrice=new ArrayList<>();
            madeDigit(price);
            bestPrice.addAll(priceDigit);
            bestPrice.sort(Comparator.reverseOrder());

            if(priceDigit.size()==1){
                System.out.printf("#%d %d\n",test_case, priceDigit.get(0));
                continue;
            }

            answer=bestChoice(0, priceDigit, 0);
            System.out.printf("#%d %d\n",test_case, answer);
        }
    }
    public static void madeDigit(int num){
        if(num>0){
            madeDigit(num/10);
            priceDigit.add(num%10);
        }
    }
    public static void swap(List<Integer> num, int first, int second){
        int tmpNum = num.get(first);
        num.set(first, num.get(second));
        num.set(second, tmpNum);
    }
    public static int madePrice(List<Integer> in){
        int answer=0;
        for(int i=0; i<in.size(); i++){
            answer*=10;
            answer+=in.get(i);
        }
        return answer;
    }
    public static int bestChoice(int depth, List<Integer> num, int target){
        int best=0;

        if(Arrays.equals(num.toArray(),bestPrice.toArray())){
            if(bestPrice.size()==bestPrice.stream().distinct().count()){
                if((count-depth)%2==1){
                    swap(num, priceDigit.size()-2, priceDigit.size()-1);
                    return madePrice(num);
                }
            }
            return madePrice(num);
        }
        if(depth==count||target>=num.size()){
            return madePrice(num);
        }
        if(Objects.equals(num.get(target),bestPrice.get(target))){
            best=bestChoice(depth, num, target+1);
        }
        for(int i=target+1; i<num.size(); i++){
            List<Integer> tmp = new ArrayList<>(num);
            swap(tmp,target,i);
            int calc=bestChoice(depth+1, tmp, target+1);
            if(best<calc){
                best=calc;
            }
        }
        return best;
    }
}