package chattingMany;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient3 {
    public static void main(String[] args) {
        Socket clientSocket;
        InputStream inputStream;
        InputStreamReader reader;
        BufferedReader br;

        OutputStream outputStream;
        PrintStream printStream;
        Scanner sc;

        String name = "낮잠자는어피치";

        try {
            clientSocket = new Socket("192.168.0.19", 80);

            outputStream = clientSocket.getOutputStream();
            printStream = new PrintStream(outputStream);
            inputStream = clientSocket.getInputStream();
            reader = new InputStreamReader(inputStream, "UTF-8");
            br = new BufferedReader(reader);
            sc = new Scanner(System.in);

            // 서버에 이름을 전송
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(name);

            ReadThreadClient readThread = new ReadThreadClient(br);
            readThread.start();

            WriteThread writeThread = new WriteThread(printStream,sc,name);
            writeThread.start();

            System.out.print("채팅이 시작되었습니다\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
