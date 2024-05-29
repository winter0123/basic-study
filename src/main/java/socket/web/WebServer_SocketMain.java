package socket.web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer_SocketMain {

    public static void main(String[] args) {
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

            inputStream = clientSocket.getInputStream();
            reader = new InputStreamReader(inputStream, "UTF-8");
            br = new BufferedReader(reader);

            String result;
            result = br.readLine();

            //  split()은 result에 저장된 글자를 " " 공백으로 자르는 코드
            //  ex) "abc def ghi" 를 공백으로 자르면 "abc" 1개 "def" 1개 "ghi 1개, 총 3개의 글자 배열이  된다.
            if( result.split(" ")[1].equals("/test.html")) {
                System.out.println("test.html 보여주기");
            } else if(result.split(" ")[1].equals("/abc.html")) {
                System.out.println("다른거 보여주기");
            }

            FileStream f = new FileStream();

            outputStream = clientSocket.getOutputStream();
            printStream = new PrintStream(outputStream);

            printStream.println("HTTP/1.1 200 OK");
            printStream.println("Content-Length: ");
            printStream.println("Content-Type: text/html");
            printStream.println("");

            printStream.println(f.readFile());

            printStream.println(/* 클라이언트가 요청한 파일의 내용을 읽어서 전달*/);
            printStream.println("");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
