package exam.help;

import org.junit.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

/**
 * @author hdq
 * @create 2022-06-06 14:39
 */
public class test {
    public String[] N3Url(String str){

        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            String pathname = "D:\\twitter\\13_9_6\\dataset\\en\\input.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            Map<String, int[]>[] map = new Map[7];
            line = br.readLine();
            while (line != null) {
                String[] split = line.split(" ");
                for (int i = 0; i < 7; i++) {
                    String date = getDate(i);
                    if (!split[0].equals(date)){
                       continue;
                    }
                    map[i] = new HashMap<>();
                    int[] temp;
                    if (map[i].containsKey(split[4])) {
                        temp = map[i].get(split[4]);
                    }else {
                        temp = new int[2];
                    }
                    if (split[2] == "error"){
                        temp[0]++;
                    }
                    temp[1]++;
                    map[i].put(split[4], temp);
                }
                line = br.readLine(); // 一次读入一行数据
            }// 排序
            List<Map.Entry<String,Integer>> list = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
//                list.add(map[i].entrySet());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }




        return null;
    }


    public String getDate(int start){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, - start);
        Date d = c.getTime();
        return sdf.format(d);
    }

    public static void main(String[] args) {
        System.out.println(new test().getDate(0));
    }
}
