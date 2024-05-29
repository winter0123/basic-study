package consoleChatting;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
// 서버 소켓
        ServerSocket serverSocket;

        InputStream inputStream;
        InputStreamReader reader;
        BufferedReader br;

        OutputStream outputStream;
        PrintStream printStream;

        try {
            // 80번 포트로 서버 실행
            serverSocket = new ServerSocket(80);

            // 클라이언트가 접속하면 접속을 허용하는 코드
            // clientSocket에 클라이언트와의 연결 정보 저장
            Socket clientSocket = serverSocket.accept();
            outputStream = clientSocket.getOutputStream();
            printStream = new PrintStream(outputStream);
            inputStream = clientSocket.getInputStream();
            reader = new InputStreamReader(inputStream, "UTF-8");
            br = new BufferedReader(reader);
            Scanner sc;
            sc = new Scanner(System.in);

            while(true) {
                String result;
                result = br.readLine();
                System.out.println(result);

                String message;
                System.out.print("메시지 입력 : ");
                message = sc.nextLine();
                printStream.println(message);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}