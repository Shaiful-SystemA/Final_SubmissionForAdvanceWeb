package sa41.game.chat;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.enterprise.context.*;
import javax.json.*;
import javax.websocket.Session;


@ApplicationScoped
public class gameRooms {
    
    private Map<String, List<Session>> rooms = new HashMap<>();
    private Lock lock = new ReentrantLock();
    
    public void add(String roomName, Session session) {
        lock.lock();
        try {
            List<Session> sessions = rooms.get(roomName);
            if (null == sessions) {
                sessions = new LinkedList<>();
                rooms.put(roomName, sessions);
            }
            sessions.add(session);
        } finally {
            lock.unlock();
        }
    }//method add()
    
    public Set<String> roomNames() {
        lock.lock();
        try {
            return (rooms.keySet());
        } finally {
            lock.unlock();
        }
        
    }//method roomNames()
    
    public void broadcast(String roomName, JsonObject msg) {
        
        lock.lock();
        
        try {
            List<Session> sessions = rooms.get(roomName);
            if (null == sessions)
                return;
            final String msgToRoom = msg.toString();
            for (Session s: sessions)
                try {
                    s.getBasicRemote().sendText(msgToRoom);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        } finally {
            lock.unlock();
        }
    }//method broadcast()
    
}//Class
