package DayOne.medium;

/**
 * @author hdq
 * @create 2022-05-13 9:47
 */
public class MSJD0105 {
    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length();
        int secondLen = second.length();
        if (Math.abs(firstLen - secondLen) > 1) {
            return false;
        }
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < firstLen && j < secondLen) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            }else {
                // 长度相等，只能替换 次数为一
                if (firstLen == secondLen) {
                    i++;
                    j++;
                }else {
                    // 长度不等，只能插入或者删除,次数为一
                    if (firstLen > secondLen) {
                        i++;
                    }else {
                        j++;
                    }
                }
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
