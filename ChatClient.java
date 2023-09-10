package myChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        show();
    }
    public static void show(){
        try {
            Socket socket = new Socket("127.0.0.1", 12345);
            System.out.println("已连接到服务器");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage, clientMessage;

            while (true) {
                serverMessage = in.readLine();
                System.out.println("服务器: " + serverMessage);

                System.out.print("我: ");
                clientMessage = consoleReader.readLine();
                out.println(clientMessage);

                if (serverMessage.equalsIgnoreCase("exit") || clientMessage.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            in.close();
            out.close();
            consoleReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

