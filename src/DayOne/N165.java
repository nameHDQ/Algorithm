package DayOne;

/**
 * @author hdq
 * @create 2021-09-01 10:09
 */
public class N165 {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int len1 = str1.length;
        int len2 = str2.length;
        int i=0,j=0;
        while (i< len1 || j < len2 ){
            int a =0,b= 0;
            if (i < len1) {
                a=Integer.parseInt(str1[i++]);
            }
            if (j <len2){
                b = Integer.parseInt(str2[j++]);
            }
            if (a!=b){
                if ( a > b){
                    return 1;
                }
                if (a <b){
                    return  -1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        N165 n165 = new N165();
        System.out.println(n165.compareVersion("7.5.2.4", "7.5.3"));
    }
}
