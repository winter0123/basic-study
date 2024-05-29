package consoleChatting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ReadThread extends Thread{

    BufferedReader br;
    public ReadThread(BufferedReader br2) {
        br = br2;
    }

    @Override
    public void run() {
        try {
            while(true) {
                String result;
                result = br.readLine();
                System.out.println(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
