package com.shine.web.websocket;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 通知 webSocket
 */
@ServerEndpoint(value = "/websocket", configurator = HttpSessionConfigurator.class)
@Component
public class NoticeWebSocket {

    private static int onlineCount = 0;


    /**
     * 线程安全map
     * 用user_id 做Key
     * session 对应每一个会话
     */
    private static ConcurrentHashMap<String,NoticeWebSocket> sessionWebSocketMap = new ConcurrentHashMap<String,NoticeWebSocket>();
    private static CopyOnWriteArraySet<NoticeWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen (Session session, EndpointConfig config){

        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        System.out.println(httpSession.toString());
        System.out.println(httpSession.toString());
        System.out.println(httpSession.toString());
        System.out.println(httpSession.toString());
        System.out.println(httpSession.toString());
        System.out.println(httpSession.toString());
        System.out.println(httpSession.toString());
        httpSession.getAttribute("userId");
        this.session = session;
        //会话的当前空闲超时时间，以毫秒为单位。 零或负值表示无限超时。
        System.out.println("当前用户最大超时时间为:" + session.getMaxIdleTimeout() + "毫秒");
        System.out.println("当前用户文本最大缓冲区大小:" + session.getMaxTextMessageBufferSize() + "字符");
        //依赖于从一个安全的随机来源产生,作为唯一标识。
        System.out.println("当前用户会话ID:" + session.getId());
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新链接加入!当前在线人数为" + getOnlineCount());
    }

    @OnClose
    public void onClose (){
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一链接关闭!当前在线人数为" + getOnlineCount());
    }

    @OnMessage
    public void onMessage (String message, Session session) throws IOException {
        System.out.println("来自客户端的消息:" + message);
        // 群发消息
        for ( NoticeWebSocket item : webSocketSet ){
            item.sendMessage(message);
        }
    }

    public void sendMessage (String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized  int getOnlineCount (){
        return NoticeWebSocket.onlineCount;
    }

    public static synchronized void addOnlineCount (){
        NoticeWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount (){
        NoticeWebSocket.onlineCount--;
    }

}
