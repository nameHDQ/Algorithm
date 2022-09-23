package DayOne.simple;

public class JZ05 {
    public String replaceSpace(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            if (i == s1.length - 1){
                stringBuilder.append(s1[i]);
            }else {
                stringBuilder.append(s1[i]).append("%20");
            }
        }
        return stringBuilder.toString();
    }
}
