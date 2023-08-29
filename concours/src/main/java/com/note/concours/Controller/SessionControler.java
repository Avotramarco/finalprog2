package com.gestion.concour.Controller;

import com.gestion.concour.Service.SessionService;
import com.gestion.concour.model.Session;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SessionControler {
    private SessionService session;

    public SessionControler(SessionService session) {
        this.session = session;
    }
    @GetMapping("/session/{id}")
    public Session showById(@PathVariable int id ){
        return session.FindById(id);
    }
    @GetMapping("/session")
    public List<Session> showAll(){
        return session.FindAll();
    }
    @PostMapping("/post-session")
    public Session post( @RequestBody Session sessions){
        return session.post(sessions);
    }
    @PutMapping("/update-session/{id}")
    public Session update(@PathVariable int id ,@RequestBody Session sessions){
        return  session.update(id,sessions);
    }
    @DeleteMapping("/delete-session/{id}")
    public  List<Session> delete(@PathVariable int id) {
        return session.delete(id);
    }

}
