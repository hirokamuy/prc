import java.io.*;
import java.net.*;
public class Trial {
    public static void main(String[] args)
    throws IOException {
        InetAddress addr = InetAddress.getByName("localhost"); // IP アドレスへの変換
        System.out.println(addr);
    }
}