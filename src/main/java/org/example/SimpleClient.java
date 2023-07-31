package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        out.write("Hi Server!".getBytes(StandardCharsets.UTF_8));
        byte[] response = new byte[1024];
        in.read(response);
        System.out.println("Server says: " + new String(response, StandardCharsets.UTF_8).trim());
        socket.close();
    }
}
