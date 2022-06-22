package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-01 9:53
 */
public class N6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
            if (i < s.length()) sbs[i].append(s.charAt(i));
            int j = i;
            if (i == 0 || i == numRows - 1){
                while ((j + 2 * numRows - 2) < s.length()) {
                    j += 2 * numRows - 2;
                    if (j < s.length()) sbs[i].append(s.charAt(j));
                }
            }else {
                while ((j + 2 * numRows - 2 - 2 * i) < s.length() || (j + 2 * numRows - 2 ) < s.length()) {
                    if ((j + 2 * numRows - 2 - 2 * i) < s.length()) {
                        sbs[i].append(s.charAt(j + 2 * numRows - 2 - 2 * i));
                    }
                    if ((j + 2 * numRows - 2 ) < s.length()){
                        sbs[i].append(s.charAt(j + 2 * numRows - 2));
                    }
                    j += 2 * numRows - 2;
                }
            }
//            System.out.println(sbs[i]);
            sb.append(sbs[i]);
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        System.out.println(new N6().convert("PAYPALISHIRING", 4));
    }
}
