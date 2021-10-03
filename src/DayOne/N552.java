package DayOne;

/**
 * @author hdq
 * @create 2021-08-18 11:20
 */
public class N552 {
    int countTrue = 0;
    public int checkRecord(int n) {
        int countL = 0;
        int countA = 0;
        countTrue = netChar('A',1,n,0,0)+netChar('L',1,n,0,0)+netChar('P',1,n,0,0);
        return countTrue;
    }
    public int netChar(char c, int i,int n,int countA,int countL){
        if (c == 'A'){
            countA++;
        }
        if (countA >= 2){
            return 0;
        }
        if (c != 'L'){
            countL=0;
        }
        if (c == 'L'){
            countL++;
        }
        if (countL >= 3){
            return 0;
        }
        if (i == n){
            return 1;
        }
        return netChar('A',i+1,n,countA,countL)+netChar('L',i+1,n,countA,countL)+netChar('P',i+1,n,countA,countL);
    }

    public static void main(String[] args) {
        N552 n552 = new N552();
        System.out.println(n552.checkRecord(10));
    }
}
