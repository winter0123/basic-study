package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketMain_Servver {
    public static void main(String[] args) throws IOException {
        try{
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket.getInetAddress());
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
