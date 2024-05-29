package ChattingOneByOne;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread  extends Thread{

    PrintStream printStream;
    public WriteThread(PrintStream printStream2) {
        printStream = printStream2;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String message;
            message = sc.nextLine();
            printStream.println(message);
        }
    }
}