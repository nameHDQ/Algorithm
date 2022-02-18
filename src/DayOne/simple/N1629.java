package DayOne.simple;

/**
 * @author hdq
 * @create 2022-01-09 12:49
 */
public class N1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxTime = releaseTimes[0];
        int index = 0;

        char[] chars = keysPressed.toCharArray();
        char res = chars[index];
        for (int i = 1; i < releaseTimes.length; i++) {
            int temp = releaseTimes[i]-releaseTimes[i-1];
            if (temp > maxTime){
                maxTime = temp;
                index = i;
                res = chars[index];
            }else if (temp == maxTime){
                if (chars[i] - 'a' > res-'a'){
                    index = i;
                    res = chars[index];
                }
            }
        }
        return res;
    }
}
