package thread;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        // 쓰레드를 만드는 방법
        // 1.Thread 클래스를 상속받아서 만드는 방법
        // 2.Runnable 인터페이스의 구현체를 만들어서 사용하는 방법

        Thread01 t01 = new Thread01();
        Runnable r02 = new Thread02();
        Thread t02 = new Thread(r02);
        t01.start();
        t02.start();

//        t01.run();

        int i=0;
        while(i<=10) {
            System.out.println("메인 : " + i);
            Thread.sleep(100);
            i++;
        }
    }
}
