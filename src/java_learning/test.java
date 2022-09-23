package java_learning;

public class test {
    public static void main(String[] args) {

        new Thread(()->{

            try {
                System.out.println("1准备获取");
                A.method("1");
                System.out.println("1获取结束");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }).start();

        new Thread(()->{

            try {
                System.out.println("2准备获取");
                A.method("2");
                System.out.println("2获取结束");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }).start();
    }



}

class A {
    synchronized static void method(String user) throws InterruptedException {
        System.out.println(user + ":OK");
        Thread.sleep(100000L);
        //业务代码
    }
}
