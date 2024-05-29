package consoleChatting;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        Socket clientSocket;
        InputStream inputStream;
        InputStreamReader reader;
        BufferedReader br;

        OutputStream outputStream;
        PrintStream printStream;

        try {
            clientSocket = new Socket("192.168.0.19", 80);

            outputStream = clientSocket.getOutputStream();
            printStream = new PrintStream(outputStream);
            inputStream = clientSocket.getInputStream();
            reader = new InputStreamReader(inputStream, "UTF-8");
            br = new BufferedReader(reader);

            ReadThread readThread = new ReadThread(br);
            readThread.start();

            WriteThread writeThread = new WriteThread(printStream);
            writeThread.start();

            System.out.print("채팅이 시작되었습니다\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
