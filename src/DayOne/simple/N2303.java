package DayOne.simple;

public class N2303 {
    public double calculateTax(int[][] brackets, int income) {
        double sum = 0;
        int pre = 0;
        for (int[] bracket : brackets) {
            if (income >= bracket[0]){
                sum += (bracket[0] - pre) * bracket[1];
            }else {
                sum += (income - pre) * bracket[1];
                break;
            }
            pre = bracket[0];
        }
        return sum/100;
    }

    public static void main(String[] args) {
        int[][] num = {{3,50},{7,10},{12,25}};
        System.out.println(new N2303().calculateTax(num, 10));
    }
}
