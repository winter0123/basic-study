package socket;

import java.io.IOException;
import java.net.Socket;

public class SoketMain_Client {
    public static void main(String[] args) throws IOException {
        try{
            Socket clientSocket = new Socket("192.168.0.19", 9999);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
