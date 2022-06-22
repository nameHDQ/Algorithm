package DayOne.medium;

/**
 * @author hdq
 * @create 2022-05-29 21:34
 */
public class N468 {
    public String validIPAddress(String queryIP) {
        String[] ip4 = queryIP.split("\\.");
        String[] ip6 = queryIP.split(":");
        int count4 = 0;
        int count6 = 0;
        for (int i = 0; i < queryIP.length(); i++) {
            if (queryIP.charAt(i) == '.'){
                count4++;
            }
            if (queryIP.charAt(i) == ':'){
                count6++;
            }
        }
        if (count4 > 3 || count6 > 7){
            return "Neither";
        }



        int len4 = ip4.length;
        int len6 = ip6.length;
        if (len4 ==4 && len6 == 1){
            for (int i = 0; i < 4; i++) {
                String temp = ip4[i];
                int tempLen = temp.length();
                if (tempLen == 0){
                    return "Neither";
                }
                if (temp.length() == 1){
                    // 位数为一
                    if (temp.charAt(0) < '0' || temp.charAt(0) > '9'){
                        return "Neither";
                    }
                }else {
                    // 位数大于3
                    if (temp.length() > 3){
                        return "Neither";
                        // 位数大于1小于等于3
                    }else {
                        // 含有前导0
                        if (temp.charAt(0) == '0'  ){
                            return "Neither";
                        }else {
                            for (int j = 0; j < tempLen; j++) {
                                // 非数字
                                if (temp.charAt(j) < '0' || temp.charAt(j) > '9'){
                                    return "Neither";
                                }
                            }
                            int parseInt = Integer.parseInt(temp);
                            // 是数字 但是值大于255
                            if (parseInt > 255){
                                return "Neither";
                            }
                        }
                    }
                }
            }
            return "IPv4";
        }
        if (len4 ==1 && len6 == 8){
            for (int i = 0; i < 8; i++) {
                String temp = ip6[i];
                if (temp.length() > 4 || temp.equals("")){
                    return "Neither";
                }
                int tempLen = temp.length();
                for (int j = 0; j < tempLen; j++) {
                    if ((temp.charAt(j) <= '9' && temp.charAt(j) >= '0')
                            || (temp.charAt(j) <= 'F' && temp.charAt(j) >= 'A')
                            ||(temp.charAt(j) <= 'f' && temp.charAt(j) >= 'a')){
                        continue;
                    }else {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        }


        return "Neither";
    }

    public static void main(String[] args) {
        String str = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
        System.out.println(new N468().validIPAddress(str));
//        System.out.println(str.split("\\.")[1].equals(""));
        // new N468().validIPAddress(str)
        // "20EE:FGb8:85a3:0:0:8A2E:0370:7334"
    }
}
