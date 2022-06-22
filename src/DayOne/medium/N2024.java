package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-29 9:58
 */
public class N2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(getMaxLen(answerKey, k, 'T'), getMaxLen(answerKey, k, 'F'));
    }

    public int getMaxLen(String answerKey, int k, char ch) {
        int n = answerKey.length();
        int sum = 0;
        int ans = 0;
        // 统计滑动窗口内的字符个数
        for (int i = 0, j = 0; j < n; j++) {
            if (answerKey.charAt(j) == ch) {
                sum++;
            }
            while (sum > k) {
                if(answerKey.charAt(i) == ch) {
                    sum--;
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
