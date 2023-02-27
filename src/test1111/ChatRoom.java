package test1111;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private int id;
    private String title;
    private List<ChatThread> chatThreadList;

    public ChatRoom(int id, String title){
        this.id = id;
        this.title = title;

        chatThreadList = new ArrayList<>();

    }

    public void broadcast(String msg){
        System.out.println("ChatRoom에서 메세지 브로드캐스트" + msg);
        for(int i=0;i<chatThreadList.size();i++){
            ChatThread chatThread = chatThreadList.get(i);
            chatThread.sendMessage(msg);
        }
    }

    // 방에 입장했을때,
    public void addChatThread(ChatThread chatThread){
        chatThreadList.add(chatThread);
        chatThread.setChatRoom(this); //
    }

    public void removeChatThread(ChatThread chatThread){
        chatThreadList.remove(chatThread);
        chatThread.setChatRoom(null);
        broadcast(chatThread.getName() + "님이 퇴장하셨습니다.");
    }



    @Override
    public String toString() {
        return "ChatRoom{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}