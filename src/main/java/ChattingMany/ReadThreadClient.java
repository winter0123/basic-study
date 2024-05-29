package ChattingMany;

import java.io.*;

public class ReadThreadClient extends Thread{

    BufferedReader br;
    public ReadThreadClient(BufferedReader br2) {
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
