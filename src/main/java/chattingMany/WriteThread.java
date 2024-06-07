package chattingMany;

import java.io.*;
import java.util.Scanner;

public class WriteThread extends Thread{

    private String message;
    private PrintStream printStream;
    private Scanner sc;
    private String name;

    public WriteThread(PrintStream printStream, Scanner sc, String name) {
        this.printStream = printStream;
        this.sc = sc;
        this.name = name;
    }

    public void run() {
        while(true) {
            message = sc.nextLine();
            printStream.println(name+":"+message);
        }
    }

}
