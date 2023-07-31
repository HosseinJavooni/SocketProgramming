package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SimpleServer {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        byte[] buffer = new byte[1024];
        in.read(buffer);
        System.out.println("client says: " + new String(buffer, StandardCharsets.UTF_8).trim());
        out.write("Hello from server!".getBytes(StandardCharsets.UTF_8));
        serverSocket.close();
        socket.close();
    }
}