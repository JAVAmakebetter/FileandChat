package myChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("等待客户端连接...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端已连接：" + clientSocket.getInetAddress().getHostAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage, serverMessage;

            while (true) {
                System.out.print("我: ");
                serverMessage = consoleReader.readLine();
                out.println(serverMessage);

                clientMessage = in.readLine();
                System.out.println("客户端: " + clientMessage);

                if (serverMessage.equalsIgnoreCase("exit") || clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            in.close();
            out.close();
            consoleReader.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

