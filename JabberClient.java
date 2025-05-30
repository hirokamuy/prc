import java.io.*;
import java.net.*;
public class JabberClient {
    public static void main(String[] args)
    throws IOException {
        InetAddress addr = InetAddress.getByName("localhost"); // IP アドレスへの変換
        System.out.println("addr = " + addr);
        // System.out.println("port = " + JabberServer.PORT);
        Socket socket = new Socket(addr, Integer.parseInt(args[0])); // ソケットの生成. 引数addrにはIPアドレスを直接代入しても可
        try {
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // データ受信用バッファの設定
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true); // 送信バッファ設定

            for(int i = 0; i < 10; i++) {
                out.println("howdy " + i); // データの送信
                String str = in.readLine(); // データの受信
                System.out.println(str);
            }

            out.println("END");
            
        } finally {
        System.out.println("closing...");
        socket.close();
        }
    }
}