package com.note.concours.Service;

import com.note.concours.Repository.SessionDAO;
import com.note.concours.model.Session;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SessionService {
    private SessionDAO sessions;
    public SessionService(SessionDAO sessions) {
        this.sessions = sessions;
    }
    public Session FindById(int id ){
        return sessions.FindById(id);
    }
    public List<Session> FindAll(){
        return sessions.FindAll();
    }
    public Session post(Session session){
        return sessions.register(session);
    }
    public Session update(int id , Session session){
        return sessions.update(id,session);
    }

    public List<Session> delete(int id ){
        return sessions.delete(id);
    }
}
