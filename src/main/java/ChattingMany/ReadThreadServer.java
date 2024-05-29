package ChattingMany;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadThreadServer extends Thread{
    BufferedReader br;
    int idx;
    public ReadThreadServer(BufferedReader br, int idx) {
        this.br = br;
        this.idx = idx;
    }

    @Override
    public void run() {
        try {
            while(true) {
                String result;
                result = br.readLine();

                //서버에 client들이 이야기 한 내용 저장(출력)
                System.out.println(result);

                //특정 client가 보낸 메시지를 다른 client에게 전송
                ChatServer.broadcastMessage(result,idx);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
