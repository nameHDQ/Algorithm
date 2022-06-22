package DayOne.simple;

/**
 * @author hdq
 * @create 2022-06-21 12:40
 */
public class N1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("[.]","[.]");
    }

    public static void main(String[] args) {
        String str = "15256..255";
        System.out.println(new N1108().defangIPaddr(str));
    }
}
