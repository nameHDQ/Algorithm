package DayOne.DataStruct;

/**
 * @author hdq
 * @create 2022-03-02 16:50
 */
public class test {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello".substring("hello".length() & 1));
        System.out.println(stringBuffer);
        System.out.println("hello".length() & 1);
    }
}
