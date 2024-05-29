package thread;

public class Thread02 implements Runnable{
    @Override
    public void run() {
        int i=1;
        try {
            while(i<=10) {
                System.out.println("스레드implements :"+i);
                Thread.sleep(100);
                i++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
