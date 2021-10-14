package DayOne.hard;

/**
 * @author hdq
 * @create 2021-10-11 9:46
 */
public class N273 {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    //Billion后面九个0 、Million后面6个0、Thousand后面三个0
    String[] thousands = {"Billion","Million", "Thousand",""};
    int[] stride = {1000000000,1000000,1000};
    int[] head = new int[4];
    public String numberToWords(int num) {
        if (num == 0){
            return "Zero";
        }
        String result = "";
        //读取每个的余项
        for (int i = 0; i <4 ; i++) {
            if (i<3){
                head[i] = num/stride[i];
                num %=stride[i];
            }else {
                head[i] = num;
            }
        }
        for (int i = 0; i < head.length; i++) {
            if (head[i] == 0){
                continue;
            }
            //取百 十 个位数字
            int temp= head[i];
            int c1 = temp/100;
            temp %=100;
            int c2 = temp/10;
            temp %=10;
            int c3 = temp;
            if (c1!=0){
                result +=singles[c1] +" Hundred ";
            }
            if (c2==1){
                result +=teens[c3] +" ";

            }else if (c2 == 0){
                if (c3!=0)
                result +=singles[c3] +" ";
            }else {
                result +=tens[c2] +" ";
                if (c3 != 0){
                    result +=singles[c3]+" ";
                }
            }
            result += thousands[i]+" ";
        }

        return result.trim();
    }
public static void main(String[] args) {
    N273 n273 = new N273();
    System.out.println(n273.numberToWords(100000));
}
}
