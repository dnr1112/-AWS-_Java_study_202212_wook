package test1111;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);

        // 동시성 문제를 해결하기 위해서..!
        ChatRoomService chatRoomService = new ChatRoomService();

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("접속 : " + socket);
            ChatThread chatThread = new ChatThread(socket, chatRoomService);
            chatThread.start();
        }
    }
}