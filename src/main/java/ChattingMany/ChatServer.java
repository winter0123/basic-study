package ChattingMany;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatServer {

    public static List<Handler> clients = new ArrayList<>();;

    public void ServerRun() {
        // 서버 소켓
        ServerSocket serverSocket;

        InputStream inputStream;
        InputStreamReader reader;
        BufferedReader br;

        OutputStream outputStream;
        PrintStream printStream;
        Scanner sc;
        try {
            // 80번 포트로 서버 실행
            serverSocket = new ServerSocket(80);
            int i=1;

            // 클라이언트가 접속하면 접속을 허용하는 코드
            // clientSocket에 클라이언트와의 연결 정보 저장
            while(true){
                Socket clientSocket = serverSocket.accept();

                // 클라이언트의 이름 읽기
                BufferedReader readerName = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String name = readerName.readLine();

                Handler chatHandler = new Handler(clientSocket, i, name);
                clients.add(chatHandler);
                chatHandler.start();

                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
                i++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //메시지를 보낸 client를 빼고 다른 client에게 전송
    public static void broadcastMessage(String message, int idx) {
        for(int i=0; i<clients.size(); i++){
            if(clients.get(i).idx != idx)
                clients.get(i).sendMessage(message, idx);
        }
    }


    public class Handler extends Thread{
        private Socket clientSocket;

        private InputStream inputStream;
        private InputStreamReader reader;
        private BufferedReader br;

        private OutputStream outputStream;
        private PrintStream printStream;
        private Scanner sc;
        private Integer idx;
        private String name;

        Handler(Socket socket, int idx, String name) {
            this.clientSocket = socket;
            this.idx = idx;
            this.name = name;
        }

        public void run() {
            try {
                outputStream = clientSocket.getOutputStream();
                printStream = new PrintStream(outputStream);
                inputStream = clientSocket.getInputStream();

                reader = new InputStreamReader(inputStream, "UTF-8");
                br = new BufferedReader(reader);
                sc = new Scanner(System.in);

                printStream = new PrintStream(clientSocket.getOutputStream(), true);

                //client의 전체 채팅내용 저장용
                ReadThreadServer readThread = new ReadThreadServer(br, idx);
                readThread.start();

                //서버는 작성할 필요가 없음
                //WriteThread writeThread = new WriteThread(printStream,sc,name);
                //writeThread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendMessage(String message, int idx){
            printStream.println(message);
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.ServerRun();
    }

}
