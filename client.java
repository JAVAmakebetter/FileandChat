import myChatRoom.ChatClient;
import superSendFile.acceptFile;

import java.util.Scanner;

public class client {
    public static Scanner input=new Scanner(System.in);
    public static void main(String[] args) {
        try {
            menu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void menu() throws Exception {
        System.out.println("请您输入你想做的事情");
        System.out.println("选择1 或 2 的时候请确保服务端打开！！");
        System.out.println("1.传递文件   2.聊天   3.退出");

        switch (input.nextInt()){
            case 1:
                acceptFile.menu();
                break;
            case 2:
                ChatClient.show();
                break;
            case 3:
                break;
            default:
                System.out.println("您输入错误！！！");
        }
    }
}

