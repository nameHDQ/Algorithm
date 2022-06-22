package DayOne.medium;

/**
 * @author hdq
 * @create 2022-03-13 19:23
 */
public class N393 {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            // 小于128的数据，直接跳过 直接合法，计算下一个字节
            if (data[i] < 128) {
                continue;
            }else if (data[i] >= 192 && data[i] <= 223) {
                // 如果第一个字节是110xxxxx，则第二个字节必须是10xxxxxx，否则不合法
                if (i + 1 < data.length && data[i + 1] >= 128 && data[i + 1] <= 191) {
                    i++;
                }else {
                    return false;
                }
            }else if (data[i] >= 224 && data[i] <= 239) {
                // 如果第一个字节是1110xxxx，则第二个字节必须是10xxxxxx，第三个字节必须是10xxxxxx，否则不合法
                if (i + 2 < data.length && data[i + 1] >= 128 && data[i + 1] <= 191 && data[i + 2] >= 128 && data[i + 2] <= 191) {
                    i += 2;
                }else {
                    return false;
                }
            }else if (data[i] >= 240 && data[i] <= 247) {
                // 如果第一个字节是11110xxx，则第二个字节必须是10xxxxxx，第三个字节必须是10xxxxxx，第四个字节必须是10xxxxxx，否则不合法
                if (i + 3 < data.length && data[i + 1] >= 128 && data[i + 1] <= 191 && data[i + 2] >= 128 && data[i + 2] <= 191 && data[i + 3] >= 128 && data[i + 3] <= 191) {
                    i += 3;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N393 n393 = new N393();
        int[] data = {197,130,1};
        System.out.println(n393.validUtf8(data));
        System.out.println(Integer.toString(223,2));
    }
}
