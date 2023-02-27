package test1111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
public class ChatThread extends Thread {

    private String name;
    private BufferedReader br;
    private PrintWriter pw;
    private Socket socket;
    ChatRoomService chatRoomService;
    private ChatRoom chatRoom;

    public ChatThread(Socket socket, ChatRoomService chatRoomService)throws Exception {
        this.socket =socket;
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw =  new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.br = br;
        this.pw = pw;
        this.name = br.readLine();
        this.chatRoomService = chatRoomService;
    }

    public void sendMessage(String msg){
        System.out.println("sendMessage : " + msg);
        pw.println(msg);
        pw.flush();
    }

    @Override
    public void run() {

        // ChatThread는 사용자가 보낸 메세지를 읽어들여서,
        // 접속된 모든 클라이언트에게 메세지를 보낸다.
        // 나를 제외한 모든 사용자에게 "00님이 연결되었습니다"..
        System.out.println("ChatThread" + Thread.currentThread().getName());
        try{
            String line = null;

            while((line = br.readLine()) != null){
                System.out.println("line -" + line);
                if("/quit".equals(line)){
                    break;
                }
                else if(line.indexOf("/create") == 0){ // 방 생성 요청

                    if(line.length() >= 9) {
                        String title = line.substring(8);
                        ChatRoom chatRoom = chatRoomService.createChatRoom(title);
                        this.chatRoom = chatRoom;
                        this.chatRoom.addChatThread(this);
                    }else{
                        System.out.println("방 제목을 입력하세요.");
                    }
                }
                else if(line.indexOf("/join") == 0){ // 방 입장
                    try {
                        chatRoomService.join(Integer.parseInt(line.substring(6)), this);
                    } catch(Exception ex){
                        pw.println("방 번호가 잘못 되었습니다.");
                        pw.flush();
                    }
                    }
                else if(line.indexOf("/exit") == 0){ // 방에서 빠져나가기
                    this.chatRoom.removeChatThread(this);
                }

                else if(line.indexOf("/list") == 0){ // 방에서 빠져나가기
                    Iterator<ChatRoom> chatRoomIterator= chatRoomService.getChatRoomIterator();
                    while(chatRoomIterator.hasNext()){
                        ChatRoom cr = chatRoomIterator.next();
                        pw.println(cr.getId() + " - " + cr.getTitle());
                        pw.flush();
                    }
                }
                else if(this.chatRoom != null){
                    System.out.println("속한 방에 브로드캐스트 합니다."+ line);
                    chatRoom.broadcast(line);

                }else{
                    System.out.println("방에 들어와있지 않아요. " + line);
                }
                // 내가 방에 있을 경우, 해당 방에 있는 사용자에게 메세지 전송하기.
            }
        }catch(Exception ex){
            // ChatThread가 연결이 끊어졌다는 것.
            //ex.printStackTrace();
        }
    }

    public void setChatRoom(ChatRoom chatRoom) {
        this.chatRoom = chatRoom;
    }


}