package DayOne.simple;

public class N14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int maxRes = 0;
        for (int i = 0; i < minLen; i++) {
            String temp = strs[0];
            boolean flag = false;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != temp.charAt(i)){
                    flag = true;
                }
            }
            maxRes = i + 1;
            if (flag) {
                maxRes = maxRes - 1;
                break;
            }
        }
        return maxRes == 0? "" : strs[0].substring(0, maxRes);
    }
}
