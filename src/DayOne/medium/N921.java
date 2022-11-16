package DayOne.medium;

public class N921 {
    public int minAddToMakeValid(String s) {

        int score = 0, ans =0;

        for (int i = 0; i < s.length(); i++) {

            score += s.charAt(i) == '(' ? 1 : -1;

            if (score < 0){
                score = 0;
                ans++;
            }
        }
        return ans + score;
    }
}
