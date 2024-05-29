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
            Scanner sc;
            sc = new Scanner(System.in);

            while(true) {
                String message;
                System.out.print("메시지 입력 : ");
                message = sc.nextLine();
                printStream.println(message);

                String result;
                result = br.readLine();
                System.out.println(result);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
