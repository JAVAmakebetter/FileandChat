import myChatRoom.ChatServer;
import superSendFile.sendFile;

import java.util.Scanner;

public class serve {
    public static Scanner input = new Scanner(System.in);
    public static boolean Flag = true;

    public static void main(String[] args) {
        try {
            menu();
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
    }

    public static void menu() throws Exception {
        System.out.println("请您输入你想做的事情");
        System.out.println("1.传递文件   2.聊天   3.退出");
        switch (input.nextInt()) {
            case 1:
                sendFile.menu();
                break;
            case 2:
                ChatServer.menu();
                break;
            case 3:
                while (Flag) {
                    System.out.println("您确定要退出吗，退出请按Y，不退出请按N");
                    char userChoose = input.next().toUpperCase().charAt(0);
                    switch (userChoose) {
                        case 'Y':
                            Flag = false;
                            break;
                        case 'N':
                            menu();
                        default:
                            break;
                    }
                }
                break;
            default:
                System.out.println("您输入错误！！！，请重新输入");
                menu();
        }
    }
}
