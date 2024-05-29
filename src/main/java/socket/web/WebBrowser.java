package socket.web;

import java.io.*;
import java.net.Socket;

public class WebBrowser {
    public static void main(String[] args) throws IOException {

        try{
            Socket clientSocket = new Socket("www.naver.com",80);

            // 서버에게 보내기 위한 준비
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));


            bufferedWriter.write("GET / HTTP/1.1\nHost: www.naver.com\n");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("서버가 보내온 내용");
            String clientMessage = "";
            while ((clientMessage = bufferedReader.readLine()) != null) {
                System.out.println(clientMessage);
            }

            clientSocket.close();//접속 종료
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
